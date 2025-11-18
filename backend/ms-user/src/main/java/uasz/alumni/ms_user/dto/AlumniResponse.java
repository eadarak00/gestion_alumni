package uasz.alumni.ms_user.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlumniResponse {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String profession;
    private String entreprise;
}
