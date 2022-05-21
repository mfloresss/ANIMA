INSERT INTO Usuario VALUES(555, 'maradona', '1');
INSERT INTO Usuario VALUES(666, 'ronaldo', '2');
INSERT INTO Usuario VALUES(777, 'messi', '0');

INSERT INTO Partida VALUES(7, 'el diego', 30, true);
INSERT INTO Partida VALUES(9, 'filho de deus', 100, true);

INSERT INTO MailUsuario VALUES(555, 'maradona@gmial.com', 111);
INSERT INTO MailUsuario VALUES(666, 'ronaldo@gmail.com', 222);

INSERT INTO Administrador VALUES(777); 

INSERT INTO Categoria VALUES('tecnologia');

INSERT INTO Jugador VALUES(555, 'el diiego',7,2,7);
INSERT INTO Jugador VALUES(666, 'filho de deus',9,3,9);

INSERT INTO Administra VALUES(777, 011);

INSERT INTO Palabra VALUES(000, 'A', 'Conjunto de instrucciones o reglas definidas que permiten solucionar un problema', TRUE, 'ALGORITMO', TRUE, FALSE, 2, 3);
INSERT INTO Palabra VALUES(011, 'B', 'Parte logica de una aplicacion o pagina web que esta conectada con la base de datos', TRUE, 'Backend', TRUE, FALSE, 2, 5);
INSERT INTO Palabra VALUES(111, 'C', 'Lenguaje que determina el estilo de los documentos HTML', TRUE, 'CSS', TRUE, FALSE, 1, 3);
INSERT INTO Palabra VALUES(222, 'D', 'Herramienta de modelado de sistemas, que se concentra en los datos almacenados en el sistema y las relaciones entre éstos', TRUE, 'DER', TRUE, FALSE, 1, 9);
INSERT INTO Palabra VALUES(333, 'E', 'Herramienta para el modelo de datos, la cual facilita la representación de entidades de una base de datos', TRUE, 'MER', FALSE, TRUE, 4, 9);
INSERT INTO Palabra VALUES(444, 'F', 'Variable que se utiliza cuando nuestro atributo hace referencia un atributo de otra tabla"', TRUE, 'FOREIGN KEY', TRUE, FALSE, 4, 10);
INSERT INTO Palabra VALUES(555, 'G', 'Biblioteca en el paquete estándar de Java para la creación de interfaces gráficas de usuario', TRUE, 'SWING', FALSE, TRUE, 2, 10);
INSERT INTO Palabra VALUES(666, 'H', 'Lenguaje de marcado que se utiliza para la elaboracion de paginas web', TRUE, 'HTML', TRUE, FALSE, 3, 7);
INSERT INTO Palabra VALUES(777, 'I', 'Tipo de dato que permite números enteros', TRUE, 'INT', TRUE, FALSE, 1, 7);
INSERT INTO Palabra VALUES(888, 'j', 'Lenguaje de programación para paginas web', TRUE, 'JAVASCRIPT', TRUE, FALSE, 1, 9);
INSERT INTO Palabra VALUES(999, 'L', 'Editor de texto muy usado por desarrolladores', TRUE, 'VISUAL STUDIO CODE', FALSE, TRUE, 6, 9);
INSERT INTO Palabra VALUES(1010, 'M', 'Plataforma web de enseñanza interactiva accesible para todo el mundo,que se basa en la enseñanza del desarrollo web', TRUE, 'FREECODECAMP', FALSE, TRUE, 6, 1);
INSERT INTO Palabra VALUES(1111, 'N', 'Tipo de retorno que indica que algo esta vacio', TRUE, 'NULL', TRUE, FALSE, 4, 6);
INSERT INTO Palabra VALUES(1212, 'Ñ', 'Agregar/incorporar algo a otra cosa', TRUE, 'AÑADIR', FALSE, TRUE, 4, 3);
INSERT INTO Palabra VALUES(1313, 'O', 'Biblioteca multiplataforma o conjunto de herramientas de código abierto para diseño de sitios y aplicaciones web', TRUE, 'BOOSTRAP', FALSE, TRUE, 4, 3);
INSERT INTO Palabra VALUES(1414, 'P', 'Identifica de manera única cada fila de una tabla de una base de datos', TRUE, 'PRIMARY KEY', TRUE, FALSE, 7, 3);
INSERT INTO Palabra VALUES(1515, 'Q', 'Pregunta o consulta a la base de datos', TRUE, 'QUERY', TRUE, FALSE, 7, 10);
INSERT INTO Palabra VALUES(1616, 'R', 'Asociacion entre entidades', TRUE, 'RELACION', TRUE, FALSE, 1, 10);
INSERT INTO Palabra VALUES(1717, 'S', 'Comando que se utiliza en base de datos para seleccinar datos de una o mas tablas', TRUE, 'SELECT', TRUE, FALSE, 1, 10);
INSERT INTO Palabra VALUES(1818, 'T', 'Objetos de base de datos que contienen todos sus datos', TRUE, 'TABLA', TRUE, FALSE, 1, 10);
INSERT INTO Palabra VALUES(1919, 'U', 'Instruccion que devuelve un valor de una funcion', TRUE, 'RETURN', FALSE, TRUE, 1, 10);
INSERT INTO Palabra VALUES(2020, 'V', 'Etiqueta de HTML que sirve para agrupar contenidos',TRUE,'DIV',FALSE,TRUE,1,10);
INSERT INTO Palabra VALUES(2121, 'X', 'Sistema de numeración que tiene como base el número 16', TRUE, 'HEXADECIMAL', FALSE, TRUE, 1, 10);
INSERT INTO Palabra VALUES(2222, 'Y', 'Etiqueta HTML que representa el cuerpo de la pagina web', TRUE, 'BODY', FALSE, TRUE, 1, 10);
INSERT INTO Palabra VALUES(2323, 'Z', 'Proceso de organización de datos en una base de datos', TRUE, 'NORMALIZACION', FALSE, TRUE, 1, 10);

INSERT INTO Tiene VALUES(000, 7);
INSERT INTO Tiene VALUES(011, 9);

INSERT INTO Pertenece VALUES(000, 'tecnologia');
insert into Pertenece VALUES(011, 'tecnologia');
INSERT INTO Pertenece VALUES(111, 'tecnologia');
INSERT INTO Pertenece VALUES(222, 'tecnologia');
INSERT INTO Pertenece VALUES(333, 'tecnologia');
INSERT INTO Pertenece VALUES(444, 'tecnologia');
INSERT INTO Pertenece VALUES(555, 'tecnologia');
INSERT INTO Pertenece VALUES(666, 'tecnologia');
INSERT INTO Pertenece VALUES(777, 'tecnologia');
INSERT INTO Pertenece VALUES(888, 'tecnologia');
INSERT INTO Pertenece VALUES(999, 'tecnologia');
INSERT INTO Pertenece VALUES(1010, 'tecnologia');
INSERT INTO Pertenece VALUES(1111, 'tecnologia');
INSERT INTO Pertenece VALUES(1212, 'tecnologia');
INSERT INTO Pertenece VALUES(1313, 'tecnologia');
INSERT INTO Pertenece VALUES(1414, 'tecnologia');
INSERT INTO Pertenece VALUES(1515, 'tecnologia');
INSERT INTO Pertenece VALUES(1616, 'tecnologia');
INSERT INTO Pertenece VALUES(1717, 'tecnologia');
INSERT INTO Pertenece VALUES(1818, 'tecnologia');
INSERT INTO Pertenece VALUES(1919, 'tecnologia');
INSERT INTO Pertenece VALUES(2020, 'tecnologia');
INSERT INTO Pertenece VALUES(2121, 'tecnologia');
INSERT INTO Pertenece VALUES(2222, 'tecnologia');
INSERT INTO Pertenece VALUES(2323, 'tecnologia');

SELECT * FROM Usuario;
SELECT * FROM Jugador;
SELECT * FROM Palabra;
SELECT * FROM Partida;
SELECT * FROM Categoria;
SELECT * FROM Pertenece;
SELECT * FROM Administrador;
SELECT * FROM Administra;
SELECT * FROM Mailusuario;
SELECT * FROM Tiene;

SELECT MAX(puntaje) puntaje, nickname FROM Partida;
