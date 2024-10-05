CREATE DATABASE base;
USE base;

CREATE TABLE USUARIO (
    id_U INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    rut VARCHAR(20) NOT NULL,
    tipo ENUM ('Administrativo', 'Cliente', 'Profesional') NOT NULL
);

CREATE TABLE CLIENTE (
    id_U INT PRIMARY KEY, -- id_U actúa como clave primaria y también es la clave foránea
    telefono VARCHAR(100) NOT NULL,
    comuna VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_U) REFERENCES USUARIO(id_U) ON DELETE CASCADE
);

CREATE TABLE ADMINISTRATIVO (
    id_U INT PRIMARY KEY, -- id_U actúa como clave primaria y también es la clave foránea
    area VARCHAR(100) NOT NULL,
    experiencia_previa VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_U) REFERENCES USUARIO(id_U) ON DELETE CASCADE
);

CREATE TABLE PROFESIONAL (
    id_U INT PRIMARY KEY, -- id_U actúa como clave primaria y también es la clave foránea
    titulo VARCHAR(100) NOT NULL,
    fecha_ingreso VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_U) REFERENCES USUARIO(id_U) ON DELETE CASCADE
);

CREATE TABLE CAPACITACION (
id Int AUTO_INCREMENT PRIMARY KEY,
identificador INT not null,
dia VARCHAR(100) NOT NULL,
hora VARCHAR(100) NOT NULL,
lugar VARCHAR(100) NOT NULL,
duracion VARCHAR(100) NOT NULL,
cantidad_asistentes INT NOT NULL
);


-- Tabla "Visitas"
CREATE TABLE VISITAS (
  id_V INT PRIMARY KEY AUTO_INCREMENT,
  id_U INT NOT NULL,
  fecha_visita VARCHAR(100) NOT NULL,
  FOREIGN KEY (id_U) REFERENCES USUARIO(id_U) ON DELETE CASCADE
);


-- Tabla "Pagos"
CREATE TABLE PAGOS (
  id_p INT PRIMARY KEY AUTO_INCREMENT,
  id_U INT NOT NULL,
  monto DECIMAL(10,2),
  fecha_pago VARCHAR(100) NOT NULL,
  FOREIGN KEY (id_U) REFERENCES USUARIO(id_U) ON DELETE CASCADE
);

-- Insertar usuarios en la tabla USUARIO
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('Juan Perez', '11111111-1', 'Cliente');
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('María González', '22222222-2', 'Cliente');
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('Pedro Martínez', '33333333-3', 'Cliente');
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('Ana Torres', '44444444-4', 'Cliente');
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('Luis Hernández', '55555555-5', 'Cliente');
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('Sofía López', '66666666-6', 'Administrativo');
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('Fernando Díaz', '77777777-7', 'Profesional');
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('Camila Ríos', '88888888-8', 'Administrativo');
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('Roberto Silva', '99999999-9', 'Profesional');
INSERT INTO USUARIO (nombre, rut, tipo) VALUES ('Claudia Mendoza', '10101010-1', 'Cliente');

-- Insertar en la tabla CLIENTE
INSERT INTO CLIENTE (id_U, telefono, comuna) VALUES (1, '123456789', 'Santiago'); -- Juan Perez
INSERT INTO CLIENTE (id_U, telefono, comuna) VALUES (2, '987654321', 'Valparaíso'); -- María González
INSERT INTO CLIENTE (id_U, telefono, comuna) VALUES (3, '555666777', 'Concepción'); -- Pedro Martínez
INSERT INTO CLIENTE (id_U, telefono, comuna) VALUES (4, '888999000', 'La Serena'); -- Ana Torres
INSERT INTO CLIENTE (id_U, telefono, comuna) VALUES (10, '444555666', 'Temuco'); -- Claudia Mendoza
INSERT INTO CLIENTE (id_U, telefono, comuna) VALUES (5, '777888999', 'Antofagasta'); -- Luis Hernández

-- Insertar en la tabla ADMINISTRATIVO
INSERT INTO ADMINISTRATIVO (id_U, area, experiencia_previa) VALUES (6, 'Recursos Humanos', '3 años'); -- Sofía López
INSERT INTO ADMINISTRATIVO (id_U, area, experiencia_previa) VALUES (8, 'Finanzas', '5 años'); -- Camila Ríos 

-- Insertar en la tabla PROFESIONAL
INSERT INTO PROFESIONAL (id_U, titulo, fecha_ingreso) VALUES (7, 'Ingeniero Civil', '15-01-2022'); -- Fernando Díaz
INSERT INTO PROFESIONAL (id_U, titulo, fecha_ingreso) VALUES (9, 'Arquitecto', '20-05-2020'); -- Roberto Silva

-- Insertar en la tabla CAPACITACION
INSERT INTO CAPACITACION (identificador,dia, hora, lugar, duracion, cantidad_asistentes) VALUES 
(2,'Lunes', '09:00 AM', 'Sala 1', '2 horas', 25), 
(5,'Martes', '10:30 AM', 'Auditorio', '3 horas', 40), 
(1,'Miércoles', '08:00 AM', 'Sala 2', '1 hora y 30 minutos', 20), 
(8,'Jueves', '02:00 PM', 'Sala de conferencias', '4 horas', 50), 
(9,'Viernes', '03:30 PM', 'Sala 3', '2 horas y 15 minutos', 30);

-- Insertar visitas en formato día, mes, año
INSERT INTO VISITAS (id_U, fecha_visita) VALUES (1, '01-10-2024'); -- Visita de Maria Gonzalez el 1 de octubre de 2024
INSERT INTO VISITAS (id_U, fecha_visita) VALUES (2, '28-09-2024'); -- Visita de Pedro Martinez el 28 de septiembre de 2024
INSERT INTO VISITAS (id_U, fecha_visita) VALUES (3, '27-09-2024'); -- Visita de Ana Torres el 27 de septiembre de 2024
INSERT INTO VISITAS (id_U, fecha_visita) VALUES (4, '29-09-2024'); -- Visita de Luis Hernandez el 29 de septiembre de 2024
INSERT INTO VISITAS (id_U, fecha_visita) VALUES (5, '30-09-2024'); -- Visita de Claudia Ramirez el 30 de septiembre de 2024

-- Insertar en la tabla PAGOS
INSERT INTO PAGOS (id_U, monto, fecha_pago) VALUES (1, 150.000, '01-10-2024'); -- Pago de Juan Perez el 1 de octubre de 2024
INSERT INTO PAGOS (id_U, monto, fecha_pago) VALUES (2, 200.500, '28-09-2024'); -- Pago de María González el 28 de septiembre de 2024
INSERT INTO PAGOS (id_U, monto, fecha_pago) VALUES (3, 350.750, '27-09-2024'); -- Pago de Pedro Martínez el 27 de septiembre de 2024
INSERT INTO PAGOS (id_U, monto, fecha_pago) VALUES (4, 400.000, '29-09-2024'); -- Pago de Ana Torres el 29 de septiembre de 2024
INSERT INTO PAGOS (id_U, monto, fecha_pago) VALUES (5, 250.250, '30-09-2024'); -- Pago de Luis Hernández el 30 de septiembre de 2024