USE `motor-busqueda-dlc`;

CREATE TABLE Terminos(
    termino VARCHAR(100) NOT NULL,
    cantidadDocumentos INTEGER,
    maximaFrecuenciaTermino INTEGER,
    CONSTRAINT pk_terminos PRIMARY KEY Terminos(termino)
);

CREATE TABLE Documentos(
    path VARCHAR(200) NOT NULL,
    frecuenciaTermino INTEGER,
    link VARCHAR(200),
    CONSTRAINT pk_documentos PRIMARY KEY Documentos(path)
);

CREATE TABLE Posteos(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    termino VARCHAR(100),
    documento VARCHAR(200),
    CONSTRAINT fk_posteos_terminos FOREIGN KEY (termino) REFERENCES Terminos(termino),
    CONSTRAINT fk_posteos_documentos FOREIGN KEY (documento) REFERENCES Documentos(path)
);