package com.testTC.testTC.service;

import com.testTC.testTC.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {
    ClienteDTO crear(ClienteDTO clienteDTO);
    List<ClienteDTO> listar();
    void eliminar(Long id);
    ClienteDTO modificar(Long id, ClienteDTO clienteDTO);
}
