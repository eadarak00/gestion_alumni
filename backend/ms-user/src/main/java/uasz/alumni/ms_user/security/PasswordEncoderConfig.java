package uasz.alumni.ms_user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Argon2 parameters
        return new Argon2PasswordEncoder(
                16,   // salt length
                32,   // hash length
                1,    // parallelism
                1 << 16,   // memory (64MB)
                3     // iterations
        );
    }
}
