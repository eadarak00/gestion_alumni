package uasz.alumni.ms_user.mapper;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.dto.EtudiantRequestDTO;
import uasz.alumni.ms_user.dto.EtudiantResponseDTO;
import uasz.alumni.ms_user.model.Etudiant;

@Component
public class EtudiantMapper {

    public Etudiant toEntity(EtudiantRequestDTO dto) {
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
        etudiant.setActif(false);
        return etudiant;
    }

    public EtudiantResponseDTO toResponse(Etudiant etudiant) {
        EtudiantResponseDTO dto = new EtudiantResponseDTO();
        dto.setId(etudiant.getId());
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setEmail(etudiant.getEmail());
        dto.setUsername(etudiant.getUsername());
        dto.setTelephone(etudiant.getTelephone());
        dto.setNumeroCarteEtudiant(etudiant.getNumeroCarteEtudiant());
        dto.setNiveau(etudiant.getNiveau());
        dto.setFiliere(etudiant.getFiliere());
        dto.setActif(etudiant.getActif());
        dto.setRole(etudiant.getRole() != null ? etudiant.getRole().getLibelle() : null);
        dto.setDeleted(etudiant.getDeleted());
        return dto;
    }
}
