package uasz.alumni.ms_user.service;

import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.model.Utilisateur;
import uasz.alumni.ms_user.repository.UtilisateurRepository;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
}
