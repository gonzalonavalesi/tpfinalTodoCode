package com.bazar.tpfinaltodocode.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoResponseDTO {
    private Long id;
    private String nombre;
    private String marca;
    private BigDecimal costo;
    private Integer cantidad_disponible;
}
