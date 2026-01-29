package com.example.service;

import com.example.entity.Participant;
import com.example.repository.ParticipantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantRepository participantRepository;

    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteParticipant(id);
    }

    @Override
    public void addParticipant(Participant participant) {
        participantRepository.addParticipant(participant);
    }

    @Override
    public void updateParticipant(Participant participant) {
        participantRepository.updateParticipant(participant);
    }
}
