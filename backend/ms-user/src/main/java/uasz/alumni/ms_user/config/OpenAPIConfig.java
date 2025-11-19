package uasz.alumni.ms_user.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${app.openapi.dev-url:http://localhost:8081}")
    private String devUrl;

//     @Value("${app.openapi.prod-url:https://api.alumni-uaszi.org}")
//     private String prodUrl;

    @Bean
    public OpenAPI msUserOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Environnement de développement");

        // Server prodServer = new Server();
        // prodServer.setUrl(prodUrl);
        // prodServer.setDescription("Environnement de production");

        // Contact contact = new Contact();
        // contact.setEmail("contact@alumni-uaszi.org");
        // contact.setName("Équipe UASZ Alumni");
        // contact.setUrl("https://www.alumni-uaszi.org");

        License mitLicense = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("MS User - API de Gestion des Utilisateurs")
                .version("1.0.0")
                // .contact(contact)
                .description("""
                    Microservice de gestion des utilisateurs et authentification pour la plateforme UASZ Alumni.
                    Cette API permet de gérer les utilisateurs, les rôles, les permissions et l'authentification.
                    """)
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                // .servers(List.of(devServer, prodServer))
                .servers(List.of(devServer))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Jeton JWT d'authentification"))
                );
    }
}