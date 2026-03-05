package com.testTC.testTC.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.repository.NoRepositoryBean;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de la entidad Cliente")

public class ClienteDTO {
    private String nombre;
    private String apellido;
    private String dni;
}
