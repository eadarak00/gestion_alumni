package uasz.alumni.ms_user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequestDTO {
    @NotBlank(message = "Le libellé du rôle est obligatoire")
    private String libelle;
}
