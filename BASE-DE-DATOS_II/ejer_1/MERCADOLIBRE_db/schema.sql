DROP DATABASE IF EXISTS MERCADOLIBRE;
CREATE DATABASE IF NOT EXISTS MERCADOLIBRE;
USE MERCADOLIBRE;

CREATE TABLE Cuenta(
	id INT NOT NULL,
    nombreUsu VARCHAR(50),
    mail VARCHAR(50),
    historial VARCHAR(300),
    reputacion INT NOT NULL,
    nroVentas INT NOT NULL,
    foto LONGBLOB,
    telefono INT NOT NULL,
    
    UNIQUE(mail),
    PRIMARY KEY(id)
);

CREATE TABLE Producto(
	id INT NOT NULL,
    idCuenta INT NOT NULL,
    nombre VARCHAR(50),
    descripcion VARCHAR(300),
    precio INT NOT NULL,
    stock INT NOT NULL,
    comentario VARCHAR(300),
    imagen LONGBLOB,
    
    PRIMARY KEY(id, idCuenta),
    FOREIGN KEY (idCuenta) REFERENCES Cuenta(id)
);

CREATE TABLE COMPRA(
	idCuenta INT NOT NULL,
    idProducto INT NOT NULL,
    nroCompra INT NOT NULL,
    fechaCompra DATETIME,
    formaPago VARCHAR(50),
    
    PRIMARY KEY(idCuenta, idProducto, nroCompra),
    
    FOREIGN KEY (idCuenta) REFERENCES Cuenta(id),
    FOREIGN KEY (idProducto) REFERENCES Producto(id)
);

CREATE TABLE Vende(
	idCuenta INT NOT NULL,
    idProducto INT NOT NULL,
    nroVenta INT NOT NULL,
    fechaVenta DATETIME,
    
    PRIMARY KEY(idCuenta, idProducto, nroVenta),
    
    FOREIGN KEY (idCuenta) REFERENCES Cuenta(id),
    FOREIGN KEY (idProducto) REFERENCES Producto(id)
);
