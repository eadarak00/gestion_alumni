package uasz.alumni.ms_user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO de réponse pour les données d'un rôle")
public class RoleResponseDTO {
    
    @Schema(
        description = "Identifiant unique du rôle",
        example = "1",
        accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
        description = "Libellé du rôle",
        example = "ADMINISTRATEUR",
        requiredMode = Schema.RequiredMode.REQUIRED,
        minLength = 2,
        maxLength = 50
    )
    private String libelle;

    @Schema(
        description = "Indique si le rôle est supprimé logiquement",
        example = "false",
        defaultValue = "false"
    )
    private boolean deleted;
}