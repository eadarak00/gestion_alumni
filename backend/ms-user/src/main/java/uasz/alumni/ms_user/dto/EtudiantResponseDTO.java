package uasz.alumni.ms_user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EtudiantResponseDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String telephone;
    private String numeroCarteEtudiant;
    private String niveau;
    private String filiere;
    private Boolean actif;
    private String role;
    private boolean deleted;
}
