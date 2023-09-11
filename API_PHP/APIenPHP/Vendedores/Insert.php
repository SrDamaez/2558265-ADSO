<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include '../Conexion.php';

    if (!empty($_POST['cedula_vendedor']) and !empty($_POST['nombres_vendedor']) and !empty($_POST['apellidos_vendedor']) ) {

        $documento = $_POST['cedula_vendedor'];
        $nombres = $_POST['nombres_vendedor'];
        $apellidos = $_POST['apellidos_vendedor'];
        $telefono = $_POST['telefono_vendedor'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO vendedores (cedula_vendedor, nombres_vendedor, apellidos_vendedor, telefono_vendedor) VALUES(:doc, :nom, :ape, :tel) ");

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
