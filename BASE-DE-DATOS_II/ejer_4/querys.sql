-- Actividad 04- Group by , Funciones y Subquerys
-- De la base de datos Spotic

-- Mostrar nombre  de los países de origen de las bandas que sacaron álbum luego del año 2000 (SIN repetición)
	SELECT * FROM BANDA AS B JOIN PAIS AS P ON B.CodPais = P.IdPais WHERE B.AnioCrea > 2000 GROUP BY (P.NomPais);

-- Mostar nombre del género y cantidad de bandas de cada género
	SELECT G.NomGen, COUNT(*) AS Cantidad FROM BANDA AS B JOIN GENERO AS G ON B.IdGenero = IdGen GROUP BY G.NomGen;

-- Mostrar nombre del álbum lanzado luego del 2003 de la banda con menos integrantes.
    SELECT B.NombreBanda, B.CantInt, A.Titulo as "Titulo Album", A.Anio as "Año" FROM ALBUM AS A NATURAL JOIN BANDA AS B WHERE A.Anio < 2003 AND CantInt = (SELECT MIN(CantInt) FROM BANDA);
    
-- Mostrar las edades de todos los integrantes y luego sumar todas las edades.
	-- SELECT PriNom, PriApe, SUM(2022 - FechaNac) FROM INTEGRANTE;
    -- SELECT *,  2022 - YEAR(FechaNac) AS edad from INTEGRANTE;
    SELECT *,  YEAR(curdate()) - YEAR(FechaNac) AS edad from INTEGRANTE;

-- Insert : Alain Caron bajista Grupo musical: Uzeb (Desde 1978) jazz Nacimiento: 5 de mayo de 1955
	-- INSERT INTO INTEGRANTE (CodIntegrante, PriNom, PriApe, CodPais, FechaNac) VALUES (213, "Alain", "Caron", "USA", "1955-05-05");
	-- INSERT INTO INTEGRA (CodIntegrante, CodBanda, IdRol, Fdesde, Fhasta) VALUES (213, );

-- Luego : 
-- Con subquerys -> Nombre bajista más veterano canadiense.