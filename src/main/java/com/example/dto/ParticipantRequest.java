package com.example.dto;

import lombok.Data;

@Data
public class ParticipantRequest {
    private Long id;
    private String name;
    private String lastName;
    private String middleName;
}
