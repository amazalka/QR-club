package com.example.controller;

import com.example.entity.Participant;
import com.example.service.ParticipantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Participants")
public class ParticipantController {
    public ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/")
    public Participant addParticipant(@RequestBody Participant participant) {
        participantService.addParticipant(participant);
        return participant;
    }

    @PutMapping("/")
    public Participant updateParticipant(@RequestBody Participant participant) {
        participantService.updateParticipant(participant);
        return participant;
    }

    @DeleteMapping("/{id}")
    public String deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return "Клиент удален";
    }
}
