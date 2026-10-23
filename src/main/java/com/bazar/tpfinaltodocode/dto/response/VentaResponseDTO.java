package com.bazar.tpfinaltodocode.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VentaResponseDTO {
    private Long codigo_venta;
    private LocalDateTime fecha_venta;
    private BigDecimal total;
    private List<ProductoResponseDTO> listaProductos;
    private ClienteResponseDTO unCliente;
}
