function mostrarnc() 
{
	document.getElementById("nc").style.visibility = "visible";
}

function mostrardatos() 
{
	document.getElementById("datos").style.visibility = "visible";
}

function ocultarnc() 
{
	document.getElementById("nc").style.visibility = "hidden";
}

function ocultardatos() 
{
	document.getElementById("datos").style.visibility = "hidden";
}

function ocultar()
{
	ocultardatos();
	ocultarnc();
}

function mostrar()
{
	mostrardatos();
	ocultarnc();
}


function nuevaInscripcion() 
{
	mostrar();
	limpiar();
}

function guardarReinscripcion() 
{
	alert('Se realizó la reinscripción con éxito.');
	ocultar();
	limpiar();
}

function cancelarReinscripcion() 
{
	ocultar();
	limpiar();
}

function limpiar() 
{
	document.getElementById("numc").value = "";
	document.getElementById("nombrea").value = "";
	document.getElementById("fechaa").value = "";
	document.getElementById("ha").checked = true;
	document.getElementById("curpa").value = "";
	document.getElementById("lugara").value = "";
	document.getElementById("tel1a").value = "";
	document.getElementById("tel2a").value = "";
	document.getElementById("domicilioa").value = "";
	document.getElementById("no").checked = true;
	document.getElementById("asesora").value = "";
	document.getElementById("gradoa").value = "";
	document.getElementById("grupoa").value = "";
	document.getElementById("promedioa").value = "";
	document.getElementById("promediog").value = "";
	document.getElementById("asesorasig").value = "";
	document.getElementById("gradoc").value = "";
	document.getElementById("grupoc").value = "";
	document.getElementById("turnoc").value = "";
	document.getElementById("noo").checked = true;
}

function OcularTodo()
{
	document.getElementById("btnn").style.visibility = "visible";
	document.getElementById("btng").style.visibility = "hidden";
	document.getElementById("btnc").style.visibility = "hidden";
	//document.getElementById("btnl").style.visibility = "hidden";
}
function OcularNuevo()
{
	document.getElementById("btnn").style.visibility = "hidden";
	document.getElementById("btng").style.visibility = "visible";
	document.getElementById("btnc").style.visibility = "visible";
	//document.getElementById("btnl").style.visibility = "hiden";
}

function OcultarT()
{
	document.getElementById("btnn").style.visibility = "hidden";
	document.getElementById("btng").style.visibility = "hidden";
	document.getElementById("btnc").style.visibility = "hidden";
	//document.getElementById("btnl").style.visibility = "hidden";
}

function MostrarL()
{
	//document.getElementById("btnl").style.visibility = "visible";
}

function validarNC() 
{
	if (document.getElementById("numc").value.length == 10 && validarTel(document.getElementById("numc").value)) 
	{
		mostrar(); 
		OcularNuevo(); 
		MostrarL();
	}
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