package com.testTC.testTC.dto;

import com.testTC.testTC.model.Producto;
import com.testTC.testTC.model.Venta;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter @Getter @NoArgsConstructor@AllArgsConstructor @Builder

public class DetalleDTO {
    private Integer cantidad;
    private Double precio_unitario;
    private String nombre_producto;
}

