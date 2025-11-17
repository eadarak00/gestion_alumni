package uasz.alumni.ms_user.service;

import java.util.List;
import java.util.Optional;  
import uasz.alumni.ms_user.entity.Role;

public interface RoleService {

    // Créer ou mettre à jour un rôle   
    Role saveRole(Role role);

    // Récupérer un rôle par son ID
    Optional<Role> getRoleById(Integer id);

    // Récupérer tous les rôles
    List<Role> getAllRoles();   

    // Supprimer un rôle par son ID
    void deleteRoleById(Integer id);
}
  