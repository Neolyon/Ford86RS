function ocultar() 
{
	document.getElementById("panel").style.visibility = "hidden";
	limpiar();
}

function mostrar() 
{
	document.getElementById("panel").style.visibility = "visible";
}



function camdes() 
{
	var en = document.getElementById('entrada');
	
	if (en.value.length >= 50) 
	{
		var entrada = en.value.split('');
		entrada.pop();
		en.value = entrada.join("");
	}
}

function limpiar() 
{
	document.getElementById("desc").value = "";
	limpiarSalon();
	limpiarTurno();
	//limpiarGrado();
	//limpiarGrupo();
}

function guardar() 
{
	document.getElementById("panel").style.visibility = "hidden";
	limpiar();
	alert('Se guardo con éxito.');
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

function limpiarSalon() 
{
   document.getElementById('salon').value = '';
}

function limpiarTurno() 
{
	document.getElementById('turno').value ='';
}

function OcularTodo()
{
	document.getElementById("btnn").style.visibility = "hidden";
	document.getElementById("btne").style.visibility = "hidden";
	document.getElementById("btnb").style.visibility = "hidden";
}

function OcultarCan()
{
	document.getElementById("can").style.visibility = "hidden";
}

function MostrarCan()
{
	document.getElementById("can").style.visibility = "visible";
}

function MostrarTodo()
{
	document.getElementById("btnn").style.visibility = "visible";
	document.getElementById("btne").style.visibility = "visible";
	document.getElementById("btnb").style.visibility = "visible";
}