let contentClientes = null;
let listaPersonas = null;
let formInsertarUsuario = null;
let formEditarUsuario = null;
let modalCrearUsuario = null;
let modalEditarUsuario = null;

window.onload = function(){
    contentClientes = document.getElementById("contentClientes");
    formInsertarUsuario = document.getElementById("formInsertarUsuario");
    formEditarUsuario = document.getElementById("formEditarUsuario");

    formInsertarUsuario.addEventListener("submit",function(event){
        event.preventDefault();
        crearPersona();
    });

    formEditarUsuario.addEventListener("submit", function(event) {
        event.preventDefault();
    });

    modalCrearUsuario = new bootstrap.Modal(document.getElementById('modalCrearUsuario'), {
        keyboard: false,
        backdrop: false
    })

    modalEditarUsuario = new bootstrap.Modal(document.getElementById('modalEditarUsuario'), {
        keyboard: false,
        backdrop: false
    })
    
    getClients("http://localhost/API_PHP/APIenPHP/Obtener.php");

}

function getClients(endpoint){
    fetch( endpoint)
    .then( respuesta => respuesta.json())
    .then( data => {
        console.log("se recibe");
        console.log(data);
        
        listaPersonas = data.registros;
        contentClientes.innerHTML = "";
        for(let i = 0; i < data.registros.length; i ++){
            temp=   `
                        <tr>
                            <td>${data.registros[i].cedula}</td>
                            <td>${data.registros[i].nombres}</td>
                            <td>${data.registros[i].apellidos}</td>
                            <td>${data.registros[i].telefono}</td>
                            <td>${data.registros[i].direccion}</td>
                            <td>${data.registros[i].email}</td>
                            <td>
                                <button class = "btn btn-primary" onclick = "abrirModalEditar(${i})">Editar</button>
                            </td>
                            <td>
                                <button class = "btn btn-danger" onclick = "confirmarEliminacion(${i})">Eliminar</button>
                            </td>
                        </tr>
                    `;
            contentClientes.innerHTML += temp;
        }

    });
}

function abrirModalEditar(indice) {
    document.getElementById('campo_editar_cedula').value = listaPersonas[indice].cedula;
    document.getElementById('campo_editar_nombres').value = listaPersonas[indice].nombres;
    document.getElementById('campo_editar_apellidos').value = listaPersonas[indice].apellidos;
    document.getElementById('campo_editar_telefono').value = listaPersonas[indice].telefono;
    document.getElementById('campo_editar_direccion').value = listaPersonas[indice].direccion;
    document.getElementById('campo_editar_email').value = listaPersonas[indice].email;

    modalEditarUsuario.show();

    document.getElementById('formEditarUsuario').onsubmit = function (event) {

        let insertarDatos = new FormData(formEditarUsuario);
        let configurar = {
            method: "POST",
            headers: {
                "Accept": "application/json"
            },
            body: insertarDatos,
        }

        fetch("http://localhost/API_PHP/APIenPHP/update.php", configurar)
            .then(respuesta => respuesta.json())
            .then(data => {
            if (data.status) {
                formEditarUsuario.reset();
                modalEditarUsuario.hide();

                Swal.fire({
                    title: 'ÉXITO',
                    icon: 'success',
                    html: 'Actualizado con éxito',
                    confirmButtonText:'ENTENDIDO'
                })

                getClients("http://localhost/API_PHP/APIenPHP/Obtener.php");
            } else {
                Swal.fire({
                    title: 'ERROR',
                    icon: 'error',
                    html: 'Se presentó un error, quizá la cédula está repetida',
                    confirmButtonText: 'ENTENDIDO'
                })
            }
        });
    };
}


function confirmarEliminacion(indice) {
    console.log("Eliminar para: ");
    console.log(listaPersonas[indice].cedula);

    Swal.fire({
        title: 'ESTAS SEGURO?',
        text: 'Eliminar datos para la cedula: ' + listaPersonas[indice].cedula,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'SI, Eliminar!',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            eliminarRegistro(listaPersonas[indice].cedula);
        }
    });
}

function eliminarRegistro(cedula) {
    // Crea un objeto FormData para enviar la cédula al servidor
    let datos = new FormData();
    datos.append('cedula', cedula);

    fetch('http://localhost/API_PHP/APIenPHP/delete.php', {
        method: 'POST',
        body: datos
    })
    .then(response => response.json())
    .then(data => {
        if (data.status) {
            // Éxito al eliminar
            Swal.fire(
                'ELIMINADO!',
                'El registro ha sido eliminado.',
                'success'
            );
            getClients("http://localhost/API_PHP/APIenPHP/Obtener.php");
        } else {
            // Error al eliminar
            Swal.fire(
                'ERROR',
                'No se pudo eliminar el registro.',
                'error'
            );
        }
    })
    .catch(error => {
        console.error('Error:', error);
        Swal.fire(
            'ERROR',
            'Ocurrió un error al procesar la solicitud.',
            'error'
        );
    });
}


function crearPersona(){
    console.log("aca hacemos el codigo para consumir la api de insert");
    let datos = new FormData(formInsertarUsuario);
    let configuracion = {
                            method: "POST",
                            headers: {
                                "Accept": "application/json"
                            },                            
                            body: datos,
                        }
    
    fetch("http://localhost/API_PHP/APIenPHP/Insert.php",configuracion)
    .then(respuesta => respuesta.json())
    .then(data => {
        if(data.status){
            formInsertarUsuario.reset();
            modalCrearUsuario.hide();

            Swal.fire({
                title: 'EXITO',
                icon: 'success',
                html: 'Registro creado con exito',
                confirmButtonText:'ENTENDIDO'
            })

            getClients("http://localhost/API_PHP/APIenPHP/Obtener.php");
        } else{
            Swal.fire({
                title: 'ERROR',
                icon: 'error',
                html: 'se presento un error, quiza la cedula esta repetida',
                confirmButtonText:'ENTENDIDO'
            })
        }
    });
}


