package com.bazar.tpfinaltodocode.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaResponseDTO {
    private Long id;
    private LocalDateTime fecha_venta;
    private BigDecimal total;
    private List<ProductoResponseDTO> listaProductos;
    private ClienteResponseDTO cliente;
}
