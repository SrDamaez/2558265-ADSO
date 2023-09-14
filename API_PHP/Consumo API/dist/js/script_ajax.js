let contentClientes = null;
let listaPersonas = null;
let listaProductos = null;
let listaFacturas = null;
let formInsertarCliente = null;
let formEditarCliente = null;
let formInsertarVendedor = null;
let formEditarVendedor = null;
let formEditarProducto = null;
let modalCrearCliente = null;
let modalEditarCliente = null;
let modalCrearVendedor = null;
let modalEditarVendedor = null;
let modalCrearProducto = null;
let modalEditarProducto = null;
let modalCrearFactura = null;
let modalEditarFactura = null;


window.onload = function(){
    contentClientes = document.getElementById("contentClientes");
    formInsertarCliente = document.getElementById("formInsertarCliente");
    formEditarCliente = document.getElementById("formEditarCliente");
    ver_clientes = document.getElementById("ver_clientes");

    formInsertarVendedor = document.getElementById("formInsertarVendedor");
    formEditarVendedor = document.getElementById("formEditarVendedor");
    ver_vendedores = document.getElementById("ver_vendedores");

    formInsertarProducto = document.getElementById("formInsertarProducto");
    formEditarProducto = document.getElementById("formEditarProducto");

    formInsertarFactura = document.getElementById("formInsertarFactura");
    formEditarFactura = document.getElementById("formEditarFactura");



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

    formInsertarProducto.addEventListener("submit",function(event){
        event.preventDefault();
        crearProducto();
    });

    formEditarProducto.addEventListener("submit", function(event) {
        event.preventDefault();
    });

    formInsertarFactura.addEventListener("submit",function(event){
        event.preventDefault();
        crearFactura();
    });

    formEditarFactura.addEventListener("submit", function(event) {
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

    modalCrearProducto = new bootstrap.Modal(document.getElementById('modalCrearProducto'), {
        keyboard: false,
        backdrop: false
    })

    modalEditarProducto = new bootstrap.Modal(document.getElementById('modalEditarProducto'), {
        keyboard: false,
        backdrop: false
    })

    modalCrearFactura = new bootstrap.Modal(document.getElementById('modalCrearFactura'), {
        keyboard: false,
        backdrop: false
    })

    modalEditarFactura = new bootstrap.Modal(document.getElementById('modalEditarFactura'), {
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

    getClientesCedulas("http://localhost/API_PHP/APIenPHP/Clientes/ObtenerCedulas.php");
    getVendedoresCedulas("http://localhost/API_PHP/APIenPHP/Vendedores/ObtenerCedulas.php");
    getVendedores("http://localhost/API_PHP/APIenPHP/Vendedores/Obtener.php");
    getProductos("http://localhost/API_PHP/APIenPHP/Productos/Obtener.php");
    getFacturas("http://localhost/API_PHP/APIenPHP/Facturas/Obtener.php");

}

function getClientesCedulas(endpoint) {
    fetch(endpoint)
        .then(respuesta => respuesta.json())
        .then(data => {
            const selectCedulaCliente = document.getElementById("campo_cedula_cliente");

            // Limpia el contenido actual del select
            selectCedulaCliente.innerHTML = "";

            // Agrega una opción por cada cédula de cliente obtenida
            data.cedulas.forEach(cedula => {
                const option = document.createElement("option");
                option.value = cedula;
                option.textContent = cedula;
                selectCedulaCliente.appendChild(option);
            });
        });
}

function getVendedoresCedulas(endpoint) {
    fetch(endpoint)
        .then(respuesta => respuesta.json())
        .then(data => {
            const selectCedulaVendedor = document.getElementById("campo_cedula_vendedor");

            // Limpia el contenido actual del select
            selectCedulaVendedor.innerHTML = "";

            // Agrega una opción por cada cédula de vendedor obtenida
            data.cedulas.forEach(cedula => {
                const option = document.createElement("option");
                option.value = cedula;
                option.textContent = cedula;
                selectCedulaVendedor.appendChild(option);
            });
        });
}

function getClients(endpoint){
    fetch( endpoint)
    .then( respuesta => respuesta.json())
    .then( data => {
        console.log("se recibe");
        
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
                                <button class = "btn btn-success col m-1" onclick = "abrirModalEditarCliente(${i})">Editar</button>
                                <button class = "btn btn-danger col m-1" onclick = "confirmarEliminacionCliente(${i})">Eliminar</button>
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
                                <button class = "btn btn-success col m-1" onclick = "abrirModalEditarVendedor(${i})">Editar</button>
                                <button class = "btn btn-danger col m-1" onclick = "confirmarEliminacionVendedor(${i})">Eliminar</button>
                            </td>
                        </tr>
                    `;
            contentClientes.innerHTML += temp;
        }
    });
}

function getProductos(endpoint){
    fetch( endpoint)
    .then( respuesta => respuesta.json())
    .then( data => {
        console.log("se recibe");
        console.log(data);
        listaProductos = data.registros;
        contentProductos.innerHTML = "";
        for(let i = 0; i < data.registros.length; i ++){
            temp=   `
                        <tr>
                            <td>${data.registros[i].id_producto}</td>
                            <td>${data.registros[i].nombre_producto}</td>
                            <td>${data.registros[i].precio_producto}</td>
                            <td>
                                <button class = "btn btn-success col m-1" onclick = "abrirModalEditarProducto(${i})">Editar</button>
                                <button class = "btn btn-danger col m-1" onclick = "confirmarEliminacionProducto(${i})">Eliminar</button>
                            </td>
                        </tr>
                    `;
            contentProductos.innerHTML += temp;
        }
    });
}

function getFacturas(endpoint){
    fetch( endpoint)
    .then( respuesta => respuesta.json())
    .then( data => {
        console.log("se recibe");
        console.log(data);
        listaFacturas = data.registros;
        contentFacturas.innerHTML = "";
        for(let i = 0; i < data.registros.length; i ++){
            temp=   `
                        <tr>
                            <td>${data.registros[i].id_factura}</td>
                            <td>${data.registros[i].cedula_cliente}</td>
                            <td>${data.registros[i].cedula_vendedor}</td>
                            <td>
                                <button class = "btn btn-success col m-1" onclick = "abrirModalEditarFactura(${i})">Editar</button>
                                <button class = "btn btn-danger col m-1" onclick = "confirmarEliminacionFactura(${i})">Eliminar</button>
                            </td>
                        </tr>
                    `;
            contentFacturas.innerHTML += temp;
        }
    });
}

function abrirModalEditarCliente(indice) {
    document.getElementById('campo_editar_cedula_c').value = listaPersonas[indice].cedula_cliente;
    document.getElementById('campo_editar_nombres_c').value = listaPersonas[indice].nombres_cliente;
    document.getElementById('campo_editar_apellidos_c').value = listaPersonas[indice].apellidos_cliente;
    document.getElementById('campo_editar_telefono_c').value = listaPersonas[indice].telefono_cliente;

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
    document.getElementById('campo_editar_cedula_v').value = listaPersonas[indice].cedula_vendedor;
    document.getElementById('campo_editar_nombres_v').value = listaPersonas[indice].nombres_vendedor;
    document.getElementById('campo_editar_apellidos_v').value = listaPersonas[indice].apellidos_vendedor;
    document.getElementById('campo_editar_telefono_v').value = listaPersonas[indice].telefono_vendedor;

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

        fetch("http://localhost/API_PHP/APIenPHP/Vendedores/update.php", configurar)
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

                getVendedores("http://localhost/API_PHP/APIenPHP/Vendedores/Obtener.php");
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

function abrirModalEditarProducto(indice) {
    document.getElementById('campo_editar_id_producto').value = listaProductos[indice].id_producto;
    document.getElementById('campo_editar_nombre_producto').value = listaProductos[indice].nombre_producto;
    document.getElementById('campo_editar_precio_producto').value = listaProductos[indice].precio_producto;

    modalEditarProducto.show();

    formEditarProducto.onsubmit = function (event) {
        
        let insertarDatos = new FormData(formEditarProducto);
        let configurar = {
            method: "POST",
            headers: {
                "Accept": "application/json"
            },
            body: insertarDatos,
        }

        fetch("http://localhost/API_PHP/APIenPHP/Productos/update.php", configurar)
            .then(respuesta => respuesta.json())
            .then(data => {
            if (data.status) {
                formEditarProducto.reset();
                modalEditarProducto.hide();

                Swal.fire({
                    title: 'ÉXITO',
                    icon: 'success',
                    html: 'Actualizado con éxito',
                    confirmButtonText:'ENTENDIDO'
                })

                getProductos("http://localhost/API_PHP/APIenPHP/Productos/Obtener.php");
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

function abrirModalEditarFactura(indice) {
    document.getElementById('campo_editar_id_factura').value = listaFacturas[indice].id_producto;
    document.getElementById('campo_editar_cedula_cliente').value = listaFacturas[indice].cedula_cliente;
    document.getElementById('campo_editar_cedula_vendedor').value = listaFacturas[indice].cedula_vendedor;

    modalEditarFactura.show();

    formEditarFactura.onsubmit = function (event) {
        
        let insertarDatos = new FormData(formEditarFactura);
        let configurar = {
            method: "POST",
            headers: {
                "Accept": "application/json"
            },
            body: insertarDatos,
        }

        fetch("http://localhost/API_PHP/APIenPHP/Facturas/update.php", configurar)
            .then(respuesta => respuesta.json())
            .then(data => {
            if (data.status) {
                formEditarProducto.reset();
                modalEditarProducto.hide();

                Swal.fire({
                    title: 'ÉXITO',
                    icon: 'success',
                    html: 'Actualizado con éxito',
                    confirmButtonText:'ENTENDIDO'
                })

                getFacturas("http://localhost/API_PHP/APIenPHP/Facturas/Obtener.php");
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
        cancelButtonColor: '#d33',
        confirmButtonColor: '#3085d6',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'SI, Eliminar!'
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
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'SI, Eliminar!'
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
            getVendedores("http://localhost/API_PHP/APIenPHP/Vendedores/Obtener.php");
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

function confirmarEliminacionProducto(indice) {
    console.log("Eliminar para: ");
    console.log(listaProductos[indice].id_producto);

    Swal.fire({
        title: 'ESTAS SEGURO?',
        text: 'Eliminar datos para el id: ' + listaProductos[indice].id_producto,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'SI, Eliminar!'
    }).then((result) => {
        if (result.isConfirmed) {
            eliminarRegistroProducto(listaProductos[indice].id_producto);
        }
    });
}

function eliminarRegistroProducto(id_producto) {
    // Crea un objeto FormData para enviar la cédula al servidor
    let datos = new FormData();
    datos.append('id_producto', id_producto);

    fetch('http://localhost/API_PHP/APIenPHP/Productos/delete.php', {
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
            getProductos("http://localhost/API_PHP/APIenPHP/Productos/Obtener.php");
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

            getVendedores("http://localhost/API_PHP/APIenPHP/Vendedores/Obtener.php");
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

function crearProducto(){
    console.log("aca hacemos el codigo para consumir la api de insert");
    let datos = new FormData(formInsertarProducto);
    let configuracion = {
                            method: "POST",
                            headers: {
                                "Accept": "application/json"
                            },                            
                            body: datos,
                        }
    
    fetch("http://localhost/API_PHP/APIenPHP/Productos/Insert.php",configuracion)
    .then(respuesta => respuesta.json())
    .then(data => {
        if(data.status){
            formInsertarProducto.reset();
            modalCrearProducto.hide();

            Swal.fire({
                title: 'EXITO',
                icon: 'success',
                html: 'Registro creado con exito',
                confirmButtonText:'ENTENDIDO'
            })

            getProductos("http://localhost/API_PHP/APIenPHP/Productos/Obtener.php");
        } else{
            Swal.fire({
                title: 'ERROR',
                icon: 'error',
                html: 'se presento un error, quiza el id esté repetido',
                confirmButtonText:'ENTENDIDO'
            })
        }
    });
}

function crearFactura(){
    console.log("aca hacemos el codigo para consumir la api de insert");
    let datos = new FormData(formInsertarFactura);
    let configuracion = {
                            method: "POST",
                            headers: {
                                "Accept": "application/json"
                            },                            
                            body: datos,
                        }
    
    fetch("http://localhost/API_PHP/APIenPHP/Facturas/Insert.php",configuracion)
    .then(respuesta => respuesta.json())
    .then(data => {
        if(data.status){
            formInsertarFactura.reset();
            modalCrearFactura.hide();

            Swal.fire({
                title: 'EXITO',
                icon: 'success',
                html: 'Registro creado con exito',
                confirmButtonText:'ENTENDIDO'
            })

            getFacturas("http://localhost/API_PHP/APIenPHP/Facturas/Obtener.php");
        } else{
            Swal.fire({
                title: 'ERROR',
                icon: 'error',
                html: 'se presento un error, quiza el id esté repetido',
                confirmButtonText:'ENTENDIDO'
            })
        }
    });
}