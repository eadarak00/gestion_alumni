package uasz.alumni.ms_user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_user.model.Alumni;
import uasz.alumni.ms_user.model.Etudiant;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Long> {
    // Cherche un alumni par email
    Optional<Etudiant> findByEmail(String email);

    // Cherche un alumni par username
    Optional<Etudiant> findByUsername(String username);
}
