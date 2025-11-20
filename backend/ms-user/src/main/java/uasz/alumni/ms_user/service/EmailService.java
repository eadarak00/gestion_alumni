package uasz.alumni.ms_user.service;

import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.email.from}")
    private String fromEmail;

    @Value("${mail.username}")
    private String mailUsername;

    @PostConstruct
    private void init() {
        Objects.requireNonNull(mailUsername, "La propriété mail.username ne doit pas être null");
        Objects.requireNonNull(fromEmail, "La propriété app.email.from ne doit pas être null");
    }

    /**
     * Envoie un email simple (texte brut)
     */
    public void envoyerEmail(@NonNull String to, @NonNull String subject, @NonNull String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
        log.info("Email simple envoyé à {}", to);
    }

    /**
     * Envoie un email HTML
     */
    public void envoyerHtml(@NonNull String to, @NonNull String subject, @NonNull String htmlContent)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        try {
            helper.setFrom(new InternetAddress(Objects.requireNonNull(mailUsername, "La propriété mail.username ne doit pas être null"), "Gestion Alumni"));
        } catch (UnsupportedEncodingException e) {
            log.warn("Impossible d’utiliser le nom, fallback sur l’adresse seule");
            helper.setFrom(Objects.requireNonNull(mailUsername, "La propriété mail.username ne doit pas être null"));
        }

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);

        mailSender.send(mimeMessage);
        log.info("Email HTML envoyé à {}", to);
    }
}
