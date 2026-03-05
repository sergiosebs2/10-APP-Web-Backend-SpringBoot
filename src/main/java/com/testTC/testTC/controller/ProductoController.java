package com.testTC.testTC.controller;

import com.testTC.testTC.dto.ProductoDTO;
import com.testTC.testTC.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/producto")
@Tag(name ="Endpoints de Producto", description = "Gestion de los productos registrados.")


public class ProductoController {
    @Autowired
    ProductoService serviceProducto;

    @PostMapping("/crear")
    @Operation(summary = "Crea un Producto enviado desde el Body")
    public ResponseEntity<ProductoDTO> crear(@RequestBody ProductoDTO productoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceProducto.crear(productoDTO));
    }

    @GetMapping("/traer")
    @Operation(summary = "Trae todos los productos guardados")
    public ResponseEntity<List<ProductoDTO>> traer(){
        return ResponseEntity.ok(serviceProducto.listar());
    }
    @GetMapping("/traer/{cantidad}")
    @Operation(summary = "Trae todos los productos cuyo stock sea menor a la cantidad enviada")
    public ResponseEntity<List<ProductoDTO>> traerxcantidad (@PathVariable Double cantidad){
        return ResponseEntity.ok(serviceProducto.filtrarXcantidad(cantidad));
    }

    @PutMapping("/modificar/{id}")
    @Operation(summary = "Modifica un producto de acuerdo a un Id especificado")
    public ResponseEntity<ProductoDTO> modificar(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        return ResponseEntity.ok(serviceProducto.modificar(id, productoDTO));
    }

    @DeleteMapping("/borrar/{id}")
    @Operation(summary = "Borra un producto de la base de datos de acuerdo a un número de Id")
    public ResponseEntity<Void> borrar (@PathVariable Long id) {
        serviceProducto.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
