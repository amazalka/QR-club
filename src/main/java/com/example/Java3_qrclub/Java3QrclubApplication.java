package com.example.Java3_qrclub;

import com.example.Java3_qrclub.entity.Participant;
import com.example.Java3_qrclub.service.QRService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class Java3QrclubApplication {
    public static void main(String[] args) {
        SpringApplication.run(Java3QrclubApplication.class, args);
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean(QRService qrService) {
        return (args) -> {
            UUID uuid = UUID.fromString("862d394e-25fa-4929-adfa-6c48ade1264d");
            Participant participant = qrService.checkQR(uuid);
            if (participant == null) {
                System.out.println("QR-code не найден");
            } else {
                System.out.println("QR-code найден");
                System.out.printf("%s %s %s \n", participant.getName(), participant.getLastName(), participant.getMiddleName());
                System.out.println("Новый QR-code: " + participant.getUuid());
            }
        };
    }
}
