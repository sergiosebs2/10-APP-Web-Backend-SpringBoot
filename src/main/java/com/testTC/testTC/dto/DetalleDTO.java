package com.testTC.testTC.dto;

import com.testTC.testTC.model.Producto;
import com.testTC.testTC.model.Venta;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter @Getter @NoArgsConstructor@AllArgsConstructor @Builder
@Schema(description = "DTO creada para una correcta representacion de la relacion entre Producto y Venta")
public class DetalleDTO {
    private Integer cantidad;
    private Double precio_unitario;
    private String nombre_producto;
}

