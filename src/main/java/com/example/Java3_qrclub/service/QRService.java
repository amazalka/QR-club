package com.example.Java3_qrclub.service;

import com.example.Java3_qrclub.entity.Participant;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class QRService {
    private ParticipantServiceInterface participantService;

    public QRService(ParticipantServiceInterface participantService) {
        this.participantService = participantService;
    }

    public Participant checkQR(UUID uuid) {
        Participant participant = participantService.returnOfInfo(uuid);
        if (participant == null) {
            return null;
        }
        participantService.updateQR(participant, UUID.randomUUID());
        return participant;
    }
}
