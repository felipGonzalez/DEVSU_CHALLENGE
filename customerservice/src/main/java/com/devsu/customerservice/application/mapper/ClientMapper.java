package com.devsu.customerservice.application.mapper;

import com.devsu.customerservice.application.dto.ClientCreateDTO;
import com.devsu.customerservice.application.dto.ClientResponseDTO;
import com.devsu.customerservice.application.dto.ClientUpdateDTO;
import com.devsu.customerservice.domain.model.Client;

public interface ClientMapper {

    static Client toEntity(ClientCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        Client entity = new Client();
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setAge(dto.getAge());
        entity.setIdentification(dto.getIdentification());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setPassword(dto.getPassword());
        entity.setStatus(dto.isStatus());
        entity.generateClientId();
        return entity;
    }

    static ClientResponseDTO toDTO(Client entity) {
        if (entity == null) {
            return null;
        }
        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setName(entity.getName());
        dto.setGender(entity.getGender());
        dto.setAge(entity.getAge());
        dto.setIdentification(entity.getIdentification());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        dto.setClientId(entity.getClientId() != null ? entity.getClientId().getValue() : null);
        dto.setStatus(entity.isStatus());
        return dto;
    }

    static void updateFromDTO(ClientUpdateDTO dto, Client entity) {
        if (dto == null || entity == null) {
            return;
        }
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getGender() != null) {
            entity.setGender(dto.getGender());
        }
        if (dto.getAge() > 0) {
            entity.setAge(dto.getAge());
        }
        if (dto.getIdentification() != null) {
            entity.setIdentification(dto.getIdentification());
        }
        if (dto.getAddress() != null) {
            entity.setAddress(dto.getAddress());
        }
        if (dto.getPhone() != null) {
            entity.setPhone(dto.getPhone());
        }
        if (dto.getStatus() != null) {
            entity.setStatus(dto.getStatus());
        }
    }

}
