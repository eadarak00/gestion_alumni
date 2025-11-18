package uasz.alumni.ms_user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@NoArgsConstructor
@AllArgsConstructor
@Data               
@Entity
@DiscriminatorValue("ETUDIANT") // valeur pour la colonne type_utilisateur
public class Etudiant extends Utilisateur {
  
    private String numeroCarteEtudiant;
    private String niveau;
    private String filiere;
}