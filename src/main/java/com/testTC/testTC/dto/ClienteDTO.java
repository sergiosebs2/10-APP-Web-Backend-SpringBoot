package com.testTC.testTC.dto;

import lombok.*;
import org.springframework.data.repository.NoRepositoryBean;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {
    private String nombre;
    private String apellido;
    private String dni;
}
