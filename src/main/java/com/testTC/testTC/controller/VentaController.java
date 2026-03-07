package com.testTC.testTC.controller;

import com.testTC.testTC.dto.DetalleDTO;
import com.testTC.testTC.dto.MayorVentaDTO;
import com.testTC.testTC.dto.ResumendiaDTO;
import com.testTC.testTC.dto.VentaDTO;
import com.testTC.testTC.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/venta")
@Tag(name ="Endpoints de Ventas", description = "Gestion de los ventas registradas.")

public class VentaController {
    @Autowired
    VentaService serviceVenta;

    @PostMapping("/crear")
    @Operation(summary = "Crea una Venta a partir de un json enviado desde el Body")
    public ResponseEntity<VentaDTO> crear(@RequestBody VentaDTO ventaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceVenta.crear(ventaDTO));
    }

    @GetMapping("/traer")
    @Operation(summary = "Trae todos los registros de Ventas")
    public ResponseEntity<List<VentaDTO>> listar() {
        return ResponseEntity.ok(serviceVenta.listar());
    }

    @GetMapping("/traerDetalles/{id}")
    @Operation(summary = "Trae la lista de detalles de una venta a partir de su número de Id")
    public ResponseEntity<List<DetalleDTO>> traerDetalles(@PathVariable Long id){
        return ResponseEntity.ok(serviceVenta.traerDetallesdeVentaxID(id));
    }
    @GetMapping("/estadistica")
    @Operation(summary = "Trae la estadistica de ventas del dia específicado")
    public ResponseEntity<ResumendiaDTO> traerEstadistica(@RequestParam LocalDate fecha){
        return ResponseEntity.ok(serviceVenta.traerEstadisticaDia(fecha));
    }
    @GetMapping ("/mayorventa")
    @Operation(summary = "Trae los datos de la mayor venta realizada")
    public ResponseEntity<MayorVentaDTO> traerMayorVenta(){
        return ResponseEntity.ok(serviceVenta.traerMayorVenta());
    }

    @DeleteMapping ("/borrar/{id}")
    @Operation(summary = "Borra una Venta de acuerdo a un número de Id")
    public ResponseEntity<Void> borrar (@PathVariable Long id){
        serviceVenta.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
