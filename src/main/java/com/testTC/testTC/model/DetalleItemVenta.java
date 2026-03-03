package com.testTC.testTC.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleItemVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private Double precio_unitario;
    //- Esto indica que la relación está mapeada desde el lado de DetalleItemVenta
    @ManyToOne
    @JoinColumn(name = "codigo_venta")
    private Venta venta;
    @ManyToOne
    @JoinColumn(name="codigo_producto")
    private Producto producto;
}
