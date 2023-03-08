#Reto Tecnico Pichincha App
Application to register and consult clients, accounts and transactions.
## Software requirements
- Java JDK 11
- Docker
## Architecture
This project use Clean Code Architecture and Hexagonal Architecture. The 
architecture permits switch the adapters easily to external database or REST services as improvement.

## Technology
The application use the next tools and frameworks:
- Java 11
- Maven 3.9
- Spring Boot 2
- JPA 2
- Postgresql Database
- Lombok
- Junit 4
## Structure folders
### Main source folder
- "com.globant.pruebatecnica" as package base
- "application" subpackage for logic application
- "domain" subpackage to deliver information to client
- "infrastructure" subpackage to implements specific integrations to external tools
- "resources" package to locate config files to application
### Test source folder
- "com.globant.pruebatecnica" as package base
- "test" subpackage to implements Unit Test and Integration Test of application
- "resources" package to locate config files for testing
## Installation instructions
1. Conexión a base de datos
- Crear la base de datos pruebatecnica
- Ejecutar el script de base datos BaseDatos.sql ubicado en 
\cliente-ms\cliente-application\scr\main\resources\BaseDatos.sql
- Actualizar los parametros de conexión de la aplicación en los módulos cliente-application y 
  cuenta-application
2. Unzip the code
3. Execute the next code in command line console to compile and run test:

Windows:
```
mvn clean install
```
MacOs/Linux
```
./mvn clean install
```
4. Execute the next code to run test
   Windows:
```
mvn test
```
MacOs/Linux
```
./mvn test
```
5. Execute the next code to generate Docker image
   
Windows:
```
mvn spring-boot:build-image
```
MacOs/Linux
```
./mvn spring-boot:build-image
```
6. To view the test report, open the next file relative to this project folder
```
target/surefire-reports
```
7. To view the coverage code report, open the nex file relative to this project folder
```
target/jacoco-report/jacoco-resources/index.html