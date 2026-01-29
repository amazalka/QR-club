package com.example.repository;

import com.example.entity.Participant;
import com.example.exception.ParticipantNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void deleteParticipant(Long id) {
        Participant participant = entityManager.find(Participant.class, id);
        if (participant == null) {
            throw new ParticipantNotFoundException("Participant не найден");
        }
        entityManager.remove(participant);
    }

    public void addParticipant(Participant participant) {
        entityManager.persist(participant);
    }

    public void updateParticipant(Participant participant) {
        entityManager.merge(participant);
    }
}
