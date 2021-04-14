DROP DATABASE IF EXISTS EjemploJDBC;

CREATE DATABASE EjemploJDBC;

USE EjemploJDBC;

CREATE TABLE Empleados (
	Cedula BIGINT PRIMARY KEY,
	Nombre VARCHAR(50) NOT NULL,
	Edad INT,
	Sueldo DOUBLE,
	Casado BIT
);

CREATE TABLE Telefonos (
	IdTel INT AUTO_INCREMENT,
	NroTel VARCHAR(10) UNIQUE,
	Empleado BIGINT,
	PRIMARY KEY (IdTel),
	FOREIGN KEY (Empleado) REFERENCES Empleados (Cedula)
);


INSERT INTO Empleados
VALUES (1, 'Juan', NULL, 1000, 0);

INSERT INTO Empleados
VALUES (2, 'Andrea', 32, 1200, NULL);

INSERT INTO Empleados
VALUES (3, 'Pablo', 56, NULL, 1);


INSERT INTO Telefonos
VALUES (NULL, '11111111', 1);

INSERT INTO Telefonos
VALUES (NULL, '22222221', 2);

INSERT INTO Telefonos
VALUES (NULL, '22222222', 2);


CREATE PROCEDURE ListarTodos()
	SELECT *
	FROM Empleados;

/*CALL ListarTodos();*/

CREATE PROCEDURE MayoresDe(IN pEdad INT)
	SELECT *
	FROM Empleados
	WHERE Edad > pEdad;

/*CALL MayoresDe(50);*/

/*SHOW PROCEDURE STATUS WHERE Db = 'ejemplojdbc';*/

/*SHOW CREATE PROCEDURE MayoresDe;*/

/*DROP PROCEDURE MayoresDe;*/

DELIMITER //

CREATE PROCEDURE EliminarEmpleado(pCedula BIGINT)
BEGIN
	DELETE
	FROM Telefonos
	WHERE Empleado = pCedula;
	
	DELETE
	FROM Empleados
	WHERE Cedula = pCedula;
END//

DELIMITER ;

/*CALL EliminarEmpleado(1);

CALL ListarTodos();*/

CREATE PROCEDURE ObtenerMayorSueldo(OUT pMayor DOUBLE)
	SELECT MAX(Sueldo) FROM Empleados INTO pMayor;

/*SET @mayorSueldo = 0;

CALL ObtenerMayorSueldo(@mayorSueldo);

SELECT @mayorSueldo;*/

CREATE PROCEDURE PruebaIO(INOUT valor INT)
	SET valor = valor + 1;

/*SET @valor = 10;

CALL PruebaIO(@valor);

SELECT @valor;*/

DELIMITER //

CREATE FUNCTION Buscar(pCedula BIGINT) RETURNS VARCHAR(50)
BEGIN
	DECLARE vNombre VARCHAR(50);
	
	SELECT Nombre
	FROM Empleados
	WHERE Cedula = pCedula
	INTO vNombre;
	
	RETURN vNombre;
END//

DELIMITER ;

/*SHOW FUNCTION STATUS WHERE Db = 'ejemplojdbc';*/

/*SET @nombre = Buscar(1);

SELECT @nombre;*/

DROP PROCEDURE IF EXISTS EliminarEmpleado;

DELIMITER //

CREATE PROCEDURE EliminarEmpleado(pCedula BIGINT, OUT pError VARCHAR(50))
cuerpo:BEGIN
    DECLARE mensajeError VARCHAR(50);
    DECLARE transaccionActiva BIT;
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION # También existe el CONTINUE HANDLER que continúa la ejecución del procedimiento.
	BEGIN
		IF transaccionActiva THEN
			ROLLBACK;
        END IF;
		
		SET pError = mensajeError;
	END;
    
	IF NOT EXISTS(
		SELECT *
        FROM Empleados
        WHERE Cedula = pCedula) THEN
			SET pError = 'El empleado no existe.';
            
			LEAVE cuerpo;
	END IF;
    
    SET transaccionActiva = 1;
    
	START TRANSACTION; # No se permite utilizar transacciones en las funciones, sólo en los procedimientos.
	
	SET mensajeError = 'No se pudo eliminar los teléfonos del empleado';
	
    # SIGNAL SQLSTATE '10000' SET MESSAGE_TEXT = 'Error de prueba.';
    
	DELETE
	FROM Telefonos
	WHERE Empleado = pCedula;
	
	SET mensajeError = 'No se pudo eliminar el empleado.';
    
    # SIGNAL SQLSTATE '10000' SET MESSAGE_TEXT = 'Error de prueba.';
	
	DELETE
	FROM Empleados
	WHERE Cedula = pCedula;
	
	COMMIT;
    
    SET transaccionActiva = 0;
END//

DELIMITER ;
