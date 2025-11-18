package uasz.alumni.ms_user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uasz.alumni.ms_user.dto.LoginDto;
import uasz.alumni.ms_user.dto.RegisterDto;
import uasz.alumni.ms_user.dto.ResetDto;
import uasz.alumni.ms_user.entity.Utilisateur;
import uasz.alumni.ms_user.service.UtilisateurService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto dto) {
        try {
            Utilisateur u = utilisateurService.register(dto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("id", u.getId(), "email", u.getEmail()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) {
        try {
            String token = utilisateurService.login(dto);
            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/forgot")
    public ResponseEntity<?> forgot(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String token = utilisateurService.initiateResetPassword(email);

        return ResponseEntity.ok(Map.of(
                "message", "Si l'email existe, un lien de réinitialisation a été envoyé.",
                "debugToken", token  // visible seulement en dev
        ));
    }

    @PostMapping("/reset")
    public ResponseEntity<?> reset(@RequestBody ResetDto dto) {
        try {
            utilisateurService.resetPassword(dto.getToken(), dto.getNewPassword());
            return ResponseEntity.ok(Map.of("message", "Mot de passe réinitialisé avec succès"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}
