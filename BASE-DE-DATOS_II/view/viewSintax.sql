-- Sintax of create view

-- view: es una tabla intermediaria entre la padre que contiene consultas 
-- pre cargadas para que no le este pegando directamente a la tabla padre. Nos sirven para proteger los datos y mejorar el rendimient de la base

-- NO puede tener el mismo nombre que la tabla padre

CREATE VIEW vistaRcok AS
SELECT NombreBanda,
    NomPais
FROM BANDA,
    GENERO,
    PAIS
WHERE NomGen = "Rock"
    AND IdGen = IdGenero
    AND CodPais = IdPais;

CREATE VIEW vistaBaterista AS
SELECT concat(PriNom," ",PriApe) as "Nombre Completo"
FROM INTEGRANTE
    NATURAL JOIN INTEGRA
    NATURAL JOIN ROL
WHERE NomRol = "Baterista";

SELECT * FROM vistaBaterista;

DROP VIEW vistaBaterista;