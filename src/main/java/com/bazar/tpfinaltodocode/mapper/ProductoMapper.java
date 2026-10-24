package com.bazar.tpfinaltodocode.mapper;

import com.bazar.tpfinaltodocode.dto.request.ClienteRequestDTO;
import com.bazar.tpfinaltodocode.dto.request.ProductoRequestDTO;
import com.bazar.tpfinaltodocode.dto.response.ClienteResponseDTO;
import com.bazar.tpfinaltodocode.dto.response.ProductoResponseDTO;
import com.bazar.tpfinaltodocode.model.Producto;

public class ProductoMapper {

    public static Producto toEntity(ProductoRequestDTO dto){

        if(dto==null)return null;

        return Producto.builder()
                .nombre(dto.getNombre())
                .marca(dto.getMarca())
                .costo(dto.getCosto())
                .cantidad_disponible(dto.getCantidad_disponible())
                .build();
    }

    public static ProductoResponseDTO toDTO(Producto producto){

        if(producto==null)return null;

        return ProductoResponseDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .marca(producto.getMarca())
                .costo(producto.getCosto())
                .cantidad_disponible(producto.getCantidad_disponible())
                .build();
    }
}
