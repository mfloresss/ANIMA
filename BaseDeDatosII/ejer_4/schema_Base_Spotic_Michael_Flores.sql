drop database if exists spotic;
create database spotic;
use spotic;

CREATE TABLE PAIS(
  IdPais char(3) NOT NULL,
  NomPais varchar(20) NOT NULL,

  CONSTRAINT PK_CPais PRIMARY KEY(IdPais)
);

CREATE TABLE GENERO(
  IdGen char(2) NOT NULL,
  NomGen varchar(20) NOT NULL,

  CONSTRAINT PK_CGen PRIMARY KEY(IdGen)
);

CREATE TABLE ROL(
  IdRol int(2) NOT NULL,
  NomRol varchar(20) NOT NULL,

  CONSTRAINT PK_CRol PRIMARY KEY(IdRol)
);

CREATE TABLE BANDA(
  CodBanda int(3) NOT NULL,
  NombreBanda varchar(25) NOT NULL,
  IdGenero char(2) NOT NULL,
  CodPais char(3) NOT NULL,
  CantInt int(2) NOT NULL,
  AnioCrea int(4) NOT NULL,

  CONSTRAINT PK_Cbanda PRIMARY KEY(CodBanda),

  CONSTRAINT FK_BandaGen FOREIGN KEY(IdGenero) REFERENCES GENERO(IdGen),
  CONSTRAINT FK_BandaPais FOREIGN KEY(CodPais) REFERENCES PAIS(IdPais)
);

CREATE TABLE ALBUM(
  CodAlb int(3) NOT NULL,
  Titulo varchar(25) NOT NULL,
  Anio int(4) NOT NULL,
  CodBanda int(3) NOT NULL,

  CONSTRAINT PK_CAlb PRIMARY KEY(CodAlb),

  CONSTRAINT FK_AlbBanda FOREIGN KEY(CodBanda) REFERENCES BANDA(CodBanda)
);

CREATE TABLE INTEGRANTE(
  CodIntegrante int(4) NOT NULL,
  PriNom varchar(10) NOT NULL,
  PriApe varchar(10) NOT NULL,
  CodPais char(3) NOT NULL,
  FechaNac date NOT NULL,
  
  CONSTRAINT PK_CInter PRIMARY KEY(CodIntegrante),
  
  CONSTRAINT FK_IntPais FOREIGN KEY(CodPais) REFERENCES PAIS(IdPais)
);

CREATE TABLE INTEGRA(
  CodIntegrante int(4) NOT NULL,
  CodBanda int(3) NOT NULL,
  IdRol int(2) NOT NULL,
  Fdesde date NOT NULL,
  Fhasta date,
  
  CONSTRAINT PK_Integra PRIMARY KEY(CodIntegrante, CodBanda, IdRol),
  
  CONSTRAINT FK_InteInte FOREIGN KEY(CodIntegrante) REFERENCES INTEGRANTE(CodIntegrante),
  CONSTRAINT FK_InteBanda FOREIGN KEY(CodBanda) REFERENCES BANDA(CodBanda),
  CONSTRAINT FK_InteRol FOREIGN KEY(IdRol) REFERENCES ROL(IdRol)
);

INSERT INTO PAIS(IdPais, NomPais) VALUES('USA', 'ESTADOS UNIDOS');
INSERT INTO PAIS(IdPais, NomPais) VALUES('CRS', 'COREA DEL SUR');
INSERT INTO PAIS(IdPais, NomPais) VALUES('ING', 'INGLATERRA');
INSERT INTO PAIS(IdPais, NomPais) VALUES('ALE', 'ALEMANIA');
INSERT INTO PAIS(IdPais, NomPais) VALUES('RUM', 'RUMANIA');
INSERT INTO PAIS(IdPais, NomPais) VALUES('CAN', 'CANADA');

INSERT INTO GENERO(IdGen, NomGen) VALUES('RK', 'ROCK');
INSERT INTO GENERO(IdGen, NomGen) VALUES('MI', 'METAL INDUSTRIAL');
INSERT INTO GENERO(IdGen, NomGen) VALUES('PM', 'POWER METAL');
INSERT INTO GENERO(IdGen, NomGen) VALUES('KP', 'K-POP');
INSERT INTO GENERO(IdGen, NomGen) VALUES('HH', 'HIP HOP');

INSERT INTO ROL(IdRol, NomRol) VALUES (1, 'BATERISTA');
INSERT INTO ROL(IdRol, NomRol) VALUES (2, 'CANTANTE');
INSERT INTO ROL(IdRol, NomRol) VALUES (3, 'GUITARRISTA');
INSERT INTO ROL(IdRol, NomRol) VALUES (4, 'BAJISTA');
INSERT INTO ROL(IdRol, NomRol) VALUES (5, 'TECLADISTA');

INSERT INTO BANDA(CodBanda, NombreBanda, IdGenero, CodPais, CantInt, AnioCrea) VALUES (132, 'THE WHO', 'RK', 'ING', 4, 1962);
INSERT INTO BANDA(CodBanda, NombreBanda, IdGenero, CodPais, CantInt, AnioCrea) VALUES (287, 'THE ROLLING STONES', 'RK', 'ING', 5, 1962);
INSERT INTO BANDA(CodBanda, NombreBanda, IdGenero, CodPais, CantInt, AnioCrea) VALUES (366, 'RAMMSTEIN', 'MI', 'ALE', 6, 1994);
INSERT INTO BANDA(CodBanda, NombreBanda, IdGenero, CodPais, CantInt, AnioCrea) VALUES (71, 'BTS', 'KP', 'CRS', 7, 2013);
INSERT INTO BANDA(CodBanda, NombreBanda, IdGenero, CodPais, CantInt, AnioCrea) VALUES (102, 'THREE DAYS GRACE', 'RK', 'CAN', 4, 1997);
INSERT INTO BANDA(CodBanda, NombreBanda, IdGenero, CodPais, CantInt, AnioCrea) VALUES (95, 'CYPRESS HILL', 'HH', 'USA', 4, 1986);

