function ocultarOpciones() 
{
	document.getElementById("opciones").style.visibility = "hidden";
}

function ocultarNC() 
{
	document.getElementById("nc").style.visibility = "hidden";
}

function ocultarDatos() 
{
	document.getElementById("datos").style.visibility = "hidden";
}

function mostrarOpciones() 
{
	document.getElementById("opciones").style.visibility = "visible";
}

function mostrarNC() 
{
	document.getElementById("nc").style.visibility = "visible";
}

function mostrarNCBaja() 
{
	document.getElementById("ncbaja").style.visibility = "visible";
}

function ocultarNCBaja() 
{
	document.getElementById("ncbaja").style.visibility = "hidden";
}


function mostrarDatos() 
{
	document.getElementById("datos").style.visibility = "visible";
}

function ocultar() 
{
	ocultarDatos();
	ocultarNC();
	ocultarNCBaja();
	ocultarOpciones();
	limpiar();
}

function mostrar() 
{
	mostrarDatos();
	mostrarNC();
	mostrarOpciones();
}

function mostrarEditar() 
{
	mostrarDatos();
	ocultarNC();
	mostrarOpciones();
}

function mostrarAlumno() 
{
	ocultarNC();
	mostrarOpciones();
	mostrarDatos();
}

function mostrarAlumnoEditar() 
{
	mostrarNC();
}

function limpiar() 
{
	document.getElementById("nombrea").value = "";
	document.getElementById("fechaa").value = "";
	document.getElementById("ha").checked = true;
	document.getElementById("curpa").value = "";
	document.getElementById("lugara").value = "";
	document.getElementById("tel1a").value = "";
	document.getElementById("tel2a").value = "";
	document.getElementById("domicilioa").value = "";
	document.getElementById("enfera").value = "";
	document.getElementById("nombrep").value = "";
	document.getElementById("estp").value = "";
	document.getElementById("ocup").value = "";
	document.getElementById("fechap").value = "";
	document.getElementById("nombrem").value = "";
	document.getElementById("estm").value = "";
	document.getElementById("ocum").value = "";
	document.getElementById("fecham").value = "";
	document.getElementById("nombret").value = "";
	document.getElementById("estt").value = "";
	document.getElementById("ocut").value = "";
	document.getElementById("fechat").value = "";
	document.getElementById("ambos").checked = true;
	
//	document.getElementById("no").checked = true;
//	document.getElementById("numcon").value = "";
//	document.getElementById("promedio").value = "";
//	document.getElementById("promediog").value = "";
//	document.getElementById("asesor").value = "";
//	document.getElementById("grado").value = "";
//	document.getElementById("grupo").value = "";
//	document.getElementById("turno").value = "";
//	
//	document.getElementById("gradoelegido").selectedIndex = "0"; 
}

function guardar() 
{
	ocultar();
	alert('Se a guardado con exito.');
}

function baja() 
{
	ocultarNCBaja();
	alert('Se a dado de baja el alumno.');
}

function OcularTodo()
{
	document.getElementById("btnc").style.visibility = "visible";
	document.getElementById("btne").style.visibility = "hidden";
	document.getElementById("btnb").style.visibility = "hidden";
}

function OcularT()
{
	document.getElementById("btnc").style.visibility = "hidden";
	document.getElementById("btne").style.visibility = "hidden";
	document.getElementById("btnb").style.visibility = "hidden";
}

function MostrarTodo()
{
	document.getElementById("btnc").style.visibility = "visible";
	document.getElementById("btne").style.visibility = "visible";
	document.getElementById("btnb").style.visibility = "visible";
}

function OcultarC()
{
	document.getElementById("btnc").style.visibility = "hidden";
}

function validarNC() 
{
	if (document.getElementById("numc").value.length == 10 && validarTel(document.getElementById("numc").value)) 
	{
		 mostrarAlumno();
	}
}

function validarNCB() 
{
	if (document.getElementById("numcb").value.length == 10 && validarTel(document.getElementById("numcb").value)) 
	{
		baja(); 
		MostrarTodo();
	}
}

function limpiarNC() 
{
	document.getElementById("numc").value = '';
	document.getElementById("numcb").value = '';
}

function validarTel(dato)
{
    var expresionRegular1=/[0-9]{4}[A-Z]{2}[0-9]{4}/;//<--- con esto vamos a validar el numero
    var expresionRegular2=/\s/;//<--- con esto vamos a validar que no tenga espacios en blanco
   
    if(expresionRegular2.test(dato))
    {
    	alert('error existen espacios en blanco');
    	return false;
    }
    else if(!expresionRegular1.test(dato))
    {
    	alert('No. de Control incorrecto. Ejemplo valido de un NC: 2018MO3456');
    	return false;
   	}
    
    return true;
  }