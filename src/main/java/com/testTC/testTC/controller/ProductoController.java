package com.testTC.testTC.controller;

import com.testTC.testTC.dto.ProductoDTO;
import com.testTC.testTC.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/producto")

public class ProductoController {
    @Autowired
    ProductoService serviceProducto;
    @PostMapping("/crear")
    public ResponseEntity<ProductoDTO> crear(@RequestBody ProductoDTO productoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceProducto.crear(productoDTO));
    }

    @GetMapping("/traer")
    public ResponseEntity<List<ProductoDTO>> traer(){
        return ResponseEntity.ok(serviceProducto.listar());
    }
    @GetMapping("/traer/{cantidad}")
    public ResponseEntity<List<ProductoDTO>> traerxcantidad (@PathVariable Double cantidad){
        return ResponseEntity.ok(serviceProducto.filtrarXcantidad(cantidad));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<ProductoDTO> modificar(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        return ResponseEntity.ok(serviceProducto.modificar(id, productoDTO));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrar (@PathVariable Long id) {
        serviceProducto.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
