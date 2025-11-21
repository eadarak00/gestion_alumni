package uasz.alumni.ms_user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import uasz.alumni.ms_user.dto.CodeValidationRequestDTO;
import uasz.alumni.ms_user.dto.CodeValidationCheckDTO;
import uasz.alumni.ms_user.service.CodeValidationService;

@RestController
@RequestMapping("/api/v1/validation")
@RequiredArgsConstructor
@Slf4j
public class CodeValidationController {

    private final CodeValidationService codeValidationService;

    /**
     * Génère et envoie un code de validation à un utilisateur
     */
    @PostMapping("/envoyer")
    public ResponseEntity<Void> envoyerCode(@Valid @RequestBody CodeValidationRequestDTO dto) {
        log.info("Demande de génération de code pour {}", dto.getEmail());

        codeValidationService.creerEtEnvoyerCode(dto.getEmail());

        return ResponseEntity.status(201).build(); // 201 CREATED
    }

    /**
     * Valide un code fourni par l'utilisateur
     */
    @PostMapping("/verifier")
    public ResponseEntity<String> verifierCode(@Valid @RequestBody CodeValidationCheckDTO dto) {
        log.info("Validation du code pour {}", dto.getEmail());

        boolean valide = codeValidationService.validerCode(dto.getEmail(), dto.getCode());

        if (!valide) {
            return ResponseEntity.badRequest().body("Code invalide ou expiré");
        }

        return ResponseEntity.ok("Code validé avec succès");
    }

}
