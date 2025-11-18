package uasz.alumni.ms_user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.ms_user.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



@NoArgsConstructor                                      //un constructeur sans argument
@AllArgsConstructor                                     //un constructeur avec tous les arguments
@Data                                                   //génère les getters et setters   
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //indique que les classes dérivées seront mappées dans une seule table de base de données
@Entity                                                 //indique que cette classe est une entité JPA ,mappée à une table de base de données 
@DiscriminatorColumn(name = "type_utilisateur",discriminatorType = DiscriminatorType.STRING) // Colonne pour distinguer Etudiant / Alumni
public class Utilisateur extends BaseEntity  {
 
    private String nom;
    private String prenom;

    @Column(unique = true, nullable = false)
    @Email(message = "Email invalide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    @Column(nullable = false)
    private String motDePasse;

    @jakarta.validation.constraints.Pattern(regexp = "^(\\+221|00221)?[7][05678]\\d{7}$", message = "Numéro de téléphone invalide (format Sénégal)")
    private String telephone;
   

    private String username;
   
    private Boolean actif;

   @ManyToOne
   @JoinColumn(name = "role_id")
    private Role role;
    
}
