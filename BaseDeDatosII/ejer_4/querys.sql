-- Actividad 04- Group by , Funciones y Subquerys
-- De la base de datos Spotic

-- Mostrar nombre  de los países de origen de las bandas que sacaron álbum luego del año 2000 (SIN repetición)
	SELECT * FROM BANDA AS B JOIN PAIS AS P ON B.CodPais = P.IdPais WHERE B.AnioCrea > 2000 GROUP BY (P.NomPais);

-- Mostar nombre del género y cantidad de bandas de cada género
	SELECT G.NomGen, COUNT(*) AS Cantidad FROM BANDA AS B JOIN GENERO AS G ON B.IdGenero = G.IdGen GROUP BY G.NomGen;

-- Mostrar nombre del álbum lanzado luego del 2003 de la banda con menos integrantes.
	SELECT * FROM BANDA AS B JOIN ALBUM AS A ON B.IdBanda = A.CodBanda WHERE A.AnioLanzamiento > 2003 AND B.CantIntegrantes < (SELECT MIN(CantIntegrantes) FROM BANDA AS B2);

-- Mostrar las edades de todos los integrantes y luego sumar todas las edades.
	SELECT SUM(A.Edad) FROM INTEGRANTE AS I JOIN ALBUM AS A ON I.CodAlbum = A.IdAlbum;

-- Insert : Alain Caron bajista Grupo musical: Uzeb (Desde 1978) jazz Nacimiento: 5 de mayo de 1955
	INSERT INTO BANDA (NomBanda, AnioCrea, CodPais, CodGenero, CantIntegrantes) VALUES ('Alain Caron bajista Grupo musical: Uzeb (Desde 1978) jazz', '1978', '1', '2', '4'); 
	

-- Luego : 
-- Con subquerys -> Nombre bajista más veterano canadiense.