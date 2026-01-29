package com.example.repository;

import com.example.entity.Participant;
import com.example.entity.QRCode;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class QRRepository {
    @PersistenceContext
    private EntityManager entityManager;

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
