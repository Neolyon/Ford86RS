var array = []

function listaMa() 
{
	document.getElementById("lm").value = "";
	
	var datos = "";
	for (var i = 0; i < array.length; i++) 
	{
		if (i == 0) 
		{
			datos = array[i];
		}
		else
		{
			datos += " " + array[i];
		}
	}
	
	document.getElementById("lm").value = datos;
}

function limpiar() 
{
	document.getElementById("docentes").selectedIndex = "0"; 
	document.getElementById("grupos").selectedIndex = "0"; 
	document.getElementById("materiasa").selectedIndex = "0"; 
	document.getElementById("materiasq").selectedIndex = "0"; 
	document.getElementById("ciclo").value = "";
	document.getElementById("grado").value = "";
	document.getElementById("turno").value = "";
	document.getElementById("salon").value = "";
	document.getElementById("desc").value = "";
	limpiarDocentes();
	limpiarGrupos();
	limpiarMateriasA();
	limpiarMateriasQ(); 
}

function guardar() 
{
	alert('Se a realizado el cargo correctamente al docente.');
	limpiar();
}

function agregarMateria() 
{
	if (document.getElementById('materiasa').length != 0) {
		var comboagregar = document.getElementById('materiasa');
		var comboquitar = document.getElementById('materiasq');
		var desc = document.getElementById("desc").value;
		var nom = document.getElementById("materiasa").value;
		agregarATabla(nom, desc);
		array.push(nom);
		comboagregar.remove(document.getElementById("materiasa").selectedIndex);
		var obj = document.createElement('option');
		obj.text = nom;
		if (enCombo(document.getElementById('materiasq'), nom) == false) 
		{
			comboquitar.add(obj);
		}
	}
}

function quitarMateria() 
{
	if (document.getElementById('materiasq').length != 0) 
	{
		var comboagregar = document.getElementById('materiasa');
		var comboquitar = document.getElementById('materiasq');
		var nom = document.getElementById("materiasq").value;
		comboquitar.remove(document.getElementById("materiasq").selectedIndex);
		var obj = document.createElement('option');
		obj.text = nom;
		for (var i = 0; i < array.length; i++) 
		{
			if (array[i] == nom) 
			{
				array.splice(i, 1);
			}
		}
		if (enCombo(document.getElementById('materiasa'), nom) == false) 
		{
			comboagregar.add(obj);
		}
		quitarATabla(nom);
	}
}

function agregarATabla(nom, desc) 
{
	var tabla = document.getElementById('tabla');
	var tr = document.createElement('tr');
	var td1 = document.createElement('td');
	var td2 = document.createElement('td');
	
	tr.id = nom + '0';
	td1.id = nom + '1';
	td2.id = nom + '2';
	
	var text1 = document.createTextNode(nom+'');
	td1.appendChild(text1);
	tr.appendChild(td1);
	tabla.appendChild(tr);
}
function quitarATabla(nom) 
{
	var tabla = document.getElementById('tabla');
	var tr = document.getElementById(nom+'0');
	var td1 = document.getElementById(nom+'1');
	
	tr.removeChild(td1);
	tabla.removeChild(tr);
}

function enCombo(combo, val) 
{
	var status = false;
	for (i = 0; i < combo.length; ++i)
	{
	    if (combo.options[i].value == val)
	    {
	      status = true;
	      break;
	    }
	}
	
	return status;
}

function limpiarDocentes() 
{
	var select = document.getElementById('docentes');
	while (select.length != 0)
	{
		select.remove(0);
	}
}

function limpiarGrupos() 
{
	var select = document.getElementById('grupos');
	while (select.length != 0)
	{
		select.remove(0);
	}
}

function limpiarMateriasA() 
{
	var select = document.getElementById('materiasa');
	while (select.length != 0)
	{
		select.remove(0);
	}
}

function limpiarMateriasQ() 
{
	var select = document.getElementById('materiasq');
	while (select.length != 0)
	{
		select.remove(0);
	}
}