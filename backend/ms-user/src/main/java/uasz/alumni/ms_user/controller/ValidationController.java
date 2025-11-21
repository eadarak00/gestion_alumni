package com.gestional.msuser.controller;

import com.gestional.msuser.dto.ApiResponse;
import com.gestional.msuser.dto.RenvoyerCodeRequest;
import com.gestional.msuser.dto.ValiderCodeRequest;
import com.gestional.msuser.service.ValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class ValidationController {

    private final ValidationService validationService;

    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/renvoyer-code")
    public ResponseEntity<ApiResponse> renvoyerCode(@RequestBody RenvoyerCodeRequest req) {
        try {
            validationService.renvoyerCode(req.email());
            return ResponseEntity.ok(new ApiResponse(true, "Code envoyé"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(new ApiResponse(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Erreur interne"));
        }
    }

    @PostMapping("/valider-code")
    public ResponseEntity<ApiResponse> validerCode(@RequestBody ValiderCodeRequest req) {
        try {
            validationService.validerCode(req.email(), req.code());
            return ResponseEntity.ok(new ApiResponse(true, "Email validé"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(410).body(new ApiResponse(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Erreur interne"));
        }
    }
}
