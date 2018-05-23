function mostrarAlumnosPorDocente() {
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			generarTablaPorDocente(this.responseText);
		}
	};
	
	ajax.open("get", "Alumnos?op=ct&idD=2", true);
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
    	
    	var t1 = document.createTextNode(i+1);
    	var t2 = document.createTextNode(array[i].NoControl);
    	var t3 = document.createTextNode(array[i].nombre);
    	var t4 = document.createTextNode(array[i].fechaNacimiento);
    	var t5 = document.createTextNode(array[i].sexo);
    	
    	td1.appendChild(t1);
    	td2.appendChild(t2);
    	td3.appendChild(t3);
    	td4.appendChild(t4);
    	td5.appendChild(t5);
    	
    	tr.appendChild(td1);
    	tr.appendChild(td2);
    	tr.appendChild(td3);
    	tr.appendChild(td4);
    	tr.appendChild(td5);
    	
    	tabla.appendChild(tr);
	}
}

function mostrarAlumnosPorDocenteTabla() 
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			tablaInfo(this.responseText);
		}
	};
	
	ajax.open("get", "Alumnos?op=ctt&idD=2", true);
	ajax.send();
}

function cargarInfo() 
{
	mostrarAlumnosPorDocente();
	mostrarAlumnosPorDocenteTabla();
}

function tablaInfo(datos) 
{
	var array = eval(datos);
	var aih = document.getElementById('aih');
	var aim = document.getElementById('aim');
	var ait = document.getElementById('ait');
	var rih = document.getElementById('rh');
	var rim = document.getElementById('rm');
	var rit = document.getElementById('rt');
	var pih = document.getElementById('ph');
	var pim = document.getElementById('pm');
	var pit = document.getElementById('pt');
	var npih = document.getElementById('nph');
	var npim = document.getElementById('npm');
	var npit = document.getElementById('nph');
	
	ait.innerHTML = array.length;
	var numaih = 0;
	var numaim = 0;
	
	var numrh = 0;
	var numrm = 0;
	
	var numph = 0;
	var numpm = 0;
	
	var numnph = 0;
	var numnpm = 0;
	
	for (var i = 0; i < array.length; i++) 
    {
		var a = [array[i].promedioPrimero, array[i].promedioSegundo, array[i].promedioTercero,
			array[i].promedioCuarto, array[i].promedioQuinto, array[i].promedioSexto];
		if (array[i].sexo == 'H') 
		{
			numaih++;
			if (array[i].repitiendo == 'S') 
			{
				numrh++;
			}
			
			if (obtenerCalGrado(a, array[i].grado) > 5) 
			{
				numph++;
			}
			else
			{
				numnph++;
			}
		}
		else if (array[i].sexo == 'M')
		{
			numaim++;
			if (array[i].repitiendo == 'S') 
			{
				numrm++;
			}
			
			if (obtenerCalGrado(a, array[i].grado) > 5) 
			{
				numpm++;
			}
			else
			{
				numnpm++;
			}
		}
    }
	
	aih.innerHTML = numaih;
	aim.innerHTML = numaim;
	
	rh.innerHTML = numrh;
	rm.innerHTML = numrm;
	rt.innerHTML = numrh + numrm;
	
	ph.innerHTML = numph;
	pm.innerHTML = numpm;
	pt.innerHTML = numph + numpm;
	
	nph.innerHTML = numnph;
    npm.innerHTML = numnpm;
	npt.innerHTML = numnph + numnpm;
}

function obtenerCalGrado(array, grado) 
{
	var promedio = 0.0;
	
	switch (grado) 
	{
    case "1":
        promedio = parseFloat(array[0]);
        break;
    case "2":
    	promedio = parseFloat(array[1]);
        break;
    case "3":
    	promedio = parseFloat(array[2]);
        break;
    case "4":
    	promedio = parseFloat(array[3]);
        break;
    case "5":
    	promedio = parseFloat(array[4]);
        break;
    case "6":
    	promedio = parseFloat(array[5]);
        break;
	}
	
	return promedio;
}