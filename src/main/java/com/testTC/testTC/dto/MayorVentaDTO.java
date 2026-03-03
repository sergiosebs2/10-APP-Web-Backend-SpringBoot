package com.testTC.testTC.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MayorVentaDTO {
    private Long codigoVenta;
    private Integer cantidadProductos;
    private String nombre;
    private String apellido;
    private Double monto;
}
