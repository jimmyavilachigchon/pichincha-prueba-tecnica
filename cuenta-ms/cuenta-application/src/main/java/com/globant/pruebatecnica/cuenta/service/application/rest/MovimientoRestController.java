package com.globant.pruebatecnica.cuenta.service.application.rest;

import com.globant.pruebatecnica.cuenta.service.domain.dto.ReporteMovimientosResponse;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Movimiento;
import com.globant.pruebatecnica.cuenta.service.domain.ports.input.MovimientoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/movimientos")
@Slf4j
public class MovimientoRestController {
  private MovimientoService movimientoService;

  public MovimientoRestController(MovimientoService movimientoService) {
    this.movimientoService = movimientoService;
  }

  @GetMapping("/reportes")
  public ResponseEntity<Iterable<ReporteMovimientosResponse>> getMovimientos(@RequestParam(required = true) String numeroCuenta,
                                                                             @RequestParam(required = true) String inicio,
                                                                             @RequestParam(required = true) String fin) {
    return new ResponseEntity<>(this.movimientoService.getMovimientos(numeroCuenta, LocalDate.parse(inicio),
        LocalDate.parse(fin)), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Movimiento> registrarMovimiento(@RequestBody Movimiento movimiento){
    log.info("Registrando movimiento para la cuenta con ID: {}", movimiento.getCuenta().getId());
    return new ResponseEntity<>(movimientoService.save(movimiento), HttpStatus.CREATED);
  }

}
