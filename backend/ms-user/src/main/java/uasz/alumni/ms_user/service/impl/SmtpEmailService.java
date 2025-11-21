package com.gestional.msuser.service.impl;

import com.gestional.msuser.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SmtpEmailService implements EmailService {

    private final JavaMailSender mailSender;

    public SmtpEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendValidationCode(String toEmail, String code) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmail);
        msg.setSubject("Code de validation - Gestion Alumni");
        msg.setText("Bonjour,\n\nVotre code de validation est : " + code + "\nIl expire dans 15 minutes.\n\nCordialement,\nEquipe Gestion Alumni");
        mailSender.send(msg);
    }
}
