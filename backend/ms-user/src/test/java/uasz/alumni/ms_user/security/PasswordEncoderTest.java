package uasz.alumni.ms_user.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderTest {

    @Test
    void encodeAndMatch_withPepper_shouldVerify() {
        // same parameters as PasswordEncoderConfig
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(
                16, // salt length
                32, // hash length
                1,  // parallelism
                1 << 16, // memory
                3   // iterations
        );

        String pepper = ""; // default used in service if property absent
        String raw = "MonMotDePasseSuperSecret123!";

        String hashed = encoder.encode(raw + pepper);

        assertNotNull(hashed);
        assertTrue(hashed.length() > 0);

        // should match
        assertTrue(encoder.matches(raw + pepper, hashed));

        // different password must not match
        assertFalse(encoder.matches("autreMot", hashed));
    }
}
