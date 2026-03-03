package com.testTC.testTC.controller;

import com.testTC.testTC.dto.DetalleDTO;
import com.testTC.testTC.dto.MayorVentaDTO;
import com.testTC.testTC.dto.ResumendiaDTO;
import com.testTC.testTC.dto.VentaDTO;
import com.testTC.testTC.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    VentaService serviceVenta;

    @PostMapping("/crear")
    public ResponseEntity<VentaDTO> crear(@RequestBody VentaDTO ventaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceVenta.crear(ventaDTO));
    }

    @GetMapping("/traer")
    public ResponseEntity<List<VentaDTO>> listar() {
        return ResponseEntity.ok(serviceVenta.listar());
    }

    @GetMapping("/traerDetalles/{id}")
    public ResponseEntity<List<DetalleDTO>> traerDetalles(@PathVariable Long id){
        return ResponseEntity.ok(serviceVenta.traerporId(id));
    }
    @GetMapping("/estadistica")
    public ResponseEntity<ResumendiaDTO> traerEstadistica(@RequestParam LocalDate fecha){
        return ResponseEntity.ok(serviceVenta.traerEstadisticaDia(fecha));
    }
    @GetMapping ("/mayorventa")
    public ResponseEntity<MayorVentaDTO> traerMayorVenta(){
        return ResponseEntity.ok(serviceVenta.traerMayorVenta());
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<Void> borrar (@PathVariable Long id){
        serviceVenta.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
