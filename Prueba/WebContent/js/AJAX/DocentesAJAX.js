function mostrarDocentesDisponibles() 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarCombo(this.responseText);
		}
	};
	
	ajax.open("get", "Docentes?op=cc", true);
	ajax.send();
}

function limpiarCombo() 
{
	var select = document.getElementById("combo");
	var length = select.options.length;
	while (length != 0) 
	{
		select.options[0] = null;
		length--;
	}
}

function generarCombo(datos) 
{
	limpiarCombo();
	var array = eval(datos);
	
    var combo = document.getElementById('combo');

    for (var i = 0; i < array.length; i++) 
    {
    	var option = document.createElement("option");
    	option.text = array[i].nombre;
    	combo.add(option); 
	}
}

function generarTablaCargo()
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarTablaCargos(this.responseText);
		}
	};
	
	ajax.open("get", "Docentes?op=c", true);
	ajax.send();
}

function limpiarTablaCargos() 
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

function generarTablaCargos(datos) 
{
	limpiarTablaCargos();
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
    	
    	var t1 = document.createTextNode(array[i].ciclo);
    	var t2 = document.createTextNode(array[i].nombreDocente);
    	var t3 = document.createTextNode(array[i].grado + "" + array[i].nombreGrupo);
    	var t4 = document.createTextNode(array[i].turno);
    	var t5 = document.createTextNode(array[i].listaMaterias);
    	
    	td2.appendChild(t1);
    	td3.appendChild(t2);
    	td4.appendChild(t3);
    	td5.appendChild(t4);
    	td6.appendChild(t5);

    	
    	tr.appendChild(td1);
    	tr.appendChild(td2);
    	tr.appendChild(td3);
    	tr.appendChild(td4);
    	tr.appendChild(td5);
    	tr.appendChild(td6);
    	
    	tabla.appendChild(tr);
	}
}

function eliminarCargos() 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			eliminarTablaCargos(this.responseText);
		}
	};
	
	ajax.open("get", "Docentes?op=c", true);
	ajax.send();
}

function eliminarTablaCargos(datos) 
{
	limpiarTablaCargos() ;
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	var a = array[i].idCargoDocente;
    	
    	var cb = document.createElement('input');
    	cb.type = 'button';
    	cb.id = array[i].NoControl;
    	cb.className = 'btn-danger';
    	cb.value = "Eliminar";
    	cb.addEventListener('click', function(){
    	    id(a);
    	});;
    	
    	var tr = document.createElement('tr');
    	var td1 = document.createElement('td');
    	var td2 = document.createElement('td');
    	var td3 = document.createElement('td');
    	var td4 = document.createElement('td');
    	var td5 = document.createElement('td');
    	var td6 = document.createElement('td');
    	
    	var t1 = document.createTextNode(array[i].ciclo);
    	var t2 = document.createTextNode(array[i].nombreDocente);
    	var t3 = document.createTextNode(array[i].grado + "" + array[i].nombreGrupo);
    	var t4 = document.createTextNode(array[i].turno);
    	var t5 = document.createTextNode(array[i].listaMaterias);
    	
    	td1.appendChild(cb);
    	td2.appendChild(t1);
    	td3.appendChild(t2);
    	td4.appendChild(t3);
    	td5.appendChild(t4);
    	td6.appendChild(t5);

    	
    	tr.appendChild(td1);
    	tr.appendChild(td2);
    	tr.appendChild(td3);
    	tr.appendChild(td4);
    	tr.appendChild(td5);
    	tr.appendChild(td6);
    	
    	tabla.appendChild(tr);
	}
}

function quitar(id) 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			eliminarCargos();
		}
	};
	
	ajax.open("get", "Docentes?op=ec&id="+id, true);
	ajax.send();
}

function id(id) 
{
	quitar(id);
}

function generarComboGrupos()
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarComboG(this.responseText);
		}
	};
	
	ajax.open("get", "Grupos?op=cgru", true);
	ajax.send();
}

function generarComboG(datos) 
{
	limpiarComboCosasGrupos();
	var array = eval(datos);
	
    var g = document.getElementById('grupo');

    for (var i = 0; i < array.length; i++) 
    {
    	var option = document.createElement("option");
    	option.text = array[i].nombre;
    	if (i == 0) 
    	{
    		document.getElementById('grado').value = array[i].grado;
    		document.getElementById('turno').value = array[i].turno;
    		document.getElementById('salon').value = array[i].salon;
		}
    	g.add(option); 
	}
}

function limpiarComboCosasGrupos() 
{
	var select = document.getElementById("grupo");
	var length = select.options.length;
	while (length != 0) 
	{
		select.options[0] = null;
		length--;
	}
	document.getElementById('grado').value = "";
	document.getElementById('turno').value = "";
	document.getElementById('salon').value = "";
}

function generarComboSeleccionado()
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarComboS(this.responseText);
		}
	};
	
	ajax.open("get", "Grupos?op=cgru", true);
	ajax.send();
}

function generarComboS(datos) 
{
	var array = eval(datos);
	
    var nombre = document.getElementById('grupo').value;
  
    for (var i = 0; i < array.length; i++) 
    {
    	if (array[i].nombre == nombre) 
    	{
    		document.getElementById('grado').value = array[i].grado;
    		document.getElementById('turno').value = array[i].turno;
    		document.getElementById('salon').value = array[i].salon;
    		break;
		}
	}
}

function generarComboMaterias()
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarComboM(this.responseText);
		}
	};
	
	ajax.open("get", "Materias?op=c", true);
	ajax.send();
}

function limpiarComboMaterias() 
{
	var select = document.getElementById("materiasa");
	var length = select.options.length;
	while (length != 0) 
	{
		select.options[0] = null;
		length--;
	}
	select = document.getElementById("materiasq");
	length = select.options.length;
	while (length != 0) 
	{
		select.options[0] = null;
		length--;
	}
}

function generarComboM(datos) 
{
	limpiarComboMaterias();
	var array = eval(datos);

    var g = document.getElementById('materiasa');

    for (var i = 0; i < array.length; i++) 
    {
    	var option = document.createElement("option");
    	option.text = array[i].nombre;
    	g.add(option); 
	}
}
