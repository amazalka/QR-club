package com.example.service;

import com.example.dto.ParticipantResponse;
import com.example.entity.ParticipantEntity;

import java.util.UUID;

public interface QRService {
    ParticipantResponse checkQR(UUID uuid);
}
