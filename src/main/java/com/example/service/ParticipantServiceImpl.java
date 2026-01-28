package com.example.service;

import com.example.entity.Participant;
import com.example.exception.ParticipantNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteParticipant(Long id) {
        Participant participant = entityManager.find(Participant.class, id);
        if (participant == null) {
            throw new ParticipantNotFoundException("Participant не найден");
        }
        entityManager.remove(participant);
    }

    @Override
    public void addParticipant(Participant participant) {
        entityManager.persist(participant);
    }

    @Override
    public void updateParticipant(Participant participant) {
        entityManager.merge(participant);
    }
}
