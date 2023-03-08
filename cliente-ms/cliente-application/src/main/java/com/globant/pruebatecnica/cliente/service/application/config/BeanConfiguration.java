package com.globant.pruebatecnica.cliente.service.application.config;


import com.globant.pruebatecnica.cliente.service.domain.ports.input.ClienteServiceImpl;
import com.globant.pruebatecnica.cliente.service.domain.ports.input.ClienteService;
import com.globant.pruebatecnica.cliente.service.domain.ports.output.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class BeanConfiguration {

    //@Bean
    ClienteService clienteService(final ClienteRepository clienteRepository){
        return new ClienteServiceImpl(clienteRepository);
    }
}
