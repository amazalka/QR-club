package com.example.service;

import com.example.mapper.ParticipantMapper;
import com.example.dto.ParticipantResponse;
import com.example.entity.ParticipantEntity;
import com.example.repository.QRRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class QRServiceImpl implements QRService {
    private QRRepository qrRepository;
    private ParticipantMapper participantMapper;

    public QRServiceImpl(QRRepository qrRepository, ParticipantMapper participantMapper) {
        this.qrRepository = qrRepository;
        this.participantMapper = participantMapper;
    }

    @Override
    public ParticipantResponse checkQR(UUID uuid) {
        ParticipantEntity participantEntity = qrRepository.checkQR(uuid);
        return participantMapper.toDTO(participantEntity);
    }
}
