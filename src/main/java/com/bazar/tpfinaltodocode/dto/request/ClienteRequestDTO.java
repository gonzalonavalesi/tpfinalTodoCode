package com.bazar.tpfinaltodocode.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequestDTO {
    private String nombre;
    private String apellido;
    private String dni;
}
