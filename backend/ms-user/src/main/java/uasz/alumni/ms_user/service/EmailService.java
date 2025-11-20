package uasz.alumni.ms_user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.email.from}")
    private String fromEmail;

    /**
     * Envoie un email simple
     */
    // public void envoyerEmailSimple(String destinataire, String sujet, String contenu) {
    //     try {
    //         SimpleMailMessage message = new SimpleMailMessage();
    //         message.setFrom(fromEmail);
    //         message.setTo(destinataire);
    //         message.setSubject(sujet);
    //         message.setText(contenu);
            
    //         mailSender.send(message);
    //         log.info("Email envoyé avec succès à : {}", destinataire);
    //     } catch (Exception e) {
    //         log.error("Erreur lors de l'envoi de l'email à : {}", destinataire, e);
    //         throw new RuntimeException("Échec de l'envoi de l'email", e);
    //     }
    // }

    /**
     * Envoie un email HTML
     */
    // public void envoyerEmailHtml(String destinataire, String sujet, String contenuHtml) {
    //     try {
    //         MimeMessage message = mailSender.createMimeMessage();
    //         MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
    //         helper.setFrom(fromEmail);
    //         helper.setTo(destinataire);
    //         helper.setSubject(sujet);
    //         helper.setText(contenuHtml, true);
            
    //         mailSender.send(message);
    //         log.info("Email HTML envoyé avec succès à : {}", destinataire);
    //     } catch (MessagingException e) {
    //         log.error("Erreur lors de l'envoi de l'email HTML à : {}", destinataire, e);
    //         throw new RuntimeException("Échec de l'envoi de l'email HTML", e);
    //     }
    // }

    /**
     * Envoie un email de validation avec code
     */
    // public void envoyerCodeValidation(String destinataire, String nomComplet, String code) {
    //     String sujet = "Code de validation - Activation de compte Alumni UASZ";
        
    //     String contenuHtml = construireEmailValidation(nomComplet, code);
        
    //     envoyerEmailHtml(destinataire, sujet, contenuHtml);
    // }


    public void envoyerEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void envoyerHtml(String to, String subject, String htmlContent) throws MessagingException {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

    try {
        helper.setFrom(new InternetAddress("djibyf573@gmail.com", "Gestion Alumni"));
    } catch (UnsupportedEncodingException e) {
        helper.setFrom("djibyf573@gmail.com"); // fallback sans nom
    }

    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(htmlContent, true);

    mailSender.send(mimeMessage);
}
}