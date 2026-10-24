package com.bazar.tpfinaltodocode.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false,length = 50)
    private String apellido;
    @Column(nullable = false,length = 50)
    private String dni;
}
