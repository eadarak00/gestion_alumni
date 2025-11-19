package uasz.alumni.ms_user.mapper;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.dto.UtilisateurResponseDTO;
import uasz.alumni.ms_user.model.Utilisateur;

@Component
public class UtilisateurMapper {

    // Convertit une entité Utilisateur en DTO
    public  UtilisateurResponseDTO toDto(Utilisateur utilisateur) {
        if (utilisateur == null) return null;

        return UtilisateurResponseDTO.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .telephone(utilisateur.getTelephone())
                .username(utilisateur.getUsername())
                .actif(utilisateur.getActif())
                .deleted(utilisateur.getDeleted())
                .role(utilisateur.getRole().getLibelle())
                .build();
    }

}
