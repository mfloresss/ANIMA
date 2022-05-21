DROP DATABASE Infinity;
CREATE DATABASE Infinity;
USE Infinity;

-- ENTIDADES

CREATE TABLE Usuario (
	id INT NOT NULL,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    mail VARCHAR(50),
    pin INT NOT NULL,
    
    PRIMARY KEY(id)
);

CREATE TABLE Jugador (
	id INT NOT NULL,
	nickname VARCHAR(50),
    
    UNIQUE(nickname),
    PRIMARY KEY(id),
    FOREIGN KEY(id) REFERENCES Usuario(id)
);

CREATE TABLE Administrador (
	id INT NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY(id) REFERENCES Usuario(id)
);

CREATE TABLE Partida (
	id INT NOT NULL,
    idJugador INT NOT NULL,
    puntaje INT NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY(idJugador) REFERENCES Jugador(id)
);

CREATE TABLE Palabra (
	id INT NOT NULL,
    letra CHAR,
    palabra VARCHAR(50),
    definicion VARCHAR(500),
    contiene BOOLEAN,
    categoria  VARCHAR(50),
    cantUsada INT NOT NULL,
    cantVecesCorrecta INT NOT NULL,
    
    PRIMARY KEY(id)
);

-- RELACIONES

CREATE TABLE Maneja (
	idAdm INT NOT NULL,
	idPalabra INT NOT NULL,
    fecha DATE,
    
    PRIMARY KEY(idAdm, idPalabra),
    FOREIGN KEY(idAdm) REFERENCES Administrador(id),
    FOREIGN KEY(idPalabra) REFERENCES Palabra(id)
 );
 
 CREATE TABLE Usa (
	idPartida INT NOT NULL,
	idPalabra INT NOT NULL,
    
    PRIMARY KEY(idPartida, idPalabra),
    FOREIGN KEY(idPartida) REFERENCES Partida(id),
    FOREIGN KEY(idPalabra) REFERENCES Palabra(id)
 );
