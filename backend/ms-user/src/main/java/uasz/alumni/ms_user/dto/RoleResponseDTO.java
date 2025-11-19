package uasz.alumni.ms_user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponseDTO {
    private Long id;
    private String libelle;
    private boolean deleted;
}