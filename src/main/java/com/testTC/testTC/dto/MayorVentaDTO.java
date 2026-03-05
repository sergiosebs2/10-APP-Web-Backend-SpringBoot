package com.testTC.testTC.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para poder consultar la mayor venta realizada")
public class MayorVentaDTO {
    private Long codigoVenta;
    private Integer cantidadProductos;
    private String nombre;
    private String apellido;
    private Double monto;
}
