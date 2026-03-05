package com.testTC.testTC.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de la entidad Venta")

public class VentaDTO {
    private LocalDate fecha_venta;
    private Double total;
    private List<DetalleDTO> listaDetalleItemDTO = new ArrayList<>();
    private Long id_cliente;
}