INSERT INTO ALBUM(CodAlb, Titulo, Anio, CodBanda) VALUES (100, 'COOL 4 SKOOL', 2013, 71);
INSERT INTO ALBUM(CodAlb, Titulo, Anio, CodBanda) VALUES (102, 'BLACK SUNDAY', 1993, 95);
INSERT INTO ALBUM(CodAlb, Titulo, Anio, CodBanda) VALUES (105, 'QUADROPHENIA', 1973, 132);
INSERT INTO ALBUM(CodAlb, Titulo, Anio, CodBanda) VALUES (114, 'VOODOO LOUNGE', 1994, 287);
INSERT INTO ALBUM(CodAlb, Titulo, Anio, CodBanda) VALUES (115, 'MUTTER', 2001, 366);
INSERT INTO ALBUM(CodAlb, Titulo, Anio, CodBanda) VALUES (116, 'REISE REISE', 2004, 366);
INSERT INTO ALBUM(CodAlb, Titulo, Anio, CodBanda) VALUES (120, 'OUTSIDER', 2018, 102);

INSERT INTO INTEGRANTE(CodIntegrante, PriNom, PriApe, CodPais, FechaNac) VALUES (4565, 'MATT', 'WALST', 'CAN', '1982-12-28');
INSERT INTO INTEGRANTE(CodIntegrante, PriNom, PriApe, CodPais, FechaNac) VALUES (5321, 'BARRY', 'STOCK', 'CAN', '1974-04-24');
INSERT INTO INTEGRANTE(CodIntegrante, PriNom, PriApe, CodPais, FechaNac) VALUES (6512, 'BRAD', 'WALST', 'CAN', '1977-02-16');
INSERT INTO INTEGRANTE(CodIntegrante, PriNom, PriApe, CodPais, FechaNac) VALUES (7545, 'NEIL', 'SANDERSON', 'CAN', '1978-12-17');

INSERT INTO INTEGRA(CodIntegrante, CodBanda, IdRol, Fdesde, Fhasta) VALUES (4565, 102, 2, '1997-05-09', NULL);
INSERT INTO INTEGRA(CodIntegrante, CodBanda, IdRol, Fdesde, Fhasta) VALUES (5321, 102, 3, '1997-05-09', NULL);
INSERT INTO INTEGRA(CodIntegrante, CodBanda, IdRol, Fdesde, Fhasta) VALUES (6512, 102, 4, '1997-05-09', NULL);
INSERT INTO INTEGRA(CodIntegrante, CodBanda, IdRol, Fdesde, Fhasta) VALUES (7545, 102, 1, '1997-05-09', NULL);

SELECT
  INTEGRANTE.PriNom AS Nombre,
  INTEGRANTE.PriApe AS Apellido
FROM INTEGRA
JOIN INTEGRANTE ON INTEGRA.CodIntegrante = INTEGRANTE.CodIntegrante
JOIN ROL ON INTEGRA.IdRol = ROL.IdRol
WHERE
  ROL.NomRol = 'BAJISTA';

SELECT
  PriNom AS NOMBRE,
  PriApe AS APELLIDO
FROM INTEGRANTE
WHERE
  CodPais = 'CAN';

SELECT
  NomPais
FROM BANDA
right JOIN PAIS ON BANDA.codPais = PAIS.IdPais
WHERE
  CodBanda IS NULL;

SELECT
  NombreBanda
FROM BANDA
JOIN PAIS ON BANDA.codPais = PAIS.IdPais
WHERE
  PAIS.IdPais = 'ING'
  OR PAIS.IdPais = 'ALE'
  OR PAIS.IdPais = 'RUM';

SELECT
  nombreBanda,
  nomPais
FROM BANDA
JOIN PAIS ON BANDA.codPais = PAIS.IdPais
JOIN ALBUM ON ALBUM.codBanda = BANDA.CodBanda
WHERE
  ALBUM.anio < 2002;

SELECT
  NombreBanda
FROM BANDA
JOIN GENERO ON BANDA.IdGenero = GENERO.IdGen
WHERE
  GENERO.NomGen = 'METAL INDUSTRIAL';

CREATE TABLE PREMIO(
    idPremio INT NOT NULL,
    nombre VARCHAR(50),
    UNIQUE(nombre),

    PRIMARY KEY (idPremio)
  );

CREATE TABLE TienePremio(
    idPremio INT NOT NULL,
    codAlb INT NOT NULL,

    PRIMARY KEY (idPremio, codAlb),

    FOREIGN KEY(idPremio) REFERENCES PREMIO(idPremio),
    FOREIGN KEY(codAlb) REFERENCES ALBUM(CodAlb)
  );

INSERT INTO PREMIO(idPremio, nombre) VALUES(123, 'Grammy');
INSERT INTO PREMIO(idPremio, nombre) VALUES(124, 'BillBoard Music Award');

INSERT INTO TienePremio(idPremio, codAlb) VALUES(124, 114);
INSERT INTO TienePremio(idPremio, codAlb) VALUES(123, 114);

SELECT
  ALBUM.Titulo,
  PREMIO.nombre AS PREMIO
FROM ALBUM
JOIN TienePremio ON ALBUM.CodAlb = TienePremio.codAlb
JOIN PREMIO ON PREMIO.idPremio = TienePremio.idPremio;