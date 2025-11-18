package uasz.alumni.ms_user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.ms_user.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;



@NoArgsConstructor                                      //un constructeur sans argument
@AllArgsConstructor                                     //un constructeur avec tous les arguments
@Data                                                   //génère les getters et setters   
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //indique que les classes dérivées seront mappées dans une seule table de base de données
@Entity                                                 //indique que cette classe est une entité JPA ,mappée à une table de base de données 
@DiscriminatorColumn(name = "type_utilisateur",discriminatorType = DiscriminatorType.STRING) // Colonne pour distinguer Etudiant / Alumni
public class Utilisateur extends BaseEntity  {
 
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String motDePasse;
    private String telephone;
    private Boolean actif;
    
}
