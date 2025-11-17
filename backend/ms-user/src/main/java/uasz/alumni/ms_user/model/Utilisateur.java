package uasz.alumni.ms_user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@NoArgsConstructor                                      //un constructeur sans argument
@AllArgsConstructor                                     //un constructeur avec tous les arguments
@Data                                                   //génère les getters et setters   
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //indique que les classes dérivées seront mappées dans une seule table de base de données
@Entity                                                 //indique que cette classe est une entité JPA ,mappée à une table de base de données 
@DiscriminatorColumn(name = "type_utilisateur",discriminatorType = DiscriminatorType.STRING) // Colonne pour distinguer Etudiant / Alumni
public class Utilisateur {
    @GeneratedValue(strategy = GenerationType.AUTO)     //indique que la valeur de l'identifiant est générée automatiquement par la base de données
    @Id                                                 //indique que cet attribut est la clé primaire de l'entité  
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String motDePasse;
    private String telephone;
    private String sexe;
    private boolean actif;
    private String adresse;
    private String codeValidation;
      
    // Relation vers Role
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
