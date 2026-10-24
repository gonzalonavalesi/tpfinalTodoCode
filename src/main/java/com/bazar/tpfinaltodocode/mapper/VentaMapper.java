package com.bazar.tpfinaltodocode.mapper;

import com.bazar.tpfinaltodocode.dto.request.VentaRequestDTO;
import com.bazar.tpfinaltodocode.dto.response.VentaResponseDTO;
import com.bazar.tpfinaltodocode.model.Venta;

public class VentaMapper {

    public static VentaResponseDTO toDTO(Venta venta){
        if(venta==null)return null;

        return VentaResponseDTO.builder()
                .id(venta.getId())
                .listaProductos(venta.getListaProductos() != null ?
                        venta.getListaProductos().stream().map(ProductoMapper::toDTO)
                                .toList()
                                : null)
                .fecha_venta(venta.getFecha())
                .cliente(ClienteMapper.toDTO(venta.getCliente()))
                .total(venta.getTotal())
                .build();

    }
}
