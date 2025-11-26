package com.gestion.alumni.ms_invitation.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendInvitationEmail(String to, String invitationLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Invitation à rejoindre la plateforme");
        message.setText("Vous avez reçu une invitation !\n\nCliquez sur ce lien pour accepter : " + invitationLink);
        mailSender.send(message);
    }
}
