<?php 
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';

    if (!empty($_POST['cedula'])) {
        $cedula = $_POST['cedula'];

        $consulta = $base_de_datos->prepare("DELETE FROM clientes WHERE cedula_cliente = :ced");
        $consulta->bindParam(':ced', $cedula);

        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'message' => "ELIMINAR##OK"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'message' => "ERROR##SQL"
            ];
            echo json_encode($respuesta);
        }
    } else {
        $respuesta = [
            'status' => false,
            'message' => "ELIMINAR##DATOS##POST"
        ];
        echo json_encode($respuesta);
    }
?>
