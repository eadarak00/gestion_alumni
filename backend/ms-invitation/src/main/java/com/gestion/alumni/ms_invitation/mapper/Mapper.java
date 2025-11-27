package com.gestion.alumni.ms_invitation.mapper;

import com.gestion.alumni.ms_invitation.entity.InvitationEntity;
import com.gestion.alumni.ms_invitation.enumeration.Statut;
import com.gestion.alumni.ms_invitation.model.Invitation;
import com.gestion.alumni.ms_invitation.model.InvitationRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component

public class Mapper {

    // Convertir DTO InvitationRequest -> Entity
    public InvitationEntity toEntity(InvitationRequest request) {
        InvitationEntity entity = new InvitationEntity();
        entity.setEmail(request.getEmailInvite());
        entity.setCode("INV-" + java.util.UUID.randomUUID().toString().substring(0,6).toUpperCase());
        entity.setUrlInvitation("https://plateforme.com/invitation/" + entity.getCode());
        entity.setStatut(Statut.ENVOYEE);
        entity.setDateCreation(LocalDateTime.now());
        return entity;
    }

    // Convertir Entity -> DTO Invitation
    public Invitation toDto(InvitationEntity entity) {
        Invitation dto = new Invitation();
        dto.setId(entity.getId());
        dto.setEmailInvite(entity.getEmail());
        dto.setCode(entity.getCode());
        dto.setUrlInvitation(entity.getUrlInvitation());
       dto.setStatut(Invitation.StatutEnum.valueOf(entity.getStatut().name()));
        dto.setDateEnvoi(entity.getDateCreation().atOffset(ZoneOffset.UTC));
        return dto;
    }
}
