package com.bazar.tpfinaltodocode.mapper;

import com.bazar.tpfinaltodocode.dto.request.ClienteRequestDTO;
import com.bazar.tpfinaltodocode.dto.response.ClienteResponseDTO;
import com.bazar.tpfinaltodocode.model.Cliente;
import com.bazar.tpfinaltodocode.repository.ClienteRepository;

public class ClienteMapper {
    public static Cliente toEntity(ClienteRequestDTO dto){
        if(dto==null)return null;

        return Cliente.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .dni(dto.getDni())
                .build();
    }

    public static ClienteResponseDTO toDTO(Cliente cliente){
        if(cliente==null)return null;

        return ClienteResponseDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .dni(cliente.getDni())
                .build();
    }
}
