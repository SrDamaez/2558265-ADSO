<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include '../Conexion.php';

    if (!empty($_POST['id_factura']) and !empty($_POST['cedula_cliente']) and !empty($_POST['cedula_vendedor']) ) {

        $id = $_POST['id_factura'];
        $cedula_c = $_POST['cedula_cliente'];
        $cedula_v = $_POST['cedula_vendedor'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO facturas (id_factura, cedula_cliente, cedula_vendedor) VALUES(:id, :c_c, :c_v) ");

            $consulta->bindParam(':id', $id);
            $consulta->bindParam(':c_c', $cedula_c);
            $consulta->bindParam(':c_v', $cedula_v);

            
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
