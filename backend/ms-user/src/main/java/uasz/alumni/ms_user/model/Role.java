package uasz.alumni.ms_user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;

    // Nom du rôle : "ETUDIANT", "ALUMNI", "ADMIN"
    @Column(nullable = false, unique = true)
    private String libelle;

    // Un rôle peut être attribué à plusieurs utilisateurs
    @OneToMany(mappedBy = "role")
    private Set<Utilisateur> utilisateurs;
}
