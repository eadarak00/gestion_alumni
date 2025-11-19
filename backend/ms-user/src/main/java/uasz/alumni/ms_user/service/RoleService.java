package uasz.alumni.ms_user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.model.Role;
import uasz.alumni.ms_user.repository.RoleRepository;
import uasz.alumni.ms_user.common.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    // Self-injection pour permettre l'appel transactionnel correct
    private final RoleService self;

    /**
     * Créer ou mettre à jour un rôle
     */
    public Role saveRole(@NonNull Role role) {
        return roleRepository.save(role);
    }

    /**
     * Récupérer un rôle par ID
     */
    @Transactional(readOnly = true)
    public Role getRoleById(@NonNull Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role avec ID " + id + " introuvable"));
    }

    /**
     * Récupérer tous les rôles
     */
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    /**
     * Suppression logique (soft delete)
     */
    public void softDeleteRole(@NonNull Long id) {
        Role role = self.getRoleById(id);
        role.softDelete();
        roleRepository.save(role); // persist soft delete
    }

    /**
     * Suppression physique définitive
     */
    public void deleteRolePermanently(@NonNull Long id) {
        if (!roleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Role avec ID " + id + " introuvable");
        }
        roleRepository.deleteById(id);
    }
}
