package com.example.controller;

import com.example.entity.Participant;
import com.example.service.QRService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/QRcodes")
public class QRController {
    private QRService qrService;

    public QRController(QRService qrService) {
        this.qrService = qrService;
    }

    @GetMapping("/{uuid}")
    public Participant checkQR(@PathVariable UUID uuid){
        return qrService.checkQR(uuid);
    }
}
