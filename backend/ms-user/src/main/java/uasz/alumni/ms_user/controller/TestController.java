package uasz.alumni.ms_user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
@Tag(name = "Test API", description = "Endpoints pour tester le microservice via le Gateway")
public class TestController {

    @Operation(summary = "Tester l'accès direct au MS User")
    @GetMapping
    public String testMsUser() {
        return "MS-USER OK - Accès via Gateway réussi";
    }

    @Operation(summary = "Tester la santé du service")
    @GetMapping("/health")
    public String healthCheck() {
        return "MS-USER est opérationnel";
    }
}