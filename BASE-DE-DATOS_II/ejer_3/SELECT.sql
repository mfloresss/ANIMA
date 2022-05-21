-- -----------------------------------------
--  Consultas sobre personas:
-- -----------------------------------------

--  Mostrar todos los datos de las personas con nombre Paulina Silva.
SELECT * FROM Persona WHERE nombreApellido = 'Paulina Silva';

--  Mostrar solo la dirección de la persona con ci 14725836.
SELECT dir_numeroPuerta, dir_calle, dir_ciudad FROM Persona WHERE nroPasaporte = 14725836;

--  Mostrar nombre y dirección de las personas con ci 96385241 o 98563214.
SELECT nombreApellido,
    dir_numeroPuerta,
    dir_calle,
    dir_ciudad
FROM Persona
WHERE nroPasaporte = 98563214
    or nroPasaporte = 96385241;

--  Mostrar nombre y dirección de las personas con ci 96385241 y 98563214.
SELECT nombreApellido,
    dir_numeroPuerta,
    dir_calle,
    dir_ciudad
FROM Persona
WHERE nroPasaporte = 98563214
UNION
SELECT nombreApellido,
    dir_numeroPuerta,
    dir_calle,
    dir_ciudad
FROM Persona
WHERE nroPasaporte = 98563214
    or nroPasaporte = 96385241;

-- -----------------------------------------
--  Consultas sobre teléfonos:
-- -----------------------------------------

--  Mostrar los teléfonos asociados a la cedula 14725836.
SELECT * FROM Persona_Telefono WHERE cedulaPersona = 14725836;

--  Mostrar la ci que tiene el teléfono 433463722
SELECT cedulaPersona FROM Persona_Telefono WHERE tel = 433463722;

-- -----------------------------------------
--  Consultas sobre mascotas:
-- -----------------------------------------

--  Mostrar todos los datos de mascotas id > 100
SELECT * FROM Mascota WHERE id > 100;

--  Mostrar solo el nombre de las mascotas con año de nacimiento menor o igual a 2013
SELECT nombre FROM Mascota WHERE añoNacimiento <= '2013';

--  Mostrar todos los datos menos el nombre de la mascota con nombre Flaffy.
SELECT * FROM Mascota WHERE nombre = 'Flaffy';

-- -----------------------------------------
--  Consultas generales: 
-- -----------------------------------------

--  Mostrar de cada persona que tenga teléfono, nombre, dirección y teléfono.
ALTER TABLE Persona_Telefono ADD FOREIGN KEY Persona_Telefono(cedulaPersona) REFERENCES Persona(nroPasaporte);

SELECT nombreApellido, 
dir_numeroPuerta, 
dir_calle, dir_ciudad 
FROM Persona 
    JOIN Persona_Telefono ON Persona.nroPasaporte = Persona_Telefono.cedulaPersona;

--  Mostrar solo el nombre de quien tenga teléfono 43347603
SELECT *
FROM Persona
    JOIN Persona_Telefono ON Persona.nroPasaporte = Persona_Telefono.cedulaPersona
WHERE Persona_Telefono.tel = 43347603;

--  Mostrar todos los teléfonos de Paulina Silva
SELECT tel
FROM Persona
    JOIN Persona_Telefono ON Persona.nroPasaporte = Persona_Telefono.cedulaPersona
WHERE Persona.nombreApellido = 'Paulina Silva';

--  Para cada mascota, mostrar la cédula, nombre y dirección de su dueño y además, nombre y año de nacimiento de la mascota.
ALTER TABLE Mascota ADD FOREIGN KEY Mascota(ciDueño) REFERENCES Persona(nroPasaporte);

SELECT Persona.ciPersona,
    Persona.nombreApellido,
    Persona.dir_numeroPuerta,
    Persona.dir_calle,
    Persona.dir_ciudad,
    Mascota.nombre,
    Mascota.añoNacimiento
FROM Persona
    JOIN Mascota ON Persona.nroPasaporte = Mascota.ciDueño;

--  Para las mascotas nacidas después de 2009, mostrar: nombre, dirección y teléfonos de su dueño y además, nombre y año de nacimiento de la mascota.
SELECT Persona.nombreApellido,
    Persona.dir_numeroPuerta,
    Persona.dir_calle,
    Persona.dir_ciudad,
    Persona_Telefono.tel,
    Mascota.nombre,
    Mascota.añoNacimiento
FROM Persona
    JOIN Mascota ON Persona.nroPasaporte = Mascota.ciDueño
    JOIN Persona_Telefono ON Persona_Telefono.cedulaPersona = Mascota.ciDueño
WHERE añoNacimiento > '2009';

--  Encontrar todas las personas que tengan teléfono.
SELECT * FROM Persona JOIN Persona_Telefono ON Persona.nroPasaporte = Persona_Telefono.cedulaPersona;

--  Hallar las personas sin teléfono.
SELECT * FROM Persona LEFT JOIN Persona_Telefono ON Persona.nroPasaporte = Persona_Telefono.cedulaPersona WHERE Persona_Telefono.tel IS NULL;


--  Encontrar todas las personas sin mascotas
SELECT *
FROM Persona
    LEFT JOIN Mascota ON Persona.nroPasaporte = Mascota.ciDueño WHERE Mascota.ciDueño IS NULL;

--  Mostrar todas las personas que tengan mascotas y teléfonos
SELECT *
FROM Persona
    JOIN Persona_Telefono ON Persona.nroPasaporte = Persona_Telefono.cedulaPersona
    JOIN Mascota ON Persona.nroPasaporte = Mascota.ciDueño;