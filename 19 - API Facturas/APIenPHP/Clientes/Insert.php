<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include '../Conexion.php';

    if (!empty($_POST['cedula_cliente']) and !empty($_POST['nombres_cliente']) and !empty($_POST['apellidos_cliente']) ) {

        $documento = $_POST['cedula_cliente'];
        $nombres = $_POST['nombres_cliente'];
        $apellidos = $_POST['apellidos_cliente'];
        $telefono = $_POST['telefono_cliente'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO clientes (cedula_cliente, nombres_cliente, apellidos_cliente, telefono_cliente) VALUES(:doc, :nom, :ape, :tel) ");

            $consulta->bindParam(':doc', $documento);
            $consulta->bindParam(':nom', $nombres);
            $consulta->bindParam(':ape', $apellidos);
            $consulta->bindParam(':tel', $telefono);

            
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
