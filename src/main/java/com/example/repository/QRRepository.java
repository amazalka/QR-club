package com.example.repository;

import com.example.entity.ParticipantEntity;
import com.example.entity.QRCodeEntity;
import com.example.exception.QRcodeNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class QRRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public ParticipantEntity checkQR(UUID uuid) {
        QRCodeEntity qrCodeEntity = entityManager.createQuery("SELECT q FROM QRCodeEntity q WHERE q.uuid = :uuid", QRCodeEntity.class)
                .setParameter("uuid", uuid)
                .getResultStream()
                .findFirst()
                .orElse(null);
        if (qrCodeEntity == null) {
            throw new QRcodeNotFoundException("QR-код не найден");
        }
        qrCodeEntity.setUuid(UUID.randomUUID());
        entityManager.merge(qrCodeEntity);
        System.out.println("Новый UUID: " + qrCodeEntity.getUuid());
        return qrCodeEntity.getParticipantEntity();
    }
}
