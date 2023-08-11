CREATE TABLE Usuarios (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    CorreoElectronico VARCHAR(255) UNIQUE,
    Contrasena VARCHAR(255),
    Rol VARCHAR(20)
);

CREATE TABLE Productos (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(200),
    Descripcion TEXT,
    Precio DECIMAL(10, 2),
    CantidadStock INT
);

CREATE TABLE CarritoCompras (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    IDUsuario INT,
    FechaCreacion DATETIME,
    FOREIGN KEY (IDUsuario) REFERENCES Usuarios(ID)
);

CREATE TABLE DetalleCarrito (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    IDCarrito INT,
    IDProducto INT,
    Cantidad INT,
    FOREIGN KEY (IDCarrito) REFERENCES CarritoCompras(ID),
    FOREIGN KEY (IDProducto) REFERENCES Productos(ID)
);

CREATE TABLE Facturas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    IDUsuario INT,
    IDCarrito INT,
    FechaCompra DATETIME,
    Total DECIMAL(10, 2),
    FOREIGN KEY (IDUsuario) REFERENCES Usuarios(ID),
    FOREIGN KEY (IDCarrito) REFERENCES CarritoCompras(ID)
);
