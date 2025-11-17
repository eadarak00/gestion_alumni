package uasz.alumni.ms_user.common.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "is_deleted")
    private Boolean deleted = false;

    private LocalDateTime deletedAt;

    /**
     * Appelé automatiquement avant l'insertion
     */
    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (deleted == null) {
            deleted = false;
        }
    }

    /**
     * Appelé automatiquement avant chaque update
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();

        // Si l’entité est supprimée logiquement mais sans date → ajouter la date
        if (Boolean.TRUE.equals(deleted) && deletedAt == null) {
            deletedAt = LocalDateTime.now();
        }

        // Si elle est restaurée → nettoyer deletedAt
        if (Boolean.FALSE.equals(deleted) && deletedAt != null) {
            deletedAt = null;
        }
    }

    /**
     * Suppression logique
     */
    public void softDelete() {
        this.deleted = true;
        this.deletedAt = LocalDateTime.now();
    }

    /**
     * Restore l'entité soft deleted
     */
    public void restore() {
        this.deleted = false;
        this.deletedAt = null;
    }
}
