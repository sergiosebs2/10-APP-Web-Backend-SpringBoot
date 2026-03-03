package com.testTC.testTC.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private Double total;
    @OneToMany (mappedBy = "venta", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetalleItemVenta> listaDetalleItem = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente unCliente;
}
