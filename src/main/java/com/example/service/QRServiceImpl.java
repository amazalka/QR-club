package com.example.service;

import com.example.entity.Participant;
import com.example.repository.QRRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class QRServiceImpl implements QRService {
    private QRRepository qrRepository;

    public QRServiceImpl(QRRepository qrRepository) {
        this.qrRepository = qrRepository;
    }

    @Override
    public Participant checkQR(UUID uuid) {
        return qrRepository.checkQR(uuid);
    }
}
