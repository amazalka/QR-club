package com.example.service;

import com.example.dto.ParticipantResponse;

public interface ParticipantService {

    void deleteParticipant(Long id);

    ParticipantResponse addParticipant(ParticipantResponse participant);

    ParticipantResponse updateParticipant(ParticipantResponse participant);

}
