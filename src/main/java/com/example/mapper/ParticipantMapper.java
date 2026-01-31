package com.example.mapper;

import com.example.dto.ParticipantRequest;
import com.example.dto.ParticipantResponse;
import com.example.entity.ParticipantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParticipantMapper {
    ParticipantResponse toResponse(ParticipantEntity participant);
    ParticipantEntity toEntity(ParticipantRequest participant);
}
