package uasz.alumni.ms_user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.model.Role;
import uasz.alumni.ms_user.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    // Créer ou mettre à jour un rôle
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    // Récupérer un rôle par son ID
    public Optional<Role> getRoleById(long id) {
        return roleRepository.findById(id);
    }

    // Récupérer tous les rôles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Supprimer un rôle par son ID
    public void deleteRoleById(long id) {
        roleRepository.deleteById(id);
    }
}
