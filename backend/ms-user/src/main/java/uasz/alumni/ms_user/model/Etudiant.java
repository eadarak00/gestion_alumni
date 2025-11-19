package uasz.alumni.ms_user.model;

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
public class Etudiant extends Utilisateur {

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Le numéro de carte étudiant est obligatoire")
    private String numeroCarteEtudiant;

    @NotBlank(message = "Le niveau est obligatoire")
    private String niveau;

    @NotBlank(message = "La filière est obligatoire")
    private String filiere;
}
