package uasz.alumni.ms_user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import uasz.alumni.ms_user.model.Role;
import uasz.alumni.ms_user.repository.RoleRepository;
import uasz.alumni.ms_user.common.exception.ResourceNotFoundException;
import uasz.alumni.ms_user.dto.RoleRequestDTO;
import uasz.alumni.ms_user.dto.RoleResponseDTO;
import uasz.alumni.ms_user.mapper.RoleMapper;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    /**
     * Creation du role 
     * @param dto 
     * @return
     */
    public RoleResponseDTO createRole(@NonNull RoleRequestDTO dto) {
        Role role = Objects.requireNonNull(
                roleMapper.toEntity(dto),
                "Le rôle mappé depuis le DTO ne doit pas être null");
        role.setLibelle(role.getLibelle().toUpperCase());
        Role saved = roleRepository.save(role);
        return roleMapper.toResponse(saved);
    }

    /**
     * UPDATE
     */
    public RoleResponseDTO updateRole(@NonNull Long id, @NonNull RoleRequestDTO dto) {
        Role role = Objects.requireNonNull(
                this.getRoleById(id),
                "Le rôle recupéré depuis le DTO ne doit pas être null");
        roleMapper.updateEntity(role, dto);
        Role updated = roleRepository.save(role);
        return roleMapper.toResponse(updated);
    }

    /**
     * GET BY ID → Entity interne
     */
    @Transactional(readOnly = true)
    public Role getRoleById(@NonNull Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role avec ID " + id + " introuvable"));
    }

    /**
     * GET BY ID → DTO
     */
    @Transactional(readOnly = true)
    public RoleResponseDTO getRoleDtoById(@NonNull Long id) {
        return roleMapper.toResponse(this.getRoleById(id));
    }

    /**
     * GET ALL → DTO
     */
    @Transactional(readOnly = true)
    public List<RoleResponseDTO> getAllRolesDto() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toResponse)
                .toList();
    }

    /**
     * SOFT DELETE
     */
    public void softDeleteRole(@NonNull Long id) {
        Role role = this.getRoleById(id);
        role.softDelete();
        roleRepository.save(role);
    }

    /**
     * DELETE PERMANENT
     */
    public void deleteRolePermanently(@NonNull Long id) {
        if (!roleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Role avec ID " + id + " introuvable");
        }
        roleRepository.deleteById(id);
    }

    public boolean existsRoleParLibelle(String libelle) {
        return roleRepository.findByLibelle(libelle).isPresent();
    }

}
