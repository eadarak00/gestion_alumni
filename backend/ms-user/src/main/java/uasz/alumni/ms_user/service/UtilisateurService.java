package uasz.alumni.ms_user.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import uasz.alumni.ms_user.dto.LoginDto;
import uasz.alumni.ms_user.dto.RegisterDto;
import uasz.alumni.ms_user.entity.Utilisateur;
import uasz.alumni.ms_user.repository.UtilisateurRepository;
import uasz.alumni.ms_user.security.JwtService;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final String pepper;

    public UtilisateurService(
            UtilisateurRepository utilisateurRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            @Value("${app.pepper:}") String pepper
    ) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.pepper = pepper == null ? "" : pepper;
    }

    public Utilisateur register(RegisterDto dto) {
        if (utilisateurRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalStateException("Email déjà utilisé.");
        }

        Utilisateur u = new Utilisateur();
        u.setEmail(dto.getEmail());
        u.setUsername(dto.getUsername());
        u.setRole(dto.getRole() == null ? "USER" : dto.getRole());

        String hashed = passwordEncoder.encode(dto.getPassword() + pepper);
        u.setPasswordHash(hashed);

        u.setEnabled(true);
        utilisateurRepository.save(u);

        return u;
    }

    public String login(LoginDto dto) {
        Utilisateur u = utilisateurRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(dto.getPassword() + pepper, u.getPasswordHash())) {
            throw new IllegalArgumentException("Mot de passe incorrect");
        }

        return jwtService.generateToken(u.getEmail());
    }

    public String initiateResetPassword(String email) {
        Optional<Utilisateur> userOpt = utilisateurRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            Utilisateur u = userOpt.get();
            String token = UUID.randomUUID().toString();

            u.setResetToken(token);
            u.setResetTokenExpires(Instant.now().plusSeconds(3600));
            utilisateurRepository.save(u);

            return token; // à envoyer par email
        }

        return null;
    }

    public void resetPassword(String token, String newPassword) {
        Utilisateur u = utilisateurRepository.findByResetToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Token invalide"));

        if (u.getResetTokenExpires() == null || Instant.now().isAfter(u.getResetTokenExpires())) {
            throw new IllegalArgumentException("Token expiré");
        }

        u.setPasswordHash(passwordEncoder.encode(newPassword + pepper));
        u.setResetToken(null);
        u.setResetTokenExpires(null);
        utilisateurRepository.save(u);
    }
}
