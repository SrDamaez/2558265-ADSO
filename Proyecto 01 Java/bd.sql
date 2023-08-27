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
    Precio DECIMAL(10, 2),
    CantidadStock INT
    Url_img VARCHAR(255)
);

CREATE TABLE Carrito (
    Id_Carrito INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(200),
    Descripcion TEXT,
    Precio DECIMAL(10, 2),
    CantidadStock INT
    Url_img VARCHAR(255)
);