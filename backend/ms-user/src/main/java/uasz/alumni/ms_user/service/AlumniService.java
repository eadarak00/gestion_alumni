package uasz.alumni.ms_user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.alumni.ms_user.dto.AlumniRequestDTO;
import uasz.alumni.ms_user.dto.AlumniResponseDTO;
import uasz.alumni.ms_user.mapper.AlumniMapper;
import uasz.alumni.ms_user.model.Alumni;
import uasz.alumni.ms_user.model.Role;
import uasz.alumni.ms_user.repository.AlumniRepository;
import uasz.alumni.ms_user.repository.RoleRepository;
import uasz.alumni.ms_user.common.exception.ResourceAlreadyExistsException;
import uasz.alumni.ms_user.common.exception.ResourceNotFoundException;


@Service
@RequiredArgsConstructor
@Transactional
public class AlumniService {

    private final AlumniRepository alumniRepository;
    private final RoleRepository roleRepository;
    private final AlumniMapper alumniMapper;
    private final PasswordEncoder passwordEncoder;
    private final CodeValidationService codeValidationService;

    public AlumniResponseDTO inscrireAlumni(AlumniRequestDTO dto) {

        // Vérifications d'unicité
        if (alumniRepository.findByEmail(dto.getEmail()).isPresent())
            throw new ResourceAlreadyExistsException("Email déjà utilisé");

        if (alumniRepository.findByUsername(dto.getUsername()).isPresent())
            throw new ResourceAlreadyExistsException("Username déjà utilisé");

        // Récupération du rôle ALUMNI
        Role roleAlumni = roleRepository.findByLibelle("ALUMNI")
                .orElseThrow(() -> new ResourceNotFoundException("Le rôle ALUMNI n'existe pas"));

        // Création de l'entité Alumni
        Alumni alumni = alumniMapper.toEntity(dto);
        alumni.setRole(roleAlumni);
        alumni.setActif(false);
        
        // Hash du mot de passe
        alumni.setMotDePasse(passwordEncoder.encode(alumni.getMotDePasse()));

        // Sauvegarde et retour DTO
        Alumni saved = alumniRepository.save(alumni);
        codeValidationService.creerEtEnvoyerCode(saved.getEmail());
        return alumniMapper.toResponse(saved);
    }
}
