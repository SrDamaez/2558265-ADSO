<<<<<<< HEAD
<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';
    
if (!empty($_POST['id_producto']) && !empty($_POST['nombre_producto']) && !empty($_POST['precio_producto'])) {
    
            $id = $_POST['id_producto'];
            $nombre = $_POST['nombre_producto'];
            $precio = $_POST['precio_producto'];

        try {
            $consulta = $base_de_datos->prepare("UPDATE productos SET nombre_producto = :nom, precio_producto = :pre WHERE id_producto = :id");
            $consulta->bindParam(':id', $id);
            $consulta->bindParam(':nom', $nombre);
            $consulta->bindParam(':pre', $precio);

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
=======
<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';
    
if (!empty($_POST['id_producto']) && !empty($_POST['nombre_producto']) && !empty($_POST['precio_producto'])) {
    
            $id = $_POST['id_producto'];
            $nombre = $_POST['nombre_producto'];
            $precio = $_POST['precio_producto'];

        try {
            $consulta = $base_de_datos->prepare("UPDATE productos SET nombre_producto = :nom, precio_producto = :pre WHERE id_producto = :id");
            $consulta->bindParam(':id', $id);
            $consulta->bindParam(':nom', $nombre);
            $consulta->bindParam(':pre', $precio);

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
>>>>>>> cf400648dd8c395f2e192896508ec9e1e47fdb15
