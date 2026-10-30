package com.bazar.tpfinaltodocode.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MayorVentaDTO {
    private Long id;
    private BigDecimal total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;
}
