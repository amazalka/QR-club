package com.example.service;

import com.example.entity.Participant;
import com.example.entity.QRCode;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class QRServiceImpl implements QRService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Participant checkQR(UUID uuid) {
        QRCode qrCode = entityManager.createQuery("SELECT q FROM QRCode q WHERE q.uuid = :uuid", QRCode.class)
                .setParameter("uuid", uuid)
                .getResultStream()
                .findFirst()
                .orElse(null);
        if (qrCode == null) {
            return null;
        }
        qrCode.setUuid(UUID.randomUUID());
        entityManager.merge(qrCode);
        System.out.println("Новый UUID: " + qrCode.getUuid());
        return qrCode.getParticipant();
    }
}
