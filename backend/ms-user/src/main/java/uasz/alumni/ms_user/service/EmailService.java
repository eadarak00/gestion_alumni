package uasz.alumni.ms_user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
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
    public void envoyerEmailSimple(String destinataire, String sujet, String contenu) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(destinataire);
            message.setSubject(sujet);
            message.setText(contenu);
            
            mailSender.send(message);
            log.info("Email envoyé avec succès à : {}", destinataire);
        } catch (Exception e) {
            log.error("Erreur lors de l'envoi de l'email à : {}", destinataire, e);
            throw new RuntimeException("Échec de l'envoi de l'email", e);
        }
    }

    /**
     * Envoie un email HTML
     */
    public void envoyerEmailHtml(String destinataire, String sujet, String contenuHtml) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            helper.setFrom(fromEmail);
            helper.setTo(destinataire);
            helper.setSubject(sujet);
            helper.setText(contenuHtml, true);
            
            mailSender.send(message);
            log.info("Email HTML envoyé avec succès à : {}", destinataire);
        } catch (MessagingException e) {
            log.error("Erreur lors de l'envoi de l'email HTML à : {}", destinataire, e);
            throw new RuntimeException("Échec de l'envoi de l'email HTML", e);
        }
    }

    /**
     * Envoie un email de validation avec code
     */
    public void envoyerCodeValidation(String destinataire, String nomComplet, String code) {
        String sujet = "Code de validation - Activation de compte Alumni UASZ";
        
        String contenuHtml = construireEmailValidation(nomComplet, code);
        
        envoyerEmailHtml(destinataire, sujet, contenuHtml);
    }

    /**
     * Construit le contenu HTML de l'email de validation
     */
    private String construireEmailValidation(String nomComplet, String code) {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <style>
                        body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; }
                        .container { max-width: 600px; margin: 0 auto; padding: 20px; }
                        .header { background-color: #007bff; color: white; padding: 20px; text-align: center; }
                        .content { background-color: #f9f9f9; padding: 30px; }
                        .code-box { background-color: #fff; border: 2px solid #007bff; padding: 20px; text-align: center; margin: 20px 0; }
                        .code { font-size: 32px; font-weight: bold; color: #007bff; letter-spacing: 5px; }
                        .footer { text-align: center; padding: 20px; font-size: 12px; color: #666; }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <div class="header">
                            <h1>Bienvenue sur Alumni UASZ</h1>
                        </div>
                        <div class="content">
                            <p>Bonjour <strong>%s</strong>,</p>
                            <p>Merci de vous être inscrit sur notre plateforme Alumni UASZ.</p>
                            <p>Pour activer votre compte, veuillez utiliser le code de validation ci-dessous :</p>
                            
                            <div class="code-box">
                                <div class="code">%s</div>
                            </div>
                            
                            <p><strong>Ce code est valide pendant 15 minutes.</strong></p>
                            <p>Si vous n'avez pas créé de compte, veuillez ignorer cet email.</p>
                        </div>
                        <div class="footer">
                            <p>© 2024 Alumni UASZ - Université Assane Seck de Ziguinchor</p>
                            <p>Cet email a été envoyé automatiquement, merci de ne pas y répondre.</p>
                        </div>
                    </div>
                </body>
                </html>
                """.formatted(nomComplet, code);
    }
}