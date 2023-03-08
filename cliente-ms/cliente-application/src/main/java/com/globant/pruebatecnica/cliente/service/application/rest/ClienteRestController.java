package com.globant.pruebatecnica.cliente.service.application.rest;

import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;
import com.globant.pruebatecnica.cliente.service.domain.ports.input.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@Slf4j
public class ClienteRestController {
    private ClienteService clienteService;

    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> getClientes(){
        return new ResponseEntity<>(this.clienteService.getClientes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente){
        log.info("Registrando cliente con id: {}", cliente.getIdentificacion());
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente){
        log.info("Actualizando cliente con identificacion: {}", cliente.getIdentificacion());
        return new ResponseEntity<>(clienteService.update(cliente), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id){
        log.info("Eliminando cliente con id: {}", id);
        clienteService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
