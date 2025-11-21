package com.gestional.msuser.service;

import com.gestional.msuser.model.User;
import com.gestional.msuser.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
public class ValidationService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    public ValidationService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    private String generateCode() {
        Random rnd = new Random();
        int number = 100000 + rnd.nextInt(900000); // 6 digits
        return Integer.toString(number);
    }

    @Transactional
    public void renvoyerCode(String email) throws Exception {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));
        if (user.isEmailVerified()) {
            throw new IllegalStateException("Email déjà vérifié");
        }
        String code = generateCode();
        user.setValidationCode(code);
        user.setValidationCodeExpiry(Instant.now().plus(15, ChronoUnit.MINUTES));
        userRepository.save(user);
        emailService.sendValidationCode(email, code);
    }

    @Transactional
    public void validerCode(String email, String code) {
        User user = userRepository.findByEmailAndValidationCode(email, code)
                .orElseThrow(() -> new IllegalArgumentException("Code invalide ou email inconnu"));
        Instant now = Instant.now();
        if (user.getValidationCodeExpiry() == null || now.isAfter(user.getValidationCodeExpiry())) {
            throw new IllegalStateException("Code expiré");
        }
        user.setEmailVerified(true);
        user.setValidationCode(null);
        user.setValidationCodeExpiry(null);
        userRepository.save(user);
    }
}
