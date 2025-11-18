package uasz.alumni.ms_user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.ms_user.common.entity.BaseEntity;

@Entity
@Table(name = "alumni")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Alumni extends BaseEntity {

    private String nom;
    private String prenom;

    @Column(unique = true, nullable = false)
    private String email;

    private String telephone;

    private String password;  // hashé dans le service
    private String profession;
    private String entreprise;
}