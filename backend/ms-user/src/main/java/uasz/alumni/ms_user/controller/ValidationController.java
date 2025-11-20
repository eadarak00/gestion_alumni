package uasz.alumni.ms_user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_user.service.CodeValidationService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/validation")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Validation", description = "API de validation des comptes utilisateurs")
public class ValidationController {

    private final CodeValidationService codeValidationService;

    @PostMapping("/valider")
    @Operation(summary = "Valider un code de validation", description = "Valide le code reçu par email et active le compte")
    public ResponseEntity<Map<String, Object>> validerCode(
            @RequestParam String email,
            @RequestParam String code) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            boolean isValid = codeValidationService.validerCode(email, code);
            
            if (isValid) {
                response.put("success", true);
                response.put("message", "Compte activé avec succès");
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "Code invalide ou expiré");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            log.error("Erreur lors de la validation du code", e);
            response.put("success", false);
            response.put("message", "Erreur lors de la validation : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/renvoyer")
    @Operation(summary = "Renvoyer un code de validation", description = "Génère et envoie un nouveau code de validation")
    public ResponseEntity<Map<String, Object>> renvoyerCode(@RequestParam String email) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            codeValidationService.renvoyerCode(email);
            
            response.put("success", true);
            response.put("message", "Un nouveau code a été envoyé à votre adresse email");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            log.error("Erreur lors du renvoi du code", e);
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (Exception e) {
            log.error("Erreur inattendue lors du renvoi du code", e);
            response.put("success", false);
            response.put("message", "Erreur lors du renvoi du code");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}