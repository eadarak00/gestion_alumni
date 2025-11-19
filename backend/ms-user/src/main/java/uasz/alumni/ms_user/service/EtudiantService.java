package uasz.alumni.ms_user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;  
import uasz.alumni.ms_user.dto.EtudiantInscriptionDTO;
import uasz.alumni.ms_user.model.Etudiant;
import uasz.alumni.ms_user.model.Role;
import uasz.alumni.ms_user.repository.EtudiantRepository;
import uasz.alumni.ms_user.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final RoleRepository roleRepository;
    // Inscrit un nouvel étudiant avec vérifications d'unicité
    public Etudiant inscrireEtudiant(EtudiantInscriptionDTO dto) {
        // Vérifie si l'email est déjà utilisé
        if (etudiantRepository.findByEmail(dto.getEmail()).isPresent())
            throw new RuntimeException("Email déjà utilisé");

        // Vérifie si le username est déjà utilisé
        if (etudiantRepository.findByUsername(dto.getUsername()).isPresent())
            throw new RuntimeException("Username déjà utilisé");

        // Vérifie si le numéro de carte est déjà utilisé
        if (etudiantRepository.findByNumeroCarteEtudiant(dto.getNumeroCarteEtudiant()).isPresent())
            throw new RuntimeException("Numéro de carte déjà utilisé");

        // Crée et sauvegarde l'étudiant



          // On récupère automatiquement le rôle ETUDIANT
        Role roleEtudiant = roleRepository.findByLibelle("ETUDIANT")
                .orElseThrow(() -> new RuntimeException("Le rôle ETUDIANT n'existe pas"));

        // Création de l'étudiant
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(dto.getNom());
        etudiant.setPrenom(dto.getPrenom());
        etudiant.setEmail(dto.getEmail());
        etudiant.setUsername(dto.getUsername());
        etudiant.setMotDePasse(dto.getMotDePasse());
        etudiant.setTelephone(dto.getTelephone());
        etudiant.setNumeroCarteEtudiant(dto.getNumeroCarteEtudiant());
        etudiant.setNiveau(dto.getNiveau());
        etudiant.setFiliere(dto.getFiliere());
        etudiant.setActif(true);

        // Affectation automatique du rôle
        etudiant.setRole(roleEtudiant);

         return etudiantRepository.save(etudiant);

    }
}