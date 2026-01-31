package com.example.service;

import com.example.dto.ParticipantRequest;
import com.example.dto.ParticipantResponse;

public interface ParticipantService {

    void deleteParticipant(Long id);

    ParticipantResponse addParticipant(ParticipantRequest participant);

    ParticipantResponse updateParticipant(ParticipantRequest participant);
}
