package com.example.Java3_qrclub.service;

import com.example.Java3_qrclub.entity.Participant;

import java.util.UUID;

public interface ParticipantServiceInterface {
    Participant returnOfInfo(UUID uuid);

    void deleteParticipant(Long id);

    void addParticipant(Participant participant);

    void updateParticipant(Participant participant);

    void updateQR(Participant participant, UUID newUuid);

    void deleteQR(Participant participant);

    void addQR(Participant participant, UUID uuid);
}
