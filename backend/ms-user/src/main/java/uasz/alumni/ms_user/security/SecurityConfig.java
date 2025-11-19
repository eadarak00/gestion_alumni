package uasz.alumni.ms_user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
//import uasz.alumni.ms_user.security.jwt.JwtAuthenticationFilter;

/**
 * @author arahmane-s-diallo
 *         Configuration principale de la sécurité de l'application,
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // Permet d'utiliser @PreAuthorize et @PostAuthorize sur les méthodes
@RequiredArgsConstructor
public class SecurityConfig {

    // Cette injection permet d'ajouter le filtre à la chaîne
    // private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Utilisation de BCrypt, standard et recommandé
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                // ********** 1. Désactiver CSRF : Nécessaire pour les API REST utilisant des
                // tokens JWT **********
                .csrf(AbstractHttpConfigurer::disable)

                // ********** 2. Gérer les sessions : Utilisation de sessions sans état
                // (stateless) pour les API REST **********
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // ********* 3. Gestion des autorisations (RBAC) *************
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/v1/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-ui.html",
                                "/webjars/**",
                                "/swagger-resources/**"

                        ).permitAll() // ****** */ a. Accès public (sans authentification) ********

                        // ****** */ b. Restriction par Rôle // Seul l'ADMIN peut gérer les rôles
                        // ********
                        .requestMatchers("/api/v1/roles/**").permitAll()

                        // ***** */ Seul l'ADMIN peut lister TOUS les utilisateurs (données sensibles)
                        // ********
                        .requestMatchers("/api/v1/utilisateurs/**").permitAll()

                        // ****** */ c. Toute autre requête HTTP doit être authentifiée (doit avoir un
                        // JWT valide)*********
                        .anyRequest().authenticated()

                );

        // *************4. Intégration du Filtre JWT***************
        // http.addFilterBefore(jwtAuthenticationFilter,
        // UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /**
     * Expose le gestionnaire d'authentification nécessaire pour le service de
     * connexion
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
