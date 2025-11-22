package uasz.alumni.ms_user.mapper;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.dto.AlumniRequestDTO;
import uasz.alumni.ms_user.dto.AlumniResponseDTO;
import uasz.alumni.ms_user.model.Alumni;

@Component
public class AlumniMapper {

    public Alumni toEntity(AlumniRequestDTO dto) {
        Alumni alumni = new Alumni();
        alumni.setNom(dto.getNom());
        alumni.setPrenom(dto.getPrenom());
        alumni.setEmail(dto.getEmail());
        alumni.setUsername(dto.getUsername());
        alumni.setMotDePasse(dto.getMotDePasse());
        alumni.setTelephone(dto.getTelephone());
        alumni.setProfession(dto.getProfession());
        alumni.setEntreprise(dto.getEntreprise());
        return alumni;
    }

    public AlumniResponseDTO toResponse(Alumni alumni) {
        AlumniResponseDTO dto = new AlumniResponseDTO();
        dto.setId(alumni.getId());
        dto.setNom(alumni.getNom());
        dto.setPrenom(alumni.getPrenom());
        dto.setEmail(alumni.getEmail());
        dto.setUsername(alumni.getUsername());
        dto.setTelephone(alumni.getTelephone());
        dto.setEntreprise(alumni.getEntreprise());
        dto.setProfession(alumni.getProfession());
        dto.setActif(alumni.getActif());
        dto.setRole(alumni.getRole() != null ? alumni.getRole().getLibelle() : null);
        dto.setDeleted(alumni.getDeleted());
        return dto;
    }
}
