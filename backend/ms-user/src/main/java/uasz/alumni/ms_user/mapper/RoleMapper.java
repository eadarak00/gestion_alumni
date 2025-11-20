package uasz.alumni.ms_user.mapper;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.dto.RoleRequestDTO;
import uasz.alumni.ms_user.dto.RoleResponseDTO;
import uasz.alumni.ms_user.model.Role;

@Component
public class RoleMapper {

    /**
     * Convertit DTO → Entity (pour création)
     */
    public Role toEntity(RoleRequestDTO dto) {
        Role role = new Role();
        role.setLibelle(dto.getLibelle());
        return role;
    }

    /**
     * Mise à jour d'une entité existante à partir du DTO
     */
    public void updateEntity(Role role, RoleRequestDTO dto) {
        role.setLibelle(dto.getLibelle());
    }

    /**
     * Convertit Entity → Response DTO
     */
    public RoleResponseDTO toResponse(Role role) {
        RoleResponseDTO dto = new RoleResponseDTO();
        dto.setId(role.getId());
        dto.setLibelle(role.getLibelle());
        dto.setDeleted(Boolean.TRUE.equals(role.getDeleted()));
        return dto;
    }
}