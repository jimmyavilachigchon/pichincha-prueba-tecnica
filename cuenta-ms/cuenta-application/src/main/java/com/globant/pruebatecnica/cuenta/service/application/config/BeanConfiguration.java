package com.globant.pruebatecnica.cuenta.service.application.config;

import com.globant.pruebatecnica.cuenta.service.domain.ports.input.CuentaServiceImpl;
import com.globant.pruebatecnica.cuenta.service.domain.ports.input.CuentaService;
import com.globant.pruebatecnica.cuenta.service.domain.ports.output.CuentaRepository;

//@Configuration
public class BeanConfiguration {

    //@Bean
    CuentaService cuentaBeanService(final CuentaRepository cuentaRepository){
        return new CuentaServiceImpl(cuentaRepository);
    }
}
