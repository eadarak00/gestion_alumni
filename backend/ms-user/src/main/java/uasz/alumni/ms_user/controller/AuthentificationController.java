package uasz.alumni.ms_user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.dto.EtudiantRequestDTO;
import uasz.alumni.ms_user.dto.EtudiantResponseDTO;
import uasz.alumni.ms_user.service.EtudiantService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthentificationController {
     private final EtudiantService etudiantService;

    @Operation(summary = "Inscrire un nouvel étudiant", description = "Crée un nouveau compte étudiant.")
    @ApiResponse(responseCode = "201", description = "Étudiant inscrit avec succès", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EtudiantResponseDTO.class)))
    @PostMapping("/inscription-etudiant")
    public ResponseEntity<EtudiantResponseDTO> inscrireEtudiant(
            @Valid @RequestBody EtudiantRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(etudiantService.inscrireEtudiant(dto));
    }

}
