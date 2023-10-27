let nombrePersona = null;
let trRes = null;

window.onload = function () {
    trRes = document.getElementById("trRes");

    cargarPersonas("http://localhost:8080/consumoPersona")
}

function cargarPersonas(endpoint) {
    trRes.innerHTML = "";
    fetch(endpoint)
    .then(respuesta => respuesta.json())
    .then(data => {
        console.log(data);
        data.forEach(element => {
            temp = `<tr>
                        <td>${element.nombre}</td>
                        <td>${element.apellido}</td>
                        <td>${element.edad}</td>
                        <td>${element.direccion}</td>
                        <td>${element.telefono}</td>
                        <td>${element.correo_electronico}</td>
                    </tr>`
            trRes.innerHTML += temp;
        });
    })
}