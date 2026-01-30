package com.example.service;

import com.example.mapper.ParticipantMapper;
import com.example.dto.ParticipantResponse;
import com.example.entity.ParticipantEntity;
import com.example.repository.ParticipantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantRepository participantRepository;
    private ParticipantMapper participantMapper;

    public ParticipantServiceImpl(ParticipantRepository participantRepository, ParticipantMapper participantMapper) {
        this.participantRepository = participantRepository;
        this.participantMapper = participantMapper;
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteParticipant(id);
    }

    @Override
    public ParticipantResponse addParticipant(ParticipantResponse participant) {
        ParticipantEntity participantEntity = participantMapper.toEntity(participant);
        participantRepository.addParticipant(participantEntity);
        return participantMapper.toDTO(participantEntity);
    }

    @Override
    public ParticipantResponse updateParticipant(ParticipantResponse participant) {
        ParticipantEntity participantEntity = participantMapper.toEntity(participant);
        participantRepository.updateParticipant(participantEntity);
        return participantMapper.toDTO(participantEntity);
    }
}
