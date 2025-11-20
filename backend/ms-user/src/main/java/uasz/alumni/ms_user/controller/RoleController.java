package uasz.alumni.ms_user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uasz.alumni.ms_user.common.exception.ResourceNotFoundException;
import uasz.alumni.ms_user.dto.RoleRequestDTO;
import uasz.alumni.ms_user.dto.RoleResponseDTO;
import uasz.alumni.ms_user.service.RoleService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@Tag(name = "Rôle", description = "API pour la gestion des rôles utilisateurs")
public class RoleController {

    private final RoleService roleService;

    @Operation(
        summary = "Récupérer tous les rôles",
        description = "Retourne la liste de tous les rôles disponibles dans le système"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Liste des rôles récupérée avec succès",
            content = @Content(mediaType = "application/json", 
                             schema = @Schema(implementation = RoleResponseDTO.class))
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Erreur interne du serveur",
            content = @Content
        )
    })
    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRolesDto());
    }

    @Operation(
        summary = "Récupérer un rôle par son ID",
        description = "Retourne les détails d'un rôle spécifique en fonction de son identifiant"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Rôle trouvé et retourné avec succès",
            content = @Content(mediaType = "application/json", 
                             schema = @Schema(implementation = RoleResponseDTO.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Rôle non trouvé",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "400",
            description = "ID invalide",
            content = @Content
        )
    })
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> getRoleById(
            @Parameter(
                description = "ID du rôle à récupérer",
                required = true,
                example = "1"
            )
            @PathVariable Long id) {
        try {
            RoleResponseDTO dto = roleService.getRoleDtoById(id);
            return ResponseEntity.ok(dto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @Operation(
        summary = "Créer un nouveau rôle",
        description = "Crée un nouveau rôle dans le système avec les données fournies"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Rôle créé avec succès",
            content = @Content(mediaType = "application/json", 
                             schema = @Schema(implementation = RoleResponseDTO.class))
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Données de requête invalides",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "409",
            description = "Un rôle avec le même nom existe déjà",
            content = @Content
        )
    })
    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(
            @Parameter(
                description = "Données du rôle à créer",
                required = true,
                schema = @Schema(implementation = RoleRequestDTO.class)
            )
            @Valid @RequestBody RoleRequestDTO dto) {
        RoleResponseDTO saved = roleService.createRole(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @Operation(
        summary = "Mettre à jour un rôle existant",
        description = "Met à jour les informations d'un rôle existant en fonction de son ID"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Rôle mis à jour avec succès",
            content = @Content(mediaType = "application/json", 
                             schema = @Schema(implementation = RoleResponseDTO.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Rôle non trouvé",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Données de requête invalides",
            content = @Content
        )
    })
    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> updateRole(
            @Parameter(
                description = "ID du rôle à mettre à jour",
                required = true,
                example = "1"
            )
            @PathVariable Long id,
            @Parameter(
                description = "Nouvelles données du rôle",
                required = true,
                schema = @Schema(implementation = RoleRequestDTO.class)
            )
            @Valid @RequestBody RoleRequestDTO dto) {
        RoleResponseDTO updated = roleService.updateRole(id, dto);
        return ResponseEntity.ok(updated);
    }

    @Operation(
        summary = "Supprimer logiquement un rôle",
        description = "Effectue une suppression logique (soft delete) d'un rôle en fonction de son ID"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "204",
            description = "Rôle supprimé logiquement avec succès",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Rôle non trouvé",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "400",
            description = "ID invalide",
            content = @Content
        )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteRole(
            @Parameter(
                description = "ID du rôle à supprimer logiquement",
                required = true,
                example = "1"
            )
            @PathVariable Long id) {
        roleService.softDeleteRole(id);
        return ResponseEntity.noContent().build();
    }
}