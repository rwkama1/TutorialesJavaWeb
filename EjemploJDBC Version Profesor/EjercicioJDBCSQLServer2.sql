USE master;

GO

IF EXISTS (SELECT * FROM sysdatabases WHERE name = 'EjercicioJDBC')
BEGIN
	DROP DATABASE EjercicioJDBC;
END

GO

CREATE DATABASE EjercicioJDBC;

GO

USE EjercicioJDBC;

GO

CREATE TABLE Personas (
    Cedula BIGINT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Edad INT NOT NULL,
    Casado BIT NOT NULL,
    Sueldo FLOAT NOT NULL);

GO

INSERT INTO Personas
VALUES (1, 'José Pérez', 25, 1, 1000);

INSERT INTO Personas
VALUES (2, 'Ana Fernández', 32, 0, 2000);

INSERT INTO Personas
VALUES (3, 'Pedro Rodríguez', 45, 1, 2500);

GO

CREATE PROCEDURE EliminarPersona
@cedula BIGINT
AS
BEGIN
	DELETE Personas
	WHERE Cedula = @cedula;
END

GO
