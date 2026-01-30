package com.example.repository;

import com.example.entity.ParticipantEntity;
import com.example.exception.ParticipantNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void deleteParticipant(Long id) {
        ParticipantEntity participantEntity = entityManager.find(ParticipantEntity.class, id);
        if (participantEntity == null) {
            throw new ParticipantNotFoundException("Participant не найден");
        }
        entityManager.remove(participantEntity);
    }

    public void addParticipant(ParticipantEntity participantEntity) {
        entityManager.persist(participantEntity);
    }

    public void updateParticipant(ParticipantEntity participantEntity) {
        entityManager.merge(participantEntity);
    }
}
