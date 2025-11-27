package com.gestion.alumni.ms_invitation.entity;

import com.gestion.alumni.ms_invitation.enumeration.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "invitations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvitationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @Column(name = "statut")
    private Statut statut;
    private String urlInvitation;
}
