let contentClientes = null;
let listaPersonas = null;
let formInsertarUsuario = null;
let formEditarUsuario = null;
let modalCrearUsuario = null;
let modalEditarUsuario = null;

window.onload = function(){
    contentClientes = document.getElementById("contentClientes");
    formInsertarCliente = document.getElementById("formInsertarCliente");
    formInsertarVendedor = document.getElementById("formInsertarVendedor");
    formEditarCliente = document.getElementById("formEditarCliente");
    formEditarVendedor = document.getElementById("formEditarVendedor");
    ver_clientes = document.getElementById("ver_clientes");
    ver_vendedores = document.getElementById("ver_vendedores");



    formInsertarCliente.addEventListener("submit",function(event){
        event.preventDefault();
        crearCliente();
    });

    formEditarCliente.addEventListener("submit", function(event) {
        event.preventDefault();
    });

    formInsertarVendedor.addEventListener("submit",function(event){
        event.preventDefault();
        crearVendedor();
    });

    formEditarVendedor.addEventListener("submit", function(event) {
        event.preventDefault();
    });

    modalCrearCliente = new bootstrap.Modal(document.getElementById('modalCrearCliente'), {
        keyboard: false,
        backdrop: false
    })

    modalEditarCliente = new bootstrap.Modal(document.getElementById('modalEditarCliente'), {
        keyboard: false,
        backdrop: false
    })

    modalCrearVendedor = new bootstrap.Modal(document.getElementById('modalCrearVendedor'), {
        keyboard: false,
        backdrop: false
    })

    modalEditarVendedor = new bootstrap.Modal(document.getElementById('modalEditarVendedor'), {
        keyboard: false,
        backdrop: false
    })
    
    ver_clientes.addEventListener("click", function(event) {
        event.preventDefault();
        getClients("http://localhost/API_PHP/APIenPHP/Clientes/Obtener.php");
    });

    ver_vendedores.addEventListener("click", function(event) {
        event.preventDefault();
        getVendedores("http://localhost/API_PHP/APIenPHP/Vendedores/Obtener.php");
    });

    //getClients("http://localhost/API_PHP/APIenPHP/Clientes/Obtener.php");

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
                            <td>${data.registros[i].cedula_cliente}</td>
                            <td>${data.registros[i].nombres_cliente}</td>
                            <td>${data.registros[i].apellidos_cliente}</td>
                            <td>${data.registros[i].telefono_cliente}</td>
                            <td>
                                <button class = "btn btn-success col-3 m-1" onclick = "abrirModalEditarCliente(${i})">Editar</button>
                                <button class = "btn btn-danger col-3 m-1" onclick = "confirmarEliminacionCliente(${i})">Eliminar</button>
                            </td>
                        </tr>
                    `;
            contentClientes.innerHTML += temp;
        }

    });

    
}

function getVendedores(endpoint){
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
                            <td>${data.registros[i].cedula_vendedor}</td>
                            <td>${data.registros[i].nombres_vendedor}</td>
                            <td>${data.registros[i].apellidos_vendedor}</td>
                            <td>${data.registros[i].telefono_vendedor}</td>
                            <td>
                                <button class = "btn btn-success col-3 m-1" onclick = "abrirModalEditarVendedor(${i})">Editar</button>
                                <button class = "btn btn-danger col-3 m-1" onclick = "confirmarEliminacionVendedor(${i})">Eliminar</button>
                            </td>
                        </tr>
                    `;
            contentClientes.innerHTML += temp;
        }
    });
}

