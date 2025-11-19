package uasz.alumni.ms_user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_user.service.UtilisateurService;
import uasz.alumni.ms_user.dto.UtilisateurResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @GetMapping
    @Operation(
        summary = "Récupère tous les utilisateurs",
        description = "Retourne la liste complète de tous les utilisateurs de la plateforme",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Liste des utilisateurs récupérée avec succès",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = UtilisateurResponseDTO.class)
                )
            )
        }
    )
    public ResponseEntity<List<UtilisateurResponseDTO>> getAll() {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }

    @GetMapping("/actifs")
    @Operation(
        summary = "Récupère les utilisateurs actifs",
        description = "Retourne la liste des utilisateurs non supprimés (actifs) de la plateforme",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Liste des utilisateurs actifs récupérée avec succès",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = UtilisateurResponseDTO.class)
                )
            )
        }
    )
    public ResponseEntity<List<UtilisateurResponseDTO>> getUtilisateursActifs() {
        return ResponseEntity.ok(utilisateurService.getUtilisateursNonSupprimes());
    }
}
