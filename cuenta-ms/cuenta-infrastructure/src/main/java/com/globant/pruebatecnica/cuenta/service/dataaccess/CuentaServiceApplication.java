package com.globant.pruebatecnica.cuenta.service.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.globant.pruebatecnica.cuenta.service.dataaccess" +
    ".adapter", "com.globant.pruebatecnica.cuenta.service.dataaccess.repository",
    "com.globant.pruebatecnica.cuenta.service.domain.ports.output"})
@EntityScan(basePackages = {"com.globant.pruebatecnica.cuenta.service.dataaccess",
    "com.globant.pruebatecnica.dataaccess.cliente.entity"})
@SpringBootApplication(scanBasePackages = "com.globant.pruebatecnica")
public class CuentaServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CuentaServiceApplication.class, args);
  }

}
