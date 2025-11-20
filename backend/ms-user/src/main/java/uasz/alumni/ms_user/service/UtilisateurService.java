package uasz.alumni.ms_user.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import uasz.alumni.ms_user.common.exception.ResourceNotFoundException;
import uasz.alumni.ms_user.dto.UtilisateurResponseDTO;
import uasz.alumni.ms_user.mapper.UtilisateurMapper;
import uasz.alumni.ms_user.model.Utilisateur;
import uasz.alumni.ms_user.repository.UtilisateurRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    @Transactional(readOnly = true)
    public List<UtilisateurResponseDTO> getAllUtilisateurs() {
        return utilisateurRepository.findAll()
                .stream()
                .map(utilisateurMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<UtilisateurResponseDTO> getUtilisateursNonSupprimes() {
        return utilisateurRepository.findByDeletedFalse()
                .stream()
                .map(utilisateurMapper::toDto)
                .toList();
    }

    public Utilisateur getUtilisateurByEmail(@NonNull String email) {
        return utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec email : " + email));
    }

}
