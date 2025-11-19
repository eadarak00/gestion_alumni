package uasz.alumni.ms_user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO de requête pour la création et la mise à jour d'un rôle")
public class RoleRequestDTO {
    
    @NotBlank(message = "Le libellé du rôle est obligatoire")
    @Size(min = 2, max = 50, message = "Le libellé doit contenir entre 2 et 50 caractères")
    @Pattern(regexp = "^[A-Z_]+$", message = "Le libellé doit contenir uniquement des lettres majuscules et des underscores")
    @Schema(
        description = "Libellé unique du rôle. Doit contenir uniquement des lettres majuscules et des underscores.",
        example = "ADMINISTRATEUR",
        requiredMode = Schema.RequiredMode.REQUIRED,
        minLength = 2,
        maxLength = 50,
        pattern = "^[A-Z_]+$",
        allowableValues = {
            "ADMINISTRATEUR", 
            "ALUMNI", 
            "ETUDIANT"
        }
    )
    private String libelle;
}