package com.testTC.testTC.dto;

import lombok.*;
import org.springframework.data.repository.NoRepositoryBean;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDTO {
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
}
