package uasz.alumni.ms_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uasz.alumni.ms_user.entity.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByEmail(String email);

    Optional<Utilisateur> findByResetToken(String token);

    boolean existsByEmail(String email);
}
