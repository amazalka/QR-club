package com.example.controller;

import com.example.mapper.ParticipantMapper;
import com.example.dto.ParticipantResponse;
import com.example.entity.ParticipantEntity;
import com.example.service.QRService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/QRcodes")
public class QRController {
    private QRService qrService;
    private ParticipantMapper participantMapper;
    public QRController(QRService qrService, ParticipantMapper participantMapper) {
        this.qrService = qrService;
        this.participantMapper = participantMapper;
    }

    @GetMapping("/{uuid}")
    public ParticipantResponse checkQR(@PathVariable UUID uuid){
        return qrService.checkQR(uuid);
    }
}
