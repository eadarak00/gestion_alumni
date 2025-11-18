package uasz.alumni.ms_user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantInscriptionDTO {
    private String nom;
    private String prenom;
    private String email;               // unique
    private String username;            // unique
    private String motDePasse;
    private String telephone;
    private String numeroCarteEtudiant; // unique
    private String niveau;
    private String filiere;
}