function abrirModalEditarCliente(indice) {
    document.getElementById('campo_editar_cedula').value = listaPersonas[indice].cedula_cliente;
    document.getElementById('campo_editar_nombres').value = listaPersonas[indice].nombres_cliente;
    document.getElementById('campo_editar_apellidos').value = listaPersonas[indice].apellidos_cliente;
    document.getElementById('campo_editar_telefono').value = listaPersonas[indice].telefono_cliente;

    modalEditarCliente.show();

    document.getElementById('formEditarCliente').onsubmit = function (event) {

        let insertarDatos = new FormData(formEditarCliente);
        let configurar = {
            method: "POST",
            headers: {
                "Accept": "application/json"
            },
            body: insertarDatos,
        }

        fetch("http://localhost/API_PHP/APIenPHP/Clientes/update.php", configurar)
        .then(respuesta => respuesta.json())
        .then(data => {
            console.log(data);
            if (data.status) {

                formEditarCliente.reset();
                modalEditarCliente.hide();

                Swal.fire({
                    title: 'ÉXITO',
                    icon: 'success',
                    html: 'Actualizado con éxito',
                    confirmButtonText:'ENTENDIDO'
                })
                getClients("http://localhost/API_PHP/APIenPHP/Clientes/Obtener.php");
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

function abrirModalEditarVendedor(indice) {
    document.getElementById('campo_editar_cedula').value = listaPersonas[indice].cedula_vendedor;
    document.getElementById('campo_editar_nombres').value = listaPersonas[indice].nombres_vendedor;
    document.getElementById('campo_editar_apellidos').value = listaPersonas[indice].apellidos_vendedor;
    document.getElementById('campo_editar_telefono').value = listaPersonas[indice].telefono_vendedor;

    modalEditarVendedor.show();

    document.getElementById('formEditarVendedor').onsubmit = function (event) {

        let insertarDatos = new FormData(formEditarVendedor);
        let configurar = {
            method: "POST",
            headers: {
                "Accept": "application/json"
            },
            body: insertarDatos,
        }

        fetch("http://localhost/API_PHP/APIenPHP/Vendedors/update.php", configurar)
            .then(respuesta => respuesta.json())
            .then(data => {
            if (data.status) {
                formEditarVendedor.reset();
                modalEditarVendedor.hide();

                Swal.fire({
                    title: 'ÉXITO',
                    icon: 'success',
                    html: 'Actualizado con éxito',
                    confirmButtonText:'ENTENDIDO'
                })

                getVendedores("http://localhost/API_PHP/APIenPHP/Vendedor/Obtener.php");
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


function confirmarEliminacionCliente(indice) {
    console.log("Eliminar para: ");
    console.log(listaPersonas[indice].cedula_cliente);

    Swal.fire({
        title: 'ESTAS SEGURO?',
        text: 'Eliminar datos para la cedula: ' + listaPersonas[indice].cedula_cliente,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'SI, Eliminar!',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            eliminarRegistroCliente(listaPersonas[indice].cedula_cliente);
        }
    });
}

function eliminarRegistroCliente(cedula) {
    // Crea un objeto FormData para enviar la cédula al servidor
    let datos = new FormData();
    datos.append('cedula', cedula);

    fetch('http://localhost/API_PHP/APIenPHP/Clientes/delete.php', {
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
            getClients("http://localhost/API_PHP/APIenPHP/Clientes/Obtener.php");
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

function confirmarEliminacionVendedor(indice) {
    console.log("Eliminar para: ");
    console.log(listaPersonas[indice].cedula_vendedor);

    Swal.fire({
        title: 'ESTAS SEGURO?',
        text: 'Eliminar datos para la cedula: ' + listaPersonas[indice].cedula_vendedor,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'SI, Eliminar!',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            eliminarRegistroVendedor(listaPersonas[indice].cedula_vendedor);
        }
    });
}

function eliminarRegistroVendedor(cedula) {
    // Crea un objeto FormData para enviar la cédula al servidor
    let datos = new FormData();
    datos.append('cedula', cedula);

    fetch('http://localhost/API_PHP/APIenPHP/Vendedores/delete.php', {
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
            getClients("http://localhost/API_PHP/APIenPHP/Vendedores/Obtener.php");
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


function crearVendedor(){
    console.log("aca hacemos el codigo para consumir la api de insert");
    let datos = new FormData(formInsertarVendedor);
    let configuracion = {
                            method: "POST",
                            headers: {
                                "Accept": "application/json"
                            },                            
                            body: datos,
                        }
    
    fetch("http://localhost/API_PHP/APIenPHP/Vendedores/Insert.php",configuracion)
    .then(respuesta => respuesta.json())
    .then(data => {
        if(data.status){
            formInsertarVendedor.reset();
            modalCrearVendedor.hide();

            Swal.fire({
                title: 'EXITO',
                icon: 'success',
                html: 'Registro creado con exito',
                confirmButtonText:'ENTENDIDO'
            })

            getClients("http://localhost/API_PHP/APIenPHP/Vendedores/Obtener.php");
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

function crearCliente(){
    console.log("aca hacemos el codigo para consumir la api de insert");
    let datos = new FormData(formInsertarCliente);
    let configuracion = {
                            method: "POST",
                            headers: {
                                "Accept": "application/json"
                            },                            
                            body: datos,
                        }
    
    fetch("http://localhost/API_PHP/APIenPHP/Clientes/Insert.php",configuracion)
    .then(respuesta => respuesta.json())
    .then(data => {
        if(data.status){
            formInsertarCliente.reset();
            modalCrearCliente.hide();

            Swal.fire({
                title: 'EXITO',
                icon: 'success',
                html: 'Registro creado con exito',
                confirmButtonText:'ENTENDIDO'
            })

            getClients("http://localhost/API_PHP/APIenPHP/Clientes/Obtener.php");
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