package com.bazar.tpfinaltodocode.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaRequestDTO {
    private List<Long> codigosProductos;
    private Long codigo_cliente;
}
