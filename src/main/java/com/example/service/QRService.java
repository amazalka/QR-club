package com.example.service;

import com.example.dto.ParticipantResponse;

import java.util.UUID;

public interface QRService {
    ParticipantResponse checkQR(UUID uuid);
}
