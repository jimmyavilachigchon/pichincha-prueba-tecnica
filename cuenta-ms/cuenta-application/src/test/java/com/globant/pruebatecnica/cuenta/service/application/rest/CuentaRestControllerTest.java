package com.globant.pruebatecnica.cuenta.service.application.rest;

import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;
import com.globant.pruebatecnica.cuenta.service.domain.ports.input.CuentaService;
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
public class CuentaRestControllerTest {


  @Mock
  private CuentaService cuentaService;

  @InjectMocks
  private CuentaRestController cuentaRestController;

  @Test
  public void createCuentaOk() {
    Cuenta cuenta = new Cuenta.Builder().build();
    when(cuentaService.save(cuenta)).thenReturn(cuenta);
    ResponseEntity<Cuenta> responseEntity = cuentaRestController.registrarCuenta(cuenta);
    assertNotNull(responseEntity);
    assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
  }

  @Test
  public void getCuentasOk() {
    Cuenta cuenta1 = new Cuenta.Builder().id(1).build();
    Cuenta cuenta2 = new Cuenta.Builder().id(2).build();
    List<Cuenta> lista = new ArrayList<>();
    lista.add(cuenta1);
    lista.add(cuenta2);
    when(cuentaService.getCuentas()).thenReturn(lista);
    ResponseEntity<Iterable<Cuenta>> response = cuentaRestController.getCuentas();
    assertNotNull(response);
  }
}
