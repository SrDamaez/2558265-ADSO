<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';
    
if (!empty($_POST['id_facura']) && !empty($_POST['cedula_cliente']) && !empty($_POST['cedula_vendedor'])) {
    
            $id = $_POST['id_facura'];
            $cedula_c = $_POST['cedula_cliente'];
            $cedula_v = $_POST['cedula_vendedor'];

        try {
            $consulta = $base_de_datos->prepare("UPDATE facturas SET cedula_cliente = :c_c, cedula_vendedor = :c_v WHERE id_facura = :id");
            $consulta->bindParam(':id', $id);
            $consulta->bindParam(':c_c', $cedula_c);
            $consulta->bindParam(':c_v', $cedula_v);

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
