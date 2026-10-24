package com.bazar.tpfinaltodocode.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
}
