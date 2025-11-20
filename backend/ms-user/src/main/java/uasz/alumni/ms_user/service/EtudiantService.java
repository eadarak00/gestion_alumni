package uasz.alumni.ms_user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.alumni.ms_user.dto.EtudiantRequestDTO;
import uasz.alumni.ms_user.dto.EtudiantResponseDTO;
import uasz.alumni.ms_user.mapper.EtudiantMapper;
import uasz.alumni.ms_user.model.Etudiant;
import uasz.alumni.ms_user.model.Role;
import uasz.alumni.ms_user.repository.EtudiantRepository;
import uasz.alumni.ms_user.repository.RoleRepository;
import uasz.alumni.ms_user.common.exception.ResourceAlreadyExistsException;
import uasz.alumni.ms_user.common.exception.ResourceNotFoundException;


@Service
@RequiredArgsConstructor
@Transactional
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final RoleRepository roleRepository;
    private final EtudiantMapper etudiantMapper;
    private final PasswordEncoder passwordEncoder;
    private final CodeValidationService codeValidationService;

    public EtudiantResponseDTO inscrireEtudiant(EtudiantRequestDTO dto) {

        // Vérifications d'unicité
        if (etudiantRepository.findByEmail(dto.getEmail()).isPresent())
            throw new ResourceAlreadyExistsException("Email déjà utilisé");

        if (etudiantRepository.findByUsername(dto.getUsername()).isPresent())
            throw new ResourceAlreadyExistsException("Username déjà utilisé");

        if (etudiantRepository.findByNumeroCarteEtudiant(dto.getNumeroCarteEtudiant()).isPresent())
            throw new ResourceAlreadyExistsException("Numéro de carte déjà utilisé");

        // Récupération du rôle ETUDIANT
        Role roleEtudiant = roleRepository.findByLibelle("ETUDIANT")
                .orElseThrow(() -> new ResourceNotFoundException("Le rôle ETUDIANT n'existe pas"));

        // Création de l'entité Etudiant
        Etudiant etudiant = etudiantMapper.toEntity(dto);
        etudiant.setRole(roleEtudiant);


        // Hash du mot de passe
        etudiant.setMotDePasse(passwordEncoder.encode(etudiant.getMotDePasse()));

        // Sauvegarde et retour DTO
        Etudiant saved = etudiantRepository.save(etudiant);
        codeValidationService.creerEtEnvoyerCode(saved.getEmail());
        return etudiantMapper.toResponse(saved);
    }
}
