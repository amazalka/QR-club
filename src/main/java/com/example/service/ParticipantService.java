package com.example.service;

import com.example.entity.Participant;

public interface ParticipantService {

    void deleteParticipant(Long id);

    void addParticipant(Participant participant);

    void updateParticipant(Participant participant);

}
