<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';
    
if (!empty($_POST['cedula_c']) && !empty($_POST['nombres_c']) && !empty($_POST['apellidos_c']) && !empty($_POST['telefono_c'])) {
    
            $documento = $_POST['cedula_c'];
            $nombres = $_POST['nombres_c'];
            $apellidos = $_POST['apellidos_c'];
            $telefono = $_POST['telefono_c'];

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
