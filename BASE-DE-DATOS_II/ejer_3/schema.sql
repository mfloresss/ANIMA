DROP DATABASE IF EXISTS RepasoDDL;
CREATE DATABASE IF NOT EXISTS RepasoDDL;
USE RepasoDDL;

CREATE TABLE Persona(
  ci INT NOT NULL,
  nombre VARCHAR(50),
  direccion VARCHAR(50),

  PRIMARY KEY(ci)
);

CREATE TABLE Persona_Telefono(
  ci INT NOT NULL,
  telefono INT NOT NULL,
  
  PRIMARY KEY(ci, telefono),

  FOREIGN KEY (ci) REFERENCES Persona (ci) ON DELETE CASCADE
);

CREATE TABLE Mascota(
  id INT NOT NULL,
  ciDueño INT NOT NULL,
  nombre VARCHAR(50),
  añoNacimiento DATE,

  PRIMARY KEY (id),
  FOREIGN KEY (ciDueño) REFERENCES Persona (ci) ON DELETE CASCADE
);

