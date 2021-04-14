DROP DATABASE IF EXISTS EjercicioJSPYBeans;

CREATE DATABASE EjercicioJSPYBeans;

USE EjercicioJSPYBeans;

CREATE TABLE Mensajes (
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Mensaje VARCHAR(256));

INSERT INTO Mensajes
VALUES (NULL, 'No soy un completo inútil. Por lo menos sirvo de mal ejemplo.');

INSERT INTO Mensajes
VALUES (NULL, 'Lo importante no es saber, sino tener el teléfono del que sabe.');

INSERT INTO Mensajes
VALUES (NULL, 'Tener la conciencia limpia es síntoma de mala memoria.');

INSERT INTO Mensajes
VALUES (NULL, 'Errar es humano, pero echarle la culpa a otro es mas humano todavía.');

INSERT INTO Mensajes
VALUES (NULL, 'No te tomes la vida en serio, al fin y al cabo no saldrás vivo de ella.');
