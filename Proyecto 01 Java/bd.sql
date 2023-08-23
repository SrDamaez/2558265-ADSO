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
);

CREATE TABLE CarritoCompras (
    Id_carrito INT PRIMARY KEY AUTO_INCREMENT,
    Id_Usuario VARCHAR(10),
    FechaCreacion DATETIME,
    FOREIGN KEY (Id_Usuario) REFERENCES Usuarios(Cedula)
);

CREATE TABLE DetalleCarrito (
    Id_Detalle INT PRIMARY KEY AUTO_INCREMENT,
    Id_Carrito INT,
    Id_Producto INT,
    Cantidad INT,
    FOREIGN KEY (Id_Carrito) REFERENCES CarritoCompras(Id_carrito),
    FOREIGN KEY (Id_Producto) REFERENCES Productos(Id_Producto)
);

CREATE TABLE Facturas (
    Id_factura INT PRIMARY KEY AUTO_INCREMENT,
    Id_Usuario VARCHAR(10),
    Id_Carrito INT,
    FechaCompra DATETIME,
    Total DECIMAL(10, 2),
    FOREIGN KEY (Id_Usuario) REFERENCES Usuarios(Cedula),
    FOREIGN KEY (Id_Carrito) REFERENCES CarritoCompras(Id_carrito)
);