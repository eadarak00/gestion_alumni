package uasz.alumni.ms_user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uasz.alumni.ms_user.common.entity.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur", discriminatorType = DiscriminatorType.STRING, length = 50)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entité représentant un utilisateur de la plateforme UASZ Alumni")
public class Utilisateur extends BaseEntity {

    @Schema(
        description = "Nom de famille de l'utilisateur",
        example = "DIOP",
        requiredMode = Schema.RequiredMode.REQUIRED,
        minLength = 1,
        maxLength = 100
    )
    private String nom;

    @Schema(
        description = "Prénom de l'utilisateur",
        example = "Marie",
        requiredMode = Schema.RequiredMode.REQUIRED,
        minLength = 1,
        maxLength = 100
    )
    private String prenom;

    @Column(nullable = false)
    @Email(message = "Email invalide")
    @Schema(
        description = "Adresse email unique de l'utilisateur",
        example = "marie.diop@alumni-uaszi.sn",
        requiredMode = Schema.RequiredMode.REQUIRED,
        pattern = "^[A-Za-z0-9+_.-]+@(.+)$"
    )
    private String email;

    @Column(nullable = false)
    @Schema(
        description = "Mot de passe hashé de l'utilisateur",
        example = "$2a$10$xyz123...",
        accessMode = Schema.AccessMode.WRITE_ONLY,
        requiredMode = Schema.RequiredMode.REQUIRED,
        minLength = 6
    )
    private String motDePasse;

    @Pattern(regexp = "^(\\+221|00221)?7[015678]\\d{7}$", message = "Numéro de téléphone invalide (format Sénégal)")
    @Schema(
        description = "Numéro de téléphone au format sénégalais",
        example = "+221781234567",
        pattern = "^(\\+221|00221)?7[015678]\\d{7}$"
    )
    private String telephone;

    @Column(unique = true)
    @Schema(
        description = "Nom d'utilisateur unique pour la connexion",
        example = "mariediop2024"
    )
    private String username;

    @Column(nullable = false)
    @Schema(
        description = "Statut d'activation du compte utilisateur",
        example = "true",
        defaultValue = "true"
    )
    private Boolean actif = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    @Schema(
        description = "Rôle associé à l'utilisateur",
        implementation = Role.class
    )
    private Role role;
}