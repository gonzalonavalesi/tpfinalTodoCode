package com.bazar.tpfinaltodocode.dto.request;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaRequestDTO {
    private List<Long> ListaProductos;
    private Long codigo_cliente;
}
