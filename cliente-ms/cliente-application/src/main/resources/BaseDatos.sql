DROP TABLE IF EXISTS movimiento;
DROP TABLE IF EXISTS cuenta;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS persona;

CREATE TABLE persona (
id SERIAL NOT NULL,
nombre varchar(100) NOT NULL,
genero char(1),
edad int NOT NULL,
identificacion varchar(20),
direccion varchar(100),
telefono varchar(20),
constraint persona_pk PRIMARY KEY (id));

CREATE TABLE cliente (
id SERIAL NOT NULL,
password varchar(100) NOT NULL,
estado boolean,
constraint cliente_pk PRIMARY KEY (id));

ALTER TABLE cliente ADD CONSTRAINT fk_persona_cliente_01 FOREIGN KEY (id) REFERENCES persona (id);
CREATE UNIQUE INDEX ui_persona_01 ON persona (identificacion);
-----

CREATE TABLE cuenta (
id SERIAL NOT NULL,
numero_cuenta varchar(50) NOT NULL,
tipo_cuenta varchar(30) NOT NULL,
saldo_inicial numeric(10,2) NOT NULL,
estado boolean NOT NULL,
cliente_id int NOT NULL,
constraint cuenta_pk PRIMARY KEY (id));

CREATE TABLE movimiento (
id SERIAL NOT NULL,
fecha date NOT NULL,
tipo_Movimiento varchar(30) NOT NULL,
valor numeric(10,2) NOT NULL,
saldo numeric(10,2) NOT NULL,
cuenta_id int NOT NULL,
constraint movimiento_pk PRIMARY KEY (id));

ALTER TABLE cuenta ADD CONSTRAINT fk_cliente_cuenta_01
FOREIGN KEY (cliente_id) REFERENCES cliente (id);

ALTER TABLE movimiento ADD CONSTRAINT fk_cuenta_movimiento_01
FOREIGN KEY (cuenta_id) REFERENCES cuenta (id);
CREATE UNIQUE INDEX ui_cuenta_01 ON cuenta (numero_cuenta);


--INSERT INTO persona(nombre, genero, edad, identificacion, direccion, telefono)
--	VALUES ('Jose Lema', 'M', 30, '42536464', 'Otavalo sn y principal', '098254785'),
--	('Marianela Montalvo', 'F', 25, '63524354', 'Amazonas y NNUU', '097548965'),
--    ('Juan Osorio', 'M', 35, '53356786', '13 junio y Equinoccial', '098874587');

--INSERT INTO cliente(id, password, estado)
--	VALUES (1, '1234', true),
--	(2, '5678', true),
--	(3, '1245', true);

-----
SELECT * FROM persona;
SELECT * FROM cliente;
SELECT * FROM persona p INNER JOIN cliente c on p.id=c.id