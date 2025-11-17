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
@DiscriminatorValue("ALUMNI") // valeur pour la colonne type_utilisateur
public class Alumni extends Utilisateur {                                                 
   
    private String promotion;
    private String entreprise;
    private String fonction;
}
