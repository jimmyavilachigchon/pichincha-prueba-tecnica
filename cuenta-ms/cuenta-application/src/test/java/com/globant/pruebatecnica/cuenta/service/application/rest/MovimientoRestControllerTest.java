package com.globant.pruebatecnica.cuenta.service.application.rest;


import com.globant.pruebatecnica.cuenta.service.domain.dto.ReporteMovimientosResponse;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Movimiento;
import com.globant.pruebatecnica.cuenta.service.domain.ports.input.MovimientoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovimientoRestControllerTest {

  @Mock
  private MovimientoService movimientoService;

  @InjectMocks
  private MovimientoRestController movimientoRestController;

  @Test
  public void createMovimientoOk() {
    Movimiento movimiento =
        new Movimiento.Builder().cuenta(new Cuenta.Builder().id(1).build()).build();
    when(movimientoService.save(movimiento)).thenReturn(movimiento);
    ResponseEntity<Movimiento> responseEntity = movimientoRestController.registrarMovimiento(
        movimiento);
    assertNotNull(responseEntity);
    assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
  }

  @Test
  public void getMovimientosOk() {
    ReporteMovimientosResponse movimiento1 = ReporteMovimientosResponse.builder().build();
    ReporteMovimientosResponse movimiento2 = ReporteMovimientosResponse.builder().build();
    List<ReporteMovimientosResponse> lista = new ArrayList<>();
    lista.add(movimiento1);
    lista.add(movimiento2);
    when(movimientoService.getMovimientos(anyString(), any(), any())).thenReturn(lista);
    ResponseEntity<Iterable<ReporteMovimientosResponse>> response = movimientoRestController.getMovimientos(
        "123212", "2023-01-20", "2023-01-25");
    assertNotNull(response);
  }
}
