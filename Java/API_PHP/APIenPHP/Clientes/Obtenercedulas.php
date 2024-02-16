<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';

    $consulta = $base_de_datos->query("SELECT cedula_cliente FROM clientes");
    $datos = $consulta->fetchAll(PDO::FETCH_COLUMN);

    $respuesta['cedulas'] = $datos;
    echo json_encode($respuesta);
?>

