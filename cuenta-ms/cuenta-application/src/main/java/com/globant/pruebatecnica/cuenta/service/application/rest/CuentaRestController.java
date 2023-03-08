package com.globant.pruebatecnica.cuenta.service.application.rest;

import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;
import com.globant.pruebatecnica.cuenta.service.domain.ports.input.CuentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
@Slf4j
public class CuentaRestController {
    private CuentaService cuentaService;

    public CuentaRestController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Cuenta>> getCuentas(){
        return new ResponseEntity<>(this.cuentaService.getCuentas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cuenta> registrarCuenta(@RequestBody Cuenta cuenta){
        log.info("Registrando cuenta con numero: {}", cuenta.getNumeroCuenta());
        return new ResponseEntity<>(cuentaService.save(cuenta), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cuenta> actualizarCuenta(@RequestBody Cuenta cuenta){
        log.info("Actualizando cuenta con id: {}", cuenta.getNumeroCuenta());
        return new ResponseEntity<>(cuentaService.update(cuenta), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> actualizarCuenta(@PathVariable Integer id){
        log.info("Eliminando cuenta con id: {}", id);
        cuentaService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
