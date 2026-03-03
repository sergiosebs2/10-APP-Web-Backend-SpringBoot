package com.testTC.testTC.controller;

import com.testTC.testTC.dto.ClienteDTO;
import com.testTC.testTC.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService serviceCliente;

    @PostMapping("/crear")
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO creado = serviceCliente.crear(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/traer")
    public ResponseEntity<List<ClienteDTO>> listar(){
        return ResponseEntity.ok(serviceCliente.listar());
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<ClienteDTO> modificar (@PathVariable Long id, @RequestParam ClienteDTO clienteDTO){
        return ResponseEntity.ok(serviceCliente.modificar(id, clienteDTO));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id){
        serviceCliente.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
