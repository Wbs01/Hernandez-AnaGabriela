const URL = 'http://localhost:8080/odontologos/';


function reload() {
fetch(URL)
    .then(res => res.json())
    .then(data => {
        const table = document.querySelector('table');
        const rowExample = document.querySelector('.patient-row');

        data.forEach(odontologo => {
            const newRow = rowExample.cloneNode(true);

            newRow.querySelector('.id').textContent = odontologo.id;
            newRow.querySelector('.matricula').textContent = odontologo.matricula;
            newRow.querySelector('.nombre').textContent = odontologo.nombre;
            newRow.querySelector('.apellido').textContent = odontologo.apellido;

            table.appendChild(newRow);

            newRow.style.display = 'table-row';
        });
    })
    .catch(error => console.error(error));
}