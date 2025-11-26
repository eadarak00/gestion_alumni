package com.gestion.alumni.ms_invitation.controller;

import com.gestion.alumni.ms_invitation.mapper.Mapper;
import com.gestion.alumni.ms_invitation.model.Invitation;
import com.gestion.alumni.ms_invitation.model.InvitationRequest;
import com.gestion.alumni.ms_invitation.service.InvitationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invitations")
public class InvitationController {

    private final InvitationService invitationService;
    private final Mapper mapper;

    public InvitationController(InvitationService invitationService, Mapper mapper) {
        this.invitationService = invitationService;
        this.mapper = mapper;
    }

    @PostMapping("/creer")
    public Invitation createInvitation(@RequestBody InvitationRequest request) {
        // Appelle le service et récupère le DTO depuis le ResponseEntity
        return invitationService.invitationsPost(request).getBody();
    }
}
