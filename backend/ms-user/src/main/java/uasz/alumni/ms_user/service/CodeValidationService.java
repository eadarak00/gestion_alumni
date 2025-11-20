package uasz.alumni.ms_user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import uasz.alumni.ms_user.common.exception.CodeEnvoiException;
import uasz.alumni.ms_user.common.utils.EmailUtils;
import uasz.alumni.ms_user.model.CodeValidation;
import uasz.alumni.ms_user.model.Utilisateur;
import uasz.alumni.ms_user.repository.CodeValidationRepository;
import uasz.alumni.ms_user.repository.UtilisateurRepository;

import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Objects;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CodeValidationService {

    private final CodeValidationRepository codeValidationRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final EmailService emailService;

    @Value("${app.email.code-expiration-minutes:15}")
    private int codeExpirationMinutes;

    private static final SecureRandom RANDOM = new SecureRandom();


    /**
     * Génère un code OTP sécurisé à 6 chiffres
     */
    private String genererCode() {
        return String.format("%06d", RANDOM.nextInt(1_000_000));
    }


    /**
     * Crée et envoie un code OTP pour un utilisateur.
     */
    @Transactional
    public void creerEtEnvoyerCode(Utilisateur utilisateur) {

        Instant now = Instant.now();
        Instant expiration = now.plus(codeExpirationMinutes, ChronoUnit.MINUTES);
        String code = genererCode();

        log.info("Génération d'un code pour {}", utilisateur.getEmail());
        // Récupérer le dernier code existant
        Optional<CodeValidation> existing = 
                codeValidationRepository.findTopByUtilisateurOrderByDateCreationDesc(utilisateur);

        CodeValidation validation = Objects.requireNonNull(existing
                .map(cv -> {
                    cv.setCode(code);
                    cv.setDateExpiration(expiration);
                    cv.setUtilise(false);
                    return cv;
                })
                .orElseGet(() -> CodeValidation.builder()
                        .code(code)
                        .utilisateur(utilisateur)
                        .dateCreation(now)
                        .dateExpiration(expiration)
                        .utilise(false)
                        .build()
                ));

        codeValidationRepository.save(validation);

        try {
            emailService.envoyerHtml(
                    utilisateur.getEmail(),
                    EmailUtils.sujetValidationInscription(),
                    EmailUtils.corpsValidationInscriptionHTML(utilisateur.getPrenom(), code)
            );
            log.info("Code envoyé à l'adresse : {}", utilisateur.getEmail());

        } catch (MessagingException e) {
            log.error("Échec de l'envoi de l'email pour {}", utilisateur.getEmail(), e);
            throw new CodeEnvoiException("Impossible d'envoyer le code de validation");
        }
    }


    /**
     * Valide un OTP envoyé à l'email d'un utilisateur
     */
    @Transactional
    public boolean validerCode(String email, String code) {

        Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur introuvable"));

        Instant now = Instant.now();

        Optional<CodeValidation> codeValide =
                codeValidationRepository.findByCodeAndUtilisateurAndUtiliseFalseAndDateExpirationAfter(
                        code,
                        utilisateur,
                        now
                );

        if (codeValide.isEmpty()) {
            log.warn("Code invalide ou expiré pour {}", email);
            return false;
        }

        CodeValidation validation = codeValide.get();
        validation.setUtilise(true);
        codeValidationRepository.save(validation);

        utilisateur.setActif(true);
        utilisateurRepository.save(utilisateur);

        log.info("Utilisateur {} activé avec succès", email);
        return true;
    }


    /**
     * Suppression automatique des codes expirés
     */
    @Transactional
    public void supprimerCodesExpires() {
        
        List<CodeValidation> expires =
                codeValidationRepository.findAll().stream()
                        .filter(CodeValidation::isExpired)
                        .filter(c -> !c.isUtilise())
                        .toList();

        if (!expires.isEmpty()) {
            codeValidationRepository.deleteAll(expires);
            log.info("{} codes expirés supprimés", expires.size());
        }
    }
}
