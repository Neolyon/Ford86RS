function inicio() 
{
	var en = document.getElementById('entrada');
	
	if (en.value.length >= 60) 
	{
		var entrada = en.value.split('');
		entrada.pop();
		en.value = entrada.join("");
	}
}

function actualizarTabla()
{
	alert('Se ha actulizado la tabla.');
}

function eliminar() 
{
	var tabla = document.getElementById('tabla');
	
	var c = document.createElement('input');
	c.type = 'checkbox';
	c.id = 'e';
	var cnombre = document.createTextNode('Eliminar');
	c.appendChild(cnombre);
	var tr = document.createElement('tr');
	var td = document.createElement('td');
	td.appendChild(c);
	tr.appendChild(td);
	tabla.appendChild(tr);
}