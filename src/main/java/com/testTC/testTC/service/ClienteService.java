package com.testTC.testTC.service;

import com.testTC.testTC.dto.ClienteDTO;
import com.testTC.testTC.exception.ObjetoNoEncontrado;
import com.testTC.testTC.mapper.Mapper;
import com.testTC.testTC.model.Cliente;
import com.testTC.testTC.repository.ClienteRepository;
import com.testTC.testTC.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    ClienteRepository repoCliente;
    @Override
    public ClienteDTO crear(ClienteDTO clienteDTO) {
        if(clienteDTO == null) throw new ObjetoNoEncontrado("Debe ser valido");
        Cliente cliente = Cliente.builder()
                .dni(clienteDTO.getDni())
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .build();
        return Mapper.deClienteaDTO(repoCliente.save(cliente));
    }

    @Override
    public List<ClienteDTO> listar() {
        return repoCliente.findAll().stream().map(Mapper::deClienteaDTO).toList();
    }

    @Override
    public void eliminar(Long id) {
        if (repoCliente.existsById(id)) repoCliente.deleteById(id);
            else throw new ObjetoNoEncontrado("No existe en la BD");
    }

    @Override
    public ClienteDTO modificar(Long id, ClienteDTO clienteDTO) {
       Cliente cliente = repoCliente.findById(id).orElseThrow(()->new ObjetoNoEncontrado("No existe en la BD"));
        if (clienteDTO.getNombre()!=null) cliente.setNombre(clienteDTO.getNombre());
        if (clienteDTO.getApellido()!=null) cliente.setApellido(clienteDTO.getApellido());
        if (clienteDTO.getDni()!=null) cliente.setDni(clienteDTO.getDni());
        return Mapper.deClienteaDTO(repoCliente.save(cliente));

    }
}
