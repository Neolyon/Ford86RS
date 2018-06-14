function mostrarAlumnosPorDocente(id) {
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarTablaPorDocente(this.responseText);
		}
	};
	
	ajax.open("get", "Inscripciones?op=ct&idDocente="+id, true);
	ajax.send();
}

function limpiarTablaPorDocente() 
{
	var tabla = document.getElementById('tabla');
	var rows = document.getElementById('tabla').getElementsByTagName("tr").length;
	while (rows != 1) 
	{
		var o = document.getElementById('tabla').getElementsByTagName("tr")[1];
		tabla.removeChild(o);
		rows = document.getElementById('tabla').getElementsByTagName("tr").length;
	}
}
function generarTablaPorDocente(datos) 
{
	limpiarTablaPorDocente();
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	var tr = document.createElement('tr');
    	var td1 = document.createElement('td');
    	var td2 = document.createElement('td');
    	var td3 = document.createElement('td');
    	var td4 = document.createElement('td');
    	var td5 = document.createElement('td');
    	var td6 = document.createElement('td');
    	var td7 = document.createElement('td');
    	var td8 = document.createElement('td');
    	var td9 = document.createElement('td');
    	
    	var t1 = document.createTextNode(i+1);
    	var t2 = document.createTextNode(array[i].nombre);
    	var t3 = document.createTextNode(array[i].fechaNacimiento);
    	var t4 = document.createTextNode(array[i].sexo);
    	var t5 = document.createTextNode(array[i].domicilio);
    	var t6 = document.createTextNode(array[i].nombreTutor);
    	var t7 = document.createTextNode(array[i].ocupacion);
    	var t8 = document.createTextNode(array[i].telefono1);
    	
    	td2.appendChild(t1);
    	td3.appendChild(t2);
    	td4.appendChild(t3);
    	td5.appendChild(t4);
    	td6.appendChild(t5);
    	td7.appendChild(t6);
    	td8.appendChild(t7);
    	td9.appendChild(t8);
    	
    	tr.appendChild(td1);
    	tr.appendChild(td2);
    	tr.appendChild(td3);
    	tr.appendChild(td4);
    	tr.appendChild(td5);
    	tr.appendChild(td6);
    	tr.appendChild(td7);
    	tr.appendChild(td8);
    	tr.appendChild(td9);
    	
    	tabla.appendChild(tr);
	}
}

function mostrarTodosLosAlumnosInscritos() {
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarTablaTodosLosAlumnos(this.responseText);
		}
	};
	
	ajax.open("get", "Inscripciones?op=ctt", true);
	ajax.send();
}

function limpiarTablaTodosLosAlumnos() 
{
	var tabla = document.getElementById('tabla');
	var rows = document.getElementById('tabla').getElementsByTagName("tr").length;
	while (rows != 1) 
	{
		var o = document.getElementById('tabla').getElementsByTagName("tr")[1];
		tabla.removeChild(o);
		rows = document.getElementById('tabla').getElementsByTagName("tr").length;
	}
}
function generarTablaTodosLosAlumnos(datos) 
{
	limpiarTablaTodosLosAlumnos() ;
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	var tr = document.createElement('tr');
    	var td1 = document.createElement('td');
    	var td2 = document.createElement('td');
    	var td3 = document.createElement('td');
    	var td4 = document.createElement('td');
    	var td5 = document.createElement('td');
    	var td6 = document.createElement('td');
    	var td7 = document.createElement('td');
    	
    	var t1 = document.createTextNode(array[i].NoControl);
    	var t2 = document.createTextNode(array[i].nombre);
    	var t3 = document.createTextNode(array[i].idGrado);
    	var t4 = document.createTextNode(array[i].nombreGrupo);
    	var t5 = document.createTextNode(array[i].turno);
    	var t6 = document.createTextNode(array[i].nombreDocente);
    	
    	td2.appendChild(t1);
    	td3.appendChild(t2);
    	td4.appendChild(t3);
    	td5.appendChild(t4);
    	td6.appendChild(t5);
    	td7.appendChild(t6);
    	
    	tr.appendChild(td1);
    	tr.appendChild(td2);
    	tr.appendChild(td3);
    	tr.appendChild(td4);
    	tr.appendChild(td5);
    	tr.appendChild(td6);
    	tr.appendChild(td7);
    	
    	tabla.appendChild(tr);
	}
}

function eliminarTodosLosAlumnosInscritos() 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			eliminarTablaTodosLosAlumnos(this.responseText);
		}
	};
	
	ajax.open("get", "Inscripciones?op=ctt", true);
	ajax.send();
}

function eliminarTablaTodosLosAlumnos(datos) 
{
	limpiarTablaTodosLosAlumnos() ;
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	var cb = document.createElement('input');
    	cb.type = 'button';
    	cb.id = array[i].NoControl;
    	cb.className = 'btn-danger';
    	cb.value = "Eliminar";
    	cb.onclick = id;
    	
    	var tr = document.createElement('tr');
    	var td1 = document.createElement('td');
    	var td2 = document.createElement('td');
    	var td3 = document.createElement('td');
    	var td4 = document.createElement('td');
    	var td5 = document.createElement('td');
    	var td6 = document.createElement('td');
    	var td7 = document.createElement('td');
    	
    	var t1 = document.createTextNode(array[i].NoControl);
    	var t2 = document.createTextNode(array[i].nombre);
    	var t3 = document.createTextNode(array[i].idGrado);
    	var t4 = document.createTextNode(array[i].nombreGrupo);
    	var t5 = document.createTextNode(array[i].turno);
    	var t6 = document.createTextNode(array[i].nombreDocente);
    	
    	td1.appendChild(cb);
    	td2.appendChild(t1);
    	td3.appendChild(t2);
    	td4.appendChild(t3);
    	td5.appendChild(t4);
    	td6.appendChild(t5);
    	td7.appendChild(t6);
    	
    	tr.appendChild(td1);
    	tr.appendChild(td2);
    	tr.appendChild(td3);
    	tr.appendChild(td4);
    	tr.appendChild(td5);
    	tr.appendChild(td6);
    	tr.appendChild(td7);
    	
    	tabla.appendChild(tr);
	}
}

function quitar(nc) 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			eliminarTablaTodosLosAlumnos(this.responseText);
		}
	};
	
	ajax.open("get", "Inscripciones?op=e&nc=" + nc, true);
	ajax.send();
}
function id() 
{
	quitar(this.id);
}