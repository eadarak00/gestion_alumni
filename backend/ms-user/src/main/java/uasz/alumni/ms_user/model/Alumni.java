package uasz.alumni.ms_user.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("ALUMNI")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "Entité représentant un alumni de l'UASZ")
public class Alumni extends Utilisateur {
    private String profession;
    private String entreprise;
}