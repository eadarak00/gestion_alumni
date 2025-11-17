package uasz.alumni.ms_user.repository;

import uasz.alumni.ms_user.model.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    List<Utilisateur> findByActifTrueAndDeletedFalse();
   
}
