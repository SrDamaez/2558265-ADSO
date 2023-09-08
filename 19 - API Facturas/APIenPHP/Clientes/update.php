<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';
    
if (!empty($_POST['cedula']) && !empty($_POST['nombres']) && !empty($_POST['apellidos']) && !empty($_POST['telefono'])) {
    
            $documento = $_POST['cedula'];
            $nombres = $_POST['nombres'];
            $apellidos = $_POST['apellidos'];
            $telefono = $_POST['telefono'];

        try {
            $consulta = $base_de_datos->prepare("UPDATE clientes SET nombres_cliente = :nom, apellidos_cliente = :ape, telefono_cliente = :tel WHERE cedula_cliente = :ced");
            $consulta->bindParam(':ced', $documento);
            $consulta->bindParam(':nom', $nombres);
            $consulta->bindParam(':ape', $apellidos);
            $consulta->bindParam(':tel', $telefono);

            $proceso = $consulta->execute();

            if ($proceso) {
                $respuesta = [
                    'status' => true,
                    'message' => "OK##CLIENT##UPDATE"
                ];
                echo json_encode($respuesta);
            } else {
                $respuesta = [
                    'status' => false,
                    'message' => "ERROR##CLIENT##UPDATE"
                ];
                echo json_encode($respuesta);
            }
        } catch (Exception $e) {
            $respuesta = [
                'status' => false,
                'message' => "ERROR##SQL",
                'exception' => $e->getMessage()
            ];
            echo json_encode($respuesta);
        }
    } else {
        $respuesta = [
            'status' => false,
            'message' => "ERROR##DATOS##POST"
        ];
        echo json_encode($respuesta);
    }
?>
