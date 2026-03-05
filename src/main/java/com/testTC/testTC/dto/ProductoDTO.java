package com.testTC.testTC.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.repository.NoRepositoryBean;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de la entidad Producto")
public class ProductoDTO {
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
}
