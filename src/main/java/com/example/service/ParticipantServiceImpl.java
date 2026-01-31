package com.example.service;

import com.example.dto.ParticipantRequest;
import com.example.entity.QRCodeEntity;
import com.example.mapper.ParticipantMapper;
import com.example.dto.ParticipantResponse;
import com.example.entity.ParticipantEntity;
import com.example.repository.ParticipantRepository;
import com.example.repository.QRRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantRepository participantRepository;
    private ParticipantMapper participantMapper;
    private QRRepository qrRepository;

    public ParticipantServiceImpl(ParticipantRepository participantRepository, ParticipantMapper participantMapper, QRRepository qrRepository) {
        this.participantRepository = participantRepository;
        this.participantMapper = participantMapper;
        this.qrRepository = qrRepository;

    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteParticipant(id);
    }

    @Override
    public ParticipantResponse addParticipant(ParticipantRequest participant) {
        ParticipantEntity participantEntity = participantMapper.toEntity(participant);
        participantRepository.addParticipant(participantEntity);
        QRCodeEntity qrCode = new QRCodeEntity();
        qrCode.setParticipantEntity(participantEntity);
        qrCode.setUuid(UUID.randomUUID());
        qrRepository.addQRCode(qrCode);
        return participantMapper.toResponse(participantEntity);
    }

    @Override
    public ParticipantResponse updateParticipant(ParticipantRequest participant) {
        ParticipantEntity participantEntity = participantMapper.toEntity(participant);
        participantRepository.updateParticipant(participantEntity);
        return participantMapper.toResponse(participantEntity);
    }
}
