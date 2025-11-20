package uasz.alumni.ms_user.common.fixtures;


import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import uasz.alumni.ms_user.dto.RoleRequestDTO;
import uasz.alumni.ms_user.service.RoleService;

@Component
@AllArgsConstructor
public class RoleFixtures {

    private final RoleService roleService;

    public void init() {
    List<String> roles = List.of("ADMINISTRATEUR", "ETUDIANT", "ALUMNI");

    roles.forEach(nom -> {
        if (!roleService.existsRoleParLibelle(nom)) {
            roleService.createRole(new RoleRequestDTO(nom));
        }
    });
}

}