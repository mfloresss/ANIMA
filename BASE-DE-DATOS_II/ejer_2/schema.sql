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

-- -----------------------------------------
-- Renombrar los atributos de persona:
-- -----------------------------------------

-- Nombre por nombre&apellido
	ALTER TABLE Persona CHANGE nombre nombreApellido VARCHAR(50);

-- ci por cedulaPersona
	ALTER TABLE Persona CHANGE ci ciPersona INT NOT NULL;

-- La dirección de una persona tiene que pasar a ser un atributo compuesto por numero puerta, calle y ciudad.
	ALTER TABLE Persona DROP direccion;
	ALTER TABLE Persona ADD dir_numeroPuerta INT NOT NULL;
	ALTER TABLE Persona ADD dir_calle VARCHAR(100);
	ALTER TABLE Persona ADD dir_ciuidad VARCHAR(50);

-- Renombrar los atributos de teléfono:

-- Ci por cedulaPersona
	ALTER TABLE Persona_Telefono CHANGE ci cedulaPersona INT NOT NULL;

-- Telefono por tel
	ALTER TABLE Persona_Telefono CHANGE telefono tel INT NOT NULL;

-- -----------------------------------------
-- Insertar columnas a mascota:
-- -----------------------------------------

-- Raza
	ALTER TABLE Mascota ADD raza VARCHAR(50);
	
-- Fecha ultima vacuna
	ALTER TABLE Mascota ADD ultimaVacuna DATE;
	
-- Color de pelo
	ALTER TABLE Mascota ADD colorPelo VARCHAR(50);

-- Detalle de enfermedad
	ALTER TABLE Mascota ADD detalleEnfermedad VARCHAR(100);
    
-- Si tuvo cría
	ALTER TABLE Mascota ADD tieneCrias BOOLEAN;

-- -----------------------------------------

 -- Eliminar la primary key de persona
	ALTER TABLE Persona_Telefono DROP FOREIGN KEY Persona_Telefono_ibfk_1;
	ALTER TABLE Mascota DROP FOREIGN KEY Mascota_ibfk_1;
	ALTER TABLE Persona DROP PRIMARY KEY;
	
-- Insertar una nueva PK en persona, será el número de pasaporte.
	ALTER TABLE Persona ADD nroPasaporte INT NOT NULL;
	ALTER TABLE Persona ADD PRIMARY KEY (nroPasaporte);

-- -----------------------------------------
-- 		Eliminar columnas en mascota
-- -----------------------------------------

-- Color de pelo
	ALTER TABLE Mascota DROP colorPelo;

-- Detalle de enfermedad
	ALTER TABLE Mascota DROP detalleEnfermedad;

-- Si tuvo cría
	ALTER TABLE Mascota DROP tieneCrias;
    
--   DESCRIBE Persona;
--   DESCRIBE Persona_Telefono;
--   DESCRIBE Mascota;
--   SHOW CREATE TABLE Persona;
--   SHOW CREATE TABLE Persona_Telefono;
--   SHOW CREATE TABLE Mascota;
