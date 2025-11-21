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
public class AlumniResponseDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String telephone;
    private String profession;
    private String entreprise;
    private Boolean actif;
    private String role;
    private boolean deleted;
}
