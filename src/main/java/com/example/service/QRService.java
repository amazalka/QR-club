package com.example.service;

import com.example.entity.Participant;

import java.util.UUID;

public interface QRService {
    Participant checkQR(UUID uuid);
}
