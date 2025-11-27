package com.gestion.alumni.ms_invitation.service;



import com.gestion.alumni.ms_invitation.api.InvitationsApi;
import com.gestion.alumni.ms_invitation.entity.InvitationEntity;
import com.gestion.alumni.ms_invitation.enumeration.Statut;
import com.gestion.alumni.ms_invitation.mapper.Mapper;
import com.gestion.alumni.ms_invitation.model.Invitation;
import com.gestion.alumni.ms_invitation.model.InvitationRequest;
import com.gestion.alumni.ms_invitation.model.Parrainage;
import com.gestion.alumni.ms_invitation.repository.InvitationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class InvitationService implements InvitationsApi{
    private final InvitationRepository invitationRepository;
    private final Mapper mapper;
    private final MailService mailService;

    public InvitationService(InvitationRepository invitationRepository, Mapper mapper, MailService mailservice, MailService mailService) {
        this.invitationRepository = invitationRepository;
        this.mapper = mapper;
        this.mailService = mailService;

    }


    @Override
    public ResponseEntity<Parrainage> invitationsCodeAccepterPut(String code) {
        return null;
    }

    @Override
    public ResponseEntity<Invitation> invitationsCodeGet(String code) {
        return null;
    }

    @Override
    public ResponseEntity<Invitation> invitationsPost(InvitationRequest invitationRequest) {

        InvitationEntity invitationEntity = new InvitationEntity();
        invitationEntity.setEmail(invitationRequest.getEmailInvite());
        invitationEntity.setCode(UUID.randomUUID().toString());
        invitationEntity.setUrlInvitation("https://plateforme.com/invitation/" +
                invitationEntity.getCode());
        invitationEntity.setDateCreation(LocalDateTime.now());
        invitationEntity.setStatut(Statut.ENVOYEE);

        InvitationEntity saved = invitationRepository.save(invitationEntity);
// Envoi de l'email
        mailService.sendInvitationEmail(saved.getEmail(), saved.getUrlInvitation());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(saved));
    }
}
