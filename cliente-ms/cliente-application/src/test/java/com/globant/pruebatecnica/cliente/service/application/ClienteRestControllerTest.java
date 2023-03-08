package com.globant.pruebatecnica.cliente.service.application;

import com.globant.pruebatecnica.cliente.service.application.rest.ClienteRestController;
import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;
import com.globant.pruebatecnica.cliente.service.domain.ports.input.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteRestControllerTest {

  @Mock
  private ClienteService clienteService;

  @InjectMocks
  private ClienteRestController clienteRestController;

  @Test
  public void createClienteOk() {
    Cliente cliente = new Cliente.Builder().build();
    when(clienteService.save(cliente)).thenReturn(cliente);
    ResponseEntity<Cliente> responseEntity = clienteRestController.registrarCliente(cliente);
    assertNotNull(responseEntity);
    assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
  }

  @Test
  public void getClientesOk() {
    Cliente cliente1 = new Cliente.Builder().id(1).build();
    Cliente cliente2 = new Cliente.Builder().id(2).build();
    List<Cliente> lista = new ArrayList<>();
    lista.add(cliente1);
    lista.add(cliente2);
    when(clienteService.getClientes()).thenReturn(lista);
    ResponseEntity<Iterable<Cliente>> response = clienteRestController.getClientes();
    assertNotNull(response);
  }
}
