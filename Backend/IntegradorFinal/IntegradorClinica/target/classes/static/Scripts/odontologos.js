const URL = 'http://localhost:8080/odontologos/';


function reload() {
fetch(URL)
    .then(res => res.json())
    .then(data => {
        const table = document.querySelector('table');
        const rowExample = document.querySelector('.patient-row');

        // Itera a través de los pacientes y agrega una fila para cada uno
        data.forEach(odontologo => {
            const newRow = rowExample.cloneNode(true); // Clona la fila de ejemplo

            // Llena las celdas con los datos del paciente
            newRow.querySelector('.id').textContent = odontologo.id;
            newRow.querySelector('.matricula').textContent = odontologo.matricula;
            newRow.querySelector('.nombre').textContent = odontologo.nombre;
            newRow.querySelector('.apellido').textContent = odontologo.apellido;

            // Muestra la fila agregada en la tabla
            table.appendChild(newRow);

            // Muestra la fila clonada estableciendo su estilo "display" en "table-row"
            newRow.style.display = 'table-row';
        });
    })
    .catch(error => console.error(error));
}