<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include '../Conexion.php';

    if (!empty($_POST['id_producto']) and !empty($_POST['nombre_producto']) and !empty($_POST['precio_producto']) ) {

        $id = $_POST['id_producto'];
        $nombre = $_POST['nombre_producto'];
        $precio = $_POST['precio_producto'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO productos (id_producto, nombre_producto, precio_producto) VALUES(:id, :nom, :pre) ");

            $consulta->bindParam(':id', $id);
            $consulta->bindParam(':nom', $nombre);
            $consulta->bindParam(':pre', $precio);

            
            $proceso = $consulta->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'mesagge' => "OK##CLIENT##INSERT"
                            ];
                echo json_encode($respuesta);
            }else{
                $respuesta = [
                                'status' => false,
                                'mesagge' => "ERROR##CLIENT##INSERT"
                            ];
                echo json_encode($respuesta);
            }
        } catch (Exception $e) {
            $respuesta = [
                            'status' => false,
                            'mesagge' => "ERROR##SQL",
                            'exception' => $e
                        ];
            echo json_encode($respuesta);
        }
    }else{
        $respuesta = [
                        'status' => false,
                        'mesagge' => "ERROR##DATOS##POST"
                    ];
        echo json_encode($respuesta);
    }
?>
