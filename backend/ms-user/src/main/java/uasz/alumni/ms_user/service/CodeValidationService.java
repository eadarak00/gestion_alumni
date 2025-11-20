package uasz.alumni.ms_user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.mail.MessagingException;
import uasz.alumni.ms_user.common.utils.EmailUtils;
import uasz.alumni.ms_user.model.CodeValidation;
import uasz.alumni.ms_user.model.Utilisateur;
import uasz.alumni.ms_user.repository.CodeValidationRepository;
import uasz.alumni.ms_user.repository.UtilisateurRepository;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CodeValidationService {

    private final CodeValidationRepository codeValidationRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final EmailService emailService;

    @Value("${app.email.code-expiration-minutes:15}")
    private int codeExpirationMinutes;

    private static final SecureRandom random = new SecureRandom();

    /**
     * Génère un code de validation à 6 chiffres
     */
    private String genererCode() {
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    /**
     * Crée et envoie un code de validation pour un utilisateur
     */
    public void creerEtEnvoyerCode(Utilisateur utilisateur) {
        // Générer le code
        String code = genererCode();
        
        // Créer l'entité CodeValidation
        CodeValidation codeValidation = new CodeValidation();
        codeValidation.setCode(code);
        codeValidation.setUtilisateur(utilisateur);
        codeValidation.setDateCreation(LocalDateTime.now());
        codeValidation.setDateExpiration(LocalDateTime.now().plusMinutes(codeExpirationMinutes));
        codeValidation.setUtilise(false);
        
        // Sauvegarder dans la base de données
        codeValidationRepository.save(codeValidation);
        
        // Envoyer l'email
        String nomComplet = utilisateur.getPrenom() + " " + utilisateur.getNom();
        try {
            emailService.envoyerHtml(
                    utilisateur.getEmail(),
                    EmailUtils.sujetValidationInscription(),
                    EmailUtils.corpsValidationInscriptionHTML(nomComplet, code));
            System.out.println("Email envoyé avec le code : " + code);
        } catch (MessagingException e) {
            System.err.println("Échec de l'envoi du mail à : " + utilisateur.getEmail());
            e.printStackTrace();
        }
    }

    /**
     * Valide un code pour un utilisateur
     */
    public boolean validerCode(String email, String code) {
        // Récupérer l'utilisateur (uniquement non supprimé)
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByEmailAndDeletedFalse(email);
        if (utilisateurOpt.isEmpty()) {
            log.warn("Utilisateur non trouvé ou supprimé pour l'email : {}", email);
            return false;
        }

        Utilisateur utilisateur = utilisateurOpt.get();

        // Récupérer le code de validation
        Optional<CodeValidation> codeValidationOpt = codeValidationRepository
                .findByCodeAndUtilisateur(code, utilisateur);

        if (codeValidationOpt.isEmpty()) {
            log.warn("Code de validation non trouvé pour l'utilisateur : {}", email);
            return false;
        }

        CodeValidation codeValidation = codeValidationOpt.get();

        // Vérifier si le code est valide
        if (!codeValidation.isValide()) {
            log.warn("Code de validation expiré ou déjà utilisé pour : {}", email);
            return false;
        }

        // Marquer le code comme utilisé
        codeValidation.setUtilise(true);
        codeValidationRepository.save(codeValidation);

        // Activer le compte utilisateur
        utilisateur.setActif(true);
        utilisateurRepository.save(utilisateur);

        log.info("Compte activé avec succès pour : {}", email);
        return true;
    }

    /**
     * Renvoie un code de validation (si l'ancien est expiré ou utilisé)
     */
    public void renvoyerCode(String email) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByEmail(email);
        if (utilisateurOpt.isEmpty()) {
            throw new RuntimeException("Utilisateur non trouvé");
        }

        Utilisateur utilisateur = utilisateurOpt.get();

        // Vérifier si le compte est déjà activé
        if (Boolean.TRUE.equals(utilisateur.getActif())) {
            throw new RuntimeException("Le compte est déjà activé");
        }

        // Créer et envoyer un nouveau code
        creerEtEnvoyerCode(utilisateur);
    }
}