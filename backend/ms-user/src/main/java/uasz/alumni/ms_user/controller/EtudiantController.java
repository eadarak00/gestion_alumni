package uasz.alumni.ms_user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/inscription-etudiant")
    public ResponseEntity<?> inscrireEtudiant(@RequestBody EtudiantInscriptionDTO dto) {
        try {
            Etudiant etudiant = etudiantService.inscrireEtudiant(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(etudiant);  
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erreur lors de l'inscription : " + e.getMessage());
        }
    }
}
