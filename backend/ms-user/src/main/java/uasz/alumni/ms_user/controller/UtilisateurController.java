package uasz.alumni.ms_user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_user.service.UtilisateurService;
import uasz.alumni.ms_user.model.Utilisateur;
import java.util.List;

@RestController
@RequestMapping("/api/v1/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.getAllUtilisateurs();
    }
}
