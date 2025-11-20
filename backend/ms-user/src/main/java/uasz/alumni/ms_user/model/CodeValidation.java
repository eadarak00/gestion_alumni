package uasz.alumni.ms_user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.ms_user.common.entity.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "codes_validation")
public class CodeValidation extends BaseEntity {

    @Column(nullable = false, length = 6)
    private String code;

    @Column(nullable = false)
    private LocalDateTime dateCreation;

    @Column(nullable = false)
    private LocalDateTime dateExpiration;

    @Column(nullable = false)
    private Boolean utilise = false;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    // Méthode pour vérifier si le code est expiré
    public boolean isExpire() {
        return LocalDateTime.now().isAfter(this.dateExpiration);
    }

    // Méthode pour vérifier si le code est valide
    public boolean isValide() {
        return !this.utilise && !this.isExpire();
    }
}