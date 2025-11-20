package uasz.alumni.ms_user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
