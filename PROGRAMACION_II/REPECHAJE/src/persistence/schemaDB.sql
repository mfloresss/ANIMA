DROP DATABASE Repechaje_ProgII;
CREATE DATABASE Repechaje_ProgII;
USE Repechaje_ProgII;

CREATE TABLE Usuario(
	ci INT NOT NULL,
    nombre VARCHAR(20),
	apellido VARCHAR(20),
    
    PRIMARY KEY(ci)
);

CREATE TABLE Profesor(
	ci INT NOT NULL,
    matricula INT NOT NULL AUTO_INCREMENT,
    
    PRIMARY KEY(matricula),
    FOREIGN KEY(ci) REFERENCES Usuario(ci) ON DELETE CASCADE
);

CREATE TABLE Estudiante(
	ci INT NOT NULL,
    nroEstudiante INT NOT NULL AUTO_INCREMENT,
	
    PRIMARY KEY(nroEstudiante),
    FOREIGN KEY(ci) REFERENCES Usuario(ci) ON DELETE CASCADE
);

CREATE TABLE Materia(
	codigo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(20),
	
    PRIMARY KEY(codigo)
);

CREATE TABLE Tiene(
	nroEstudiante INT NOT NULL,
    codigoMateria INT NOT NULL,
	
    PRIMARY KEY(nroEstudiante, codigoMateria),
    FOREIGN KEY(nroEstudiante) REFERENCES Estudiante(nroEstudiante) ON DELETE CASCADE,
    FOREIGN KEY(codigoMateria) REFERENCES Materia(codigo) ON DELETE CASCADE
);

CREATE TABLE Dicta(
	matricula INT NOT NULL,
    codigoMateria INT NOT NULL,
	
    PRIMARY KEY(matricula, codigoMateria),
    FOREIGN KEY(matricula) REFERENCES Profesor(matricula) ON DELETE CASCADE,
    FOREIGN KEY(codigoMateria) REFERENCES Materia(codigo) ON DELETE CASCADE
);