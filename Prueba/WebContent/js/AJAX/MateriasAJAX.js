function generarTablaM()
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarTablaMaterias(this.responseText);
		}
	};
	
	ajax.open("get", "Materias?op=c", true);
	ajax.send();
}

function limpiarTablaMaterias() 
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

function generarTablaMaterias(datos) 
{
	limpiarTablaMaterias();
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	var tr = document.createElement('tr');
    	var td1 = document.createElement('td');
    	var td2 = document.createElement('td');
    	var td3 = document.createElement('td');
    	var td4 = document.createElement('td');
    	
    	var t1 = document.createTextNode(array[i].nombre);
    	var t2 = document.createTextNode(array[i].idGrado);
    	var t3 = document.createTextNode(array[i].descripcion);
    	
    	td2.appendChild(t1);
    	td3.appendChild(t2);
    	td4.appendChild(t3);

    	
    	tr.appendChild(td1);
    	tr.appendChild(td2);
    	tr.appendChild(td3);
    	tr.appendChild(td4);
    	
    	tabla.appendChild(tr);
	}
}

function editarMaterias() 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			editarTablaMaterias(this.responseText);
		}
	};
	
	ajax.open("get", "Materias?op=c", true);
	ajax.send();
}

function eliminarMaterias() 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			eliminarTablaMaterias(this.responseText);
		}
	};
	
	ajax.open("get", "Materias?op=c", true);
	ajax.send();
}

function eliminarTablaMaterias(datos) 
{
	limpiarTablaMaterias() ;
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
    	
    	var t1 = document.createTextNode(array[i].nombre);
    	var t2 = document.createTextNode(array[i].idGrado);
    	var t3 = document.createTextNode(array[i].descripcion);
    	
    	td1.appendChild(cb);
    	td2.appendChild(t1);
    	td3.appendChild(t2);
    	td4.appendChild(t3);
    	
    	tr.appendChild(td1);
    	tr.appendChild(td2);
    	tr.appendChild(td3);
    	tr.appendChild(td4);
    	
    	tabla.appendChild(tr);
	}
}

function editarTablaMaterias(datos) 
{
	limpiarTablaMaterias() ;
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	var b = array[i].nombre;
    	var cb = document.createElement('input');
    	cb.type = 'button';
    	cb.id = array[i].idMateria;
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
    	
    	var t1 = document.createTextNode(array[i].nombre);
    	var t2 = document.createTextNode(array[i].idGrado);
    	var t3 = document.createTextNode(array[i].descripcion);
    	
    	td1.appendChild(cb);
    	td2.appendChild(t1);
    	td3.appendChild(t2);
    	td4.appendChild(t3);
    	
    	tr.appendChild(td1);
    	tr.appendChild(td2);
    	tr.appendChild(td3);
    	tr.appendChild(td4);
    	
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
			eliminarMaterias();
		}
	};
	
	ajax.open("get", "Materias?op=e&nombre="+id, true);
	ajax.send();
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
	
	ajax.open("get", "Materias?op=cc&id="+id, true);
	ajax.send();
}

function id(id) 
{
	quitar(id);
}

function idE(idd) 
{
	editar(idd);
}

function operacionEditar(datos) 
{
	document.getElementById('peditar').style.visibility = "visible";
	generarTablaM();
	
	var nombre = document.getElementById('nom2');
	var descripcion = document.getElementById('desc2');
	var grado = document.getElementById('idg2');
	var id = document.getElementById('idM');
	
	var array = eval(datos);
	
    var tabla = document.getElementById('tabla');

    for (var i = 0; i < array.length; i++) 
    {
    	nombre.value = array[i].nombre;
    	descripcion.value = array[i].descripcion;
    	grado.selectedIndex = (array[i].idGrado-1)+'';
    	id.value = array[i].idMateria;
	}
}