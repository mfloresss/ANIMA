DROP DATABASE IF EXISTS NETFLIX;
CREATE DATABASE IF NOT EXISTS NETFLIX;
USE NETFLIX;

CREATE TABLE Cuenta(
	nroCuenta INT NOT NULL AUTO_INCREMENT,
    mail VARCHAR(50),
    nombre VARCHAR(50),
    
    UNIQUE(mail),
    PRIMARY KEY(nroCuenta)
);

CREATE TABLE Cuenta_Telefonos(
	nroCuenta INT NOT NULL,
    telefono INT NOT NULL,
    
    PRIMARY KEY(nroCuenta, telefono),
    FOREIGN KEY (nroCuenta) REFERENCES Cuenta(nroCuenta) ON DELETE CASCADE
);

CREATE TABLE Suscripcion(
	nroCuenta INT NOT NULL,
    monto INT NOT NULL,
    plazo DATE,
    
    PRIMARY KEY(nroCuenta),
    FOREIGN KEY (nroCuenta) REFERENCES Cuenta(nroCuenta) ON DELETE CASCADE
);

CREATE TABLE Perfil(
	nroCuenta INT NOT NULL,
    nombre VARCHAR(50),
    fotoPerfil LONGBLOB,
    reproducciones VARCHAR(50),
    historial VARCHAR(50),
    
    PRIMARY KEY(nroCuenta, nombre),
    FOREIGN KEY (nroCuenta) REFERENCES Cuenta(nroCuenta) ON DELETE CASCADE
);

CREATE TABLE Contenido(
	nroCuenta INT NOT NULL,
    id INT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(50),
    genero VARCHAR(50),
    sinopsis VARCHAR(50),
    restEdad INT NOT NULL,
    puntuacion INT NOT NULL,
    
    PRIMARY KEY(id, nroCuenta),
    FOREIGN KEY (nroCuenta) REFERENCES Perfil(nroCuenta) ON DELETE CASCADE
);

CREATE TABLE Serie(
	id INT NOT NULL,
    cantCap INT NOT NULL,
    cantTemp INT NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY (id) REFERENCES Contenido(id) ON DELETE CASCADE
);

CREATE TABLE Pelicula(
	id INT NOT NULL,
    duracion INT NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY (id) REFERENCES Contenido(id) ON DELETE CASCADE
);
