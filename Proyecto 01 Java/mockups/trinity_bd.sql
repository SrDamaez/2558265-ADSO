CREATE DATABASE IF NOT EXISTS trinity_bd;
USE trinity_bd;

CREATE TABLE Usuarios (
    Cedula VARCHAR(10) PRIMARY KEY,
    Nombre VARCHAR(100),
    Contrasena VARCHAR(255),
    Rol VARCHAR(20)
);

CREATE TABLE Productos (
    Id_Producto INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(200),
    Descripcion TEXT,
    Precio VARCHAR(10),
    CantidadStock VARCHAR(11),
    Url_img VARCHAR(255)
);

CREATE TABLE Carrito (
    Id_Carrito INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(200),
    Descripcion TEXT,
    Precio VARCHAR(10),
    CantidadStock VARCHAR(11),
    Url_img VARCHAR(255)
);

INSERT INTO Productos (Nombre, Descripcion, Precio, CantidadStock, Url_img)
VALUES ('Mause', 'Mause Bonito', 150000, 20, 'mause.png');

INSERT INTO Productos (Nombre, Descripcion, Precio, CantidadStock, Url_img)
VALUES ('Teclao', 'Teclao Más Bonito', 200000, 30, 'teclado.png');

INSERT INTO Productos (Nombre, Descripcion, Precio, CantidadStock, Url_img)
VALUES ('Logo Z', 'Logo Zelda :D', 10000, 5, 'zelda.png');

INSERT INTO Productos (Nombre, Descripcion, Precio, CantidadStock, Url_img)
VALUES ('Logo T', 'Logo Trinidad Zelda', 5000, 3, 'zelda2.png');

