DROP DATABASE IF EXISTS EjercicioJDBC;

CREATE DATABASE EjercicioJDBC;

USE EjercicioJDBC;

CREATE TABLE Personas (
    Cedula BIGINT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Edad INT NOT NULL,
    Casado BIT NOT NULL,
    Sueldo FLOAT NOT NULL);

INSERT INTO Personas
VALUES (1, 'José Pérez', 25, 1, 1000);

INSERT INTO Personas
VALUES (2, 'Ana Fernández', 32, 0, 2000);

INSERT INTO Personas
VALUES (3, 'Pedro Rodríguez', 45, 1, 2500);

DELIMITER //

CREATE PROCEDURE EliminarPersona(pCedula BIGINT)
BEGIN
	DELETE
    FROM Personas
    WHERE Cedula = pCedula;
END//

DELIMITER ;
