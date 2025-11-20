package uasz.alumni.ms_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_user.model.CodeValidation;
import uasz.alumni.ms_user.model.Utilisateur;
import java.util.Optional;

@Repository
public interface CodeValidationRepository extends JpaRepository<CodeValidation, Long> {
    
    // Trouver un code de validation par code et utilisateur
    Optional<CodeValidation> findByCodeAndUtilisateur(String code, Utilisateur utilisateur);
    
    // Trouver le dernier code de validation non utilisé pour un utilisateur
    Optional<CodeValidation> findTopByUtilisateurAndUtiliseFalseOrderByDateCreationDesc(Utilisateur utilisateur);
    
    // Vérifier si un code existe pour un utilisateur
    boolean existsByCodeAndUtilisateur(String code, Utilisateur utilisateur);
}