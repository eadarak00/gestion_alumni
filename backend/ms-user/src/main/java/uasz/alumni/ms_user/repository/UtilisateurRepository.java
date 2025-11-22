package uasz.alumni.ms_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_user.model.Utilisateur;
import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    
    // Méthode existante (suppression logique)
    List<Utilisateur> findByDeletedFalse();
    
    // Nouvelles méthodes pour la validation email
    Optional<Utilisateur> findByEmail(String email);
    
    Optional<Utilisateur> findByUsername(String username);
    
    boolean existsByEmail(String email);
    
    boolean existsByUsername(String username);
    
    // Méthode pour trouver un utilisateur non supprimé par email
    Optional<Utilisateur> findByEmailAndDeletedFalse(String email);
}