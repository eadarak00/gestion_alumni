package uasz.alumni.ms_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_user.model.Etudiant;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    // Cherche un étudiant par email
    Optional<Etudiant> findByEmail(String email);

    // Cherche un étudiant par username
    Optional<Etudiant> findByUsername(String username);

    // Cherche un étudiant par numéro de carte
    Optional<Etudiant> findByNumeroCarteEtudiant(String numeroCarteEtudiant);
}
