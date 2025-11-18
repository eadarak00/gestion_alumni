package uasz.alumni.ms_user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_user.dto.EtudiantInscriptionDTO;
import uasz.alumni.ms_user.model.Etudiant;
import uasz.alumni.ms_user.service.EtudiantService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor    
public class EtudiantController {

    private final EtudiantService etudiantService;

    // Endpoint pour inscrire un étudiant
    @PostMapping("/inscription-etudiant")
    public ResponseEntity<Etudiant> inscrireEtudiant(@RequestBody EtudiantInscriptionDTO dto) {
        return ResponseEntity.ok(etudiantService.inscrireEtudiant(dto));
    }

}
