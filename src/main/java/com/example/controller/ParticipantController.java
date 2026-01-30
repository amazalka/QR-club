package com.example.controller;

import com.example.dto.ParticipantResponse;
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
    public ParticipantResponse addParticipant(@RequestBody ParticipantResponse participant) {
        return participantService.addParticipant(participant);
    }

    @PutMapping("/")
    public ParticipantResponse updateParticipant(@RequestBody ParticipantResponse participant) {
        return participantService.updateParticipant(participant);
    }

    @DeleteMapping("/{id}")
    public Long deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return id;
    }
}
