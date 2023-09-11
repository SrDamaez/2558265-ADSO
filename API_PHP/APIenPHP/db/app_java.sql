-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-09-2023 a las 14:19:33
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `app_java`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE clientes(
cedula_cliente INT UNSIGNED PRIMARY KEY,
nombres_cliente VARCHAR(25),
apellidos_cliente VARCHAR(25),
telefono_cliente VARCHAR(25)
);


CREATE TABLE vendedores(
cedula_vendedor INT UNSIGNED PRIMARY KEY,
nombres_vendedor VARCHAR(25),
apellido_vendedor VARCHAR(25),
telefono_vendedor VARCHAR(25)
);

CREATE TABLE productos(
id_producto INT UNSIGNED PRIMARY KEY,
nombre_producto VARCHAR(25),
precio_producto FLOAT(30)
);

CREATE TABLE facturas(
id_factura INT UNSIGNED PRIMARY KEY,
cedula_cliente INT UNSIGNED,
cedula_vendedor INT UNSIGNED,
FOREIGN KEY(cedula_cliente) REFERENCES clientes(cedula_cliente),
FOREIGN KEY(cedula_vendedor) REFERENCES vendedores(cedula_vendedor)
);

CREATE TABLE items_factura(
id_items INT UNSIGNED PRIMARY KEY,
id_factura INT UNSIGNED,
id_producto INT UNSIGNED,
FOREIGN KEY(id_factura) REFERENCES facturas(id_factura),
FOREIGN KEY(id_producto) REFERENCES productos(id_producto)
);


INSERT INTO clientes (cedula_cliente, nombres_cliente, apellidos_cliente, telefono_cliente)
VALUES
    (1001, 'Juan', 'Perez', '1234'),
    (1002, 'María', 'López', '5678'),
    (1003, 'Carlos', 'González', '9012');

-- Insertar ejemplos en la tabla vendedores
INSERT INTO vendedores (cedula_vendedor, nombres_vendedor, apellidos_vendedor, telefono_vendedor)
VALUES
    (1111, 'Ana', 'Martínez', '1111'),
    (2222, 'Luis', 'Rodríguez', '2222'),
    (3333, 'Elena', 'Sánchez', '3333');

-- Insertar ejemplos en la tabla productos
    INSERT INTO productos (id_producto, nombre_producto, precio_producto)
    VALUES
        (1001, 'Coca-Cola', 3500),
        (1002, 'Pepsi', 2000),
        (1003, 'Papitas Limon', 2300);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `personas`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
