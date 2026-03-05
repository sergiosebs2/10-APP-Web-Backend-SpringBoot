package com.testTC.testTC.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder @NoArgsConstructor @AllArgsConstructor
@Schema(description = "DTO creado para representar estadistica sobre las ventas del dia")
public class ResumendiaDTO {
    private Integer ventasTotal;
    private Double recaudacionTotal;
}
