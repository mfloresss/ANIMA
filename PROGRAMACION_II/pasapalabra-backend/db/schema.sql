-- DROP DATABASE pasapalabra;
CREATE DATABASE pasapalabra;
USE pasapalabra;

CREATE TABLE Usuario(
	ci INT NOT NULL,
	nombre VARCHAR(30),
	apellido VARCHAR(30),
    
	PRIMARY KEY(ci)
 );
 
CREATE TABLE Jugador(
	ci INT NOT NULL,
	nickname VARCHAR(30),
	partidasJugadas INT NOT NULL,
	partidasGanadas INT NOT NULL,
    
    	UNIQUE(nickname),
	PRIMARY KEY(ci),
	FOREIGN KEY(ci) REFERENCES Usuario(ci)
 );
 
CREATE TABLE Administrador(
	ci INT NOT NULL,
    
	PRIMARY KEY(ci),
	FOREIGN KEY(ci) REFERENCES Usuario(ci)
 );
 
 CREATE TABLE Palabra(
	 codigo INT NOT NULL,
	 letra CHAR,
	 definicion VARCHAR(30),
   	 estado BOOLEAN,
	 palabra VARCHAR(30),
	 empiezaPorLetra BOOLEAN,
	 contieneLetra BOOLEAN,
	 cantidadRespondida INT NOT NULL,
	 cantidadRespondidaCorrectas INT NOT NULL,
	 
	 PRIMARY KEY(codigo)
 );
 
 CREATE TABLE Partida(
	 codigoPartida INT NOT NULL,
	 nickname VARCHAR(30),
	 puntaje INT NOT NULL,
	 finalizada BOOLEAN,
	 
	 UNIQUE(nickname),
	 PRIMARY KEY(codigoPartida)
 );
 
 CREATE TABLE Categoria(
	nombre VARCHAR(30),

	PRIMARY KEY (nombre)
 );
 
CREATE TABLE Tiene (
	codigoPalabra INT NOT NULL,
	codigoPartida INT NOT NULL,
    
	PRIMARY KEY(codigoPalabra, codigoPartida)
);

CREATE TABLE Pertenece (
	codigoPalabra INT NOT NULL,
	nombre VARCHAR(50),
    
	PRIMARY KEY(codigoPalabra)
);

CREATE TABLE Administra (
	ci INT NOT NULL,
	codigoPalabra INT NOT NULL,
    
	PRIMARY KEY(ci, codigoPalabra),
  	FOREIGN KEY(ci) REFERENCES Administrador(ci)
);

CREATE TABLE Compite (
	ci INT NOT NULL,
	nickname VARCHAR(40),
	player1 VARCHAR(30),
	player2 VARCHAR(30),
    
	PRIMARY KEY(ci, nickname, player1, player2)
);
 
 CREATE TABLE MailUsuario (
	ci INT NOT NULL,
	mail VARCHAR(30),
	pin INT NOT NULL,
	
	UNIQUE (pin),
    	PRIMARY KEY(ci),
	FOREIGN KEY MailUsuario(ci) REFERENCES Usuario(ci)
  );
  
ALTER TABLE Jugador ADD codigoPartida INT NOT NULL;

ALTER TABLE Jugador ADD FOREIGN KEY(codigoPartida) REFERENCES Partida(codigoPartida);  

ALTER TABLE Tiene ADD FOREIGN KEY(codigoPartida) REFERENCES Partida(codigoPartida);

ALTER TABLE Palabra MODIFY definicion VARCHAR(500);

ALTER TABLE Tiene ADD FOREIGN KEY(codigoPalabra) REFERENCES Palabra(codigo);

DROP TABLE Compite;
