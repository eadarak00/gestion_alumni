package uasz.alumni.ms_user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uasz.alumni.ms_user.common.entity.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Role extends BaseEntity {

    @NotBlank(message = "Le libellé du rôle est obligatoire")
    @Column(nullable = false, unique = true, length = 50)
    private String libelle;
}
