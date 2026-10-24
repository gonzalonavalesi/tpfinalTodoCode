package com.bazar.tpfinaltodocode.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String marca;
    @Column(nullable = false,precision = 10, scale = 2)
    private BigDecimal costo;
    @Column(nullable = false)
    private Integer cantidad_disponible;

}
