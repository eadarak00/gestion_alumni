package uasz.alumni.ms_user.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import uasz.alumni.ms_user.model.Role;
import uasz.alumni.ms_user.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    // Injection du service via le constructeur
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // GET /api/v1/roles -> lister tous les rôles
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    // GET /api/v1/roles/{id} -> récupérer un rôle par ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        return roleService.getRoleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/v1/roles -> créer un nouveau rôle
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role savedRole = roleService.saveRole(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    // PUT /api/v1/roles/{id} -> mettre à jour un rôle existant
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Integer id, @RequestBody Role role) {
        return roleService.getRoleById(id)
                .map(existingRole -> {
                    existingRole.setLibelle(role.getLibelle());
                    Role updatedRole = roleService.saveRole(existingRole);
                    return ResponseEntity.ok(updatedRole);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/v1/roles/{id} -> supprimer un rôle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        return roleService.getRoleById(id)
                .map(role -> {
                    roleService.deleteRoleById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}