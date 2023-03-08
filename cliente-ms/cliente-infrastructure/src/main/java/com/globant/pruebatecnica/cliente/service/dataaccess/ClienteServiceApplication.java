package com.globant.pruebatecnica.cliente.service.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.globant.pruebatecnica.cliente.service.dataaccess" })
@EntityScan(basePackages = { "com.globant.pruebatecnica.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.globant.pruebatecnica")
public class ClienteServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClienteServiceApplication.class, args);
    }

}
