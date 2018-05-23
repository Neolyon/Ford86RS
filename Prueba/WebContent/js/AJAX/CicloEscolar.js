function obtenerCicloActual() 
{
	var fecha = new Date();
	var anoActual = fecha.getFullYear();
	var anoAnterior = parseInt(anoActual + '') - 1;
	document.getElementById('ciclo').value =  anoAnterior+"-"+anoActual;
}

function getCicloActual() 
{
	var fecha = new Date();
	var anoActual = fecha.getFullYear();
	var anoAnterior = parseInt(anoActual + '') - 1;
	return anoAnterior+"-"+anoActual;
}