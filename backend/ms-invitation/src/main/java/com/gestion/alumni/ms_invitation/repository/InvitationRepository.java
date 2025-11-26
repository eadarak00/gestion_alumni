package com.gestion.alumni.ms_invitation.repository;

import com.gestion.alumni.ms_invitation.entity.InvitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvitationRepository extends JpaRepository<InvitationEntity, Integer> {

    // Exemple de méthode personnalisée pour retrouver une invitation par code
    Optional<InvitationEntity> findByCode(String code);

    // Exemple de méthode pour retrouver toutes les invitations par statut
    // List<InvitationEntity> findByStatut(String statut);
}
