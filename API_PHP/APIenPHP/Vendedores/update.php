<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';
    
if (!empty($_POST['cedula_v']) && !empty($_POST['nombres_v']) && !empty($_POST['apellidos_v']) && !empty($_POST['telefono_v'])) {
    
            $documento = $_POST['cedula_v'];
            $nombres = $_POST['nombres_v'];
            $apellidos = $_POST['apellidos_v'];
            $telefono = $_POST['telefono_v'];

        try {
            $consulta = $base_de_datos->prepare("UPDATE vendedores SET nombres_vendedor = :nom, apellidos_vendedor = :ape, telefono_vendedor = :tel WHERE cedula_vendedor = :ced");
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
