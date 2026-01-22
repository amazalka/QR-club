package com.example.Java3_qrclub.service;

import com.example.Java3_qrclub.entity.Participant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ParticipantService implements ParticipantServiceInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Participant returnOfInfo(UUID uuid) {
        return entityManager.createQuery("SELECT p FROM Participant p WHERE p.uuid = :uuid", Participant.class)
                .setParameter("uuid", uuid)
                .getResultStream()
                .findFirst()
                .orElse(null);

    }

    @Override
    public void deleteParticipant(Long id) {
        Participant participant = entityManager.find(Participant.class, id);
        if (participant != null) {
            entityManager.remove(participant);
        }
    }

    @Override
    public void addParticipant(Participant participant) {
        entityManager.persist(participant);
    }

    @Override
    public void updateParticipant(Participant participant) {
        entityManager.merge(participant);
    }

    @Override
    public void updateQR(Participant participant, UUID newUuid) {
        participant.setUuid(newUuid);
        entityManager.merge(participant);
    }

    @Override
    public void deleteQR(Participant participant) {
        participant.setUuid(null);
        entityManager.merge(participant);
    }

    @Override
    public void addQR(Participant participant, UUID uuid) {
        if (participant.getUuid() == null) {
            participant.setUuid(uuid);
            entityManager.merge(participant);
        }
    }
}
