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