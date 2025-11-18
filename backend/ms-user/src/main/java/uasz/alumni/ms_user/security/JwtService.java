package uasz.alumni.ms_user.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final SecretKey secretKey;
    private final long expirationMs;

    public JwtService(
            @Value("${app.jwt-secret}") String secret,
            @Value("${app.jwt-expiration-ms}") long expirationMs
    ) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
    }

    // ============================================
    // 1) Générer un Token JWT
    // ============================================
    public String generateToken(String subject) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .subject(subject)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(secretKey) // OK pour JJWT 0.13.0
                .compact();
    }

    // ============================================
    // 2) Extraire le subject (email)
    // ============================================
    public String extractSubject(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    // ============================================
    // 3) Vérifier si le token est valide
    // ============================================
    public boolean isTokenValid(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ============================================
    // 4) Parser le token (CORRECTION : méthode correcte)
    // ============================================
    private Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)       // ✔️ Correct pour JJWT 0.13.0
                .build()
                .parseSignedClaims(token);   // ✔️ Correct pour JJWT 0.13.0
    }
}