function editarGrupos() 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			editarTablaGrupos(this.responseText);
		}
	};
	
	ajax.open("get", "Grupos?op=cgru", true);
	ajax.send();
}

function editarTablaGrupos(datos) 
{
	limpiarTablaTodosLosGrupos();
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	var b = array[i].nombre;
    	var cb = document.createElement('input');
    	cb.type = 'button';
    	alert(array[i].idGrupo);
    	cb.id = array[i].idGrupo;
    	cb.className = 'btn-warning';
    	cb.value = "Editar";
    	cb.addEventListener('click', function(){
    	    idE(this.id);
    	});;
    	
    	var tr = document.createElement('tr');
    	var td1 = document.createElement('td');
    	var td2 = document.createElement('td');
    	var td3 = document.createElement('td');
    	var td4 = document.createElement('td');
    	var td5 = document.createElement('td');
    	var td6 = document.createElement('td');
    	
    	var t1 = document.createTextNode(array[i].nombre);
    	var t2 = document.createTextNode(array[i].grado);
    	var t3 = document.createTextNode(array[i].salon);
    	var t4 = document.createTextNode(array[i].turno);
    	var t5 = document.createTextNode(array[i].descripcion);
    	
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

function idE(idd) 
{
	editar(idd);
}

function editar(id) 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{ 
		if (this.readyState == 4 && this.status == 200) 
		{
			operacionEditar(this.responseText);
		}
	};
	
	ajax.open("get", "Grupos?op=cc&id="+id, true);
	ajax.send();
}

function operacionEditar(datos) 
{
	document.getElementById('peditar').style.visibility = "visible";
	generarTablaG();
	
	var nombre = document.getElementById('nombre2');
	var turno = document.getElementById('turno2');
	var salon = document.getElementById('salon2');
	var descripcion = document.getElementById('desc2');
	var grado = document.getElementById('idg2');
	var id = document.getElementById('idG');
	
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	nombre.value = array[i].nombre;
    	descripcion.value = array[i].descripcion;
    	grado.selectedIndex = (array[i].idGrado-1)+'';
    	id.value = array[i].idGrado;
    	salon.value = array[i].salon;
    	turno.value = array[i].turno;
	}
}

function generarTablaG()
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarTablaTodosLosGrupos(this.responseText);
		}
	};
	
	ajax.open("get", "Grupos?op=cgru", true);
	ajax.send();
}

function limpiarTablaTodosLosGrupos() 
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

function generarTablaTodosLosGrupos(datos) 
{
	limpiarTablaTodosLosGrupos() ;
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
    	
    	var t1 = document.createTextNode(array[i].nombre);
    	var t2 = document.createTextNode(array[i].grado);
    	var t3 = document.createTextNode(array[i].salon);
    	var t4 = document.createTextNode(array[i].turno);
    	var t5 = document.createTextNode(array[i].descripcion);
    	
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

function eliminarTodosLosGrupos() 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			eliminarTablaTodosLosGrupos(this.responseText);
		}
	};
	
	ajax.open("get", "Grupos?op=cgru", true);
	ajax.send();
}

function eliminarTablaTodosLosGrupos(datos) 
{
	limpiarTablaTodosLosGrupos() ;
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	var a = array[i].nombre;
    	
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
    	
    	var t1 = document.createTextNode(array[i].nombre);
    	var t2 = document.createTextNode(array[i].grado);
    	var t3 = document.createTextNode(array[i].salon);
    	var t4 = document.createTextNode(array[i].turno);
    	var t5 = document.createTextNode(array[i].descripcion);
    	
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
			eliminarTodosLosGrupos();
		}
	};
	
	ajax.open("get", "Grupos?op=e&nombre="+id, true);
	ajax.send();
}

function id(id) 
{
	quitar(id);
}