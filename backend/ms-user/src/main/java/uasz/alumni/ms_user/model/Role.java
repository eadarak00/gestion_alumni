package uasz.alumni.ms_user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uasz.alumni.ms_user.common.entity.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Schema(description = "Entité représentant un rôle dans le système UASZ Alumni")
public class Role extends BaseEntity {

    @NotBlank(message = "Le libellé du rôle est obligatoire")
    @Size(min = 2, max = 50, message = "Le libellé doit contenir entre 2 et 50 caractères")
    @Column(nullable = false, unique = true, length = 50)
    @Schema(
        description = "Libellé unique du rôle",
        example = "ADMINISTRATEUR",
        requiredMode = Schema.RequiredMode.REQUIRED,
        minLength = 2,
        maxLength = 50,
        pattern = "^[A-Z_]+$"
    )
    private String libelle;
}