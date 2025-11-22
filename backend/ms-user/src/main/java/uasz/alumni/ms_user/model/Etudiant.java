package uasz.alumni.ms_user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("ETUDIANT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "Entité représentant un étudiant de l'UASZ")
public class Etudiant extends Utilisateur {

    @Column(unique = true)
    @Schema(
        description = "Numéro unique de la carte étudiante",
        example = "20240001",
        requiredMode = Schema.RequiredMode.REQUIRED,
        pattern = "^d{8}$",
        minLength = 8,
        maxLength = 20
    )
    private String numeroCarteEtudiant;

    @Schema(
        description = "Niveau d'étude de l'étudiant",
        example = "LICENCE 3",
        requiredMode = Schema.RequiredMode.REQUIRED,
        allowableValues = {
            "LICENCE 1", "LICENCE 2", "LICENCE 3",
            "MASTER 1", "MASTER 2",
            "DOCTORAT 1", "DOCTORAT 2", "DOCTORAT 3"
        }
    )
    private String niveau;

    @Schema(
        description = "Filière d'étude de l'étudiant",
        example = "INFORMATIQUE",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String filiere;
}