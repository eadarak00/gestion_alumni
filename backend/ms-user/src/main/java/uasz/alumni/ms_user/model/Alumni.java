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
public class Alumni extends Utilisateur {
    private String profession;
    private String entreprise;
}