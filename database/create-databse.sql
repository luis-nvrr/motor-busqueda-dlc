CREATE DATABASE `motor-busqueda-dlc`;
USE `motor-busqueda-dlc`;

CREATE TABLE Terminos(
    termino VARCHAR(100),
    cantidadDocumentos INTEGER,
    maximaFrecuenciaTermino INTEGER,
    CONSTRAINT pk_terminos PRIMARY KEY Terminos(termino)
);

CREATE TABLE Documentos(
    nombre VARCHAR(20),
    frecuenciaTermino INTEGER,
    link VARCHAR(200),
    termino VARCHAR(100),
    CONSTRAINT pk_documentos PRIMARY KEY Documentos(nombre, termino),
    CONSTRAINT fk_documentos_terminos FOREIGN KEY (termino) REFERENCES Terminos(termino)
);
