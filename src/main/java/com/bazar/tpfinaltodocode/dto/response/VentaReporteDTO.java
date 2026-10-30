package com.bazar.tpfinaltodocode.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class VentaReporteDTO {
    private int cantidadVentas;
    private BigDecimal totalMonto;
}