package com.testTC.testTC.controller;

import com.testTC.testTC.dto.ClienteDTO;
import com.testTC.testTC.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name ="Endpoints de Cliente", description = "Gestion de los clientes asociados.")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService serviceCliente;

    @Operation(summary = "Crea un nuevo cliente asociado")
    @PostMapping("/crear")
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO creado = serviceCliente.crear(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }


    @GetMapping("/traer")
    @Operation(summary = "Trae todos los clientes asociados")
    public ResponseEntity<List<ClienteDTO>> listar(){
        return ResponseEntity.ok(serviceCliente.listar());
    }

    @PutMapping("/modificar/{id}")
    @Operation(summary = "Modifica clientes asociados a partir del numero de Id")
    public ResponseEntity<ClienteDTO> modificar (@PathVariable Long id, @RequestParam ClienteDTO clienteDTO){
        return ResponseEntity.ok(serviceCliente.modificar(id, clienteDTO));
    }

    @DeleteMapping("/borrar/{id}")
    @Operation(summary = "Elimina algun cliente asociado de acuerdo a un numero de Id")
    public ResponseEntity<Void> borrar(@PathVariable Long id){
        serviceCliente.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
