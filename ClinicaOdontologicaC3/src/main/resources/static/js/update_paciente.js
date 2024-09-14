function findBy(id) {
	const url = `/paciente/buscar/${id}`;
	const settings = {
		method: 'GET',
	};
	fetch(url, settings)
		.then((response) => response.json())
		.then((data) => {
			let paciente = data;
			console.log(paciente);
			document.querySelector('#id').value = paciente.id;
			document.querySelector('#nombre').value = paciente.nombre.toUpperCase();
			document.querySelector('#apellido').value = paciente.apellido.toUpperCase();
			document.querySelector('#cedula').value = paciente.cedula;
			document.querySelector('#fechaIngreso').value = paciente.fechaIngreso.toUpperCase();
			document.querySelector('#calle').value = paciente.domicilio.calle.toUpperCase();
			document.querySelector('#numero').value = paciente.domicilio.numero;
			document.querySelector('#localidad').value = paciente.domicilio.localidad;
			document.querySelector('#provincia').value = paciente.domicilio.provincia;
			document.querySelector('#email').value = paciente.email.toUpperCase();
			//el formulario por default esta oculto y al editar se habilita
		})
		.catch((error) => {
			alert('Error: ' + error);
		});
}

function updatePaciente(event) {
	event.preventDefault();
	const formData = {
		id: document.querySelector('#id').value,
		nombre: document.querySelector('#nombre').value,
		apellido: document.querySelector('#apellido').value,
		cedula: document.querySelector('#cedula').value,
		fechaIngreso: document.querySelector('#fechaIngreso').value,
		domicilio: {
			calle: document.querySelector('#calle').value,
			numero: document.querySelector('#numero').value,
			localidad: document.querySelector('#localidad').value,
			provincia: document.querySelector('#provincia').value,
		},
		email: document.querySelector('#email').value,
	};
	const url = `/paciente`;
	const settings = {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(formData),
	};

  fetch(url, settings)
    .then((response) => {
      console.log(response);
      location.reload();
    })
    .catch((err) => {
      console.log("ERROR " + error);
    });
}
