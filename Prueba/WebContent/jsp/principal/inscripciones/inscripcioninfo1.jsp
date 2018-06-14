<script type="text/javascript" src ="/Prueba/js/inscripciones/insinfo1.js">
</script>
<script type="text/javascript" src ="/Prueba/js/AJAX/InscripcionesAJAX.js">
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo2.css">
<body onload="mostrarAlumnosPorDocente(${docente.idDocente});">
<main id = "main" class = "main1">
<div> 

<fieldset>
    <legend>Informaci&oacute;n</legend>
	 <center>
     <b>Escuela: Ford86<b>
	 &nbsp;&nbsp;
	 <b>Clave: 16DPR3412T<b>
	 &nbsp;&nbsp;
	 <b>Zona Escolar: 099<b>
	 &nbsp;&nbsp;
	 <b>Sector: 003<b>
	 <br><br>
	 <b>Turno: Matutino<b>
	 &nbsp;&nbsp;&nbsp;
	 <b>Ciclo Escolar: 2017-2018<b>
	 <br><br>
	 <b>Maestro(a): Oscar Mart&iacute;n Silva Compar&aacute;n<b>
	 &nbsp;&nbsp;&nbsp;
	 <b>Municipio: Zamora<b>
	 &nbsp;&nbsp;&nbsp;
	 <b>Nombre del centro de trabajo: Ford 86<b>
	 </center>
 </fieldset>
 
 <br><br>
 <img src="/Prueba/imagenes/filtrar.png">Filtrar Informaci&oacute;n por:
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="radio" name = "filtro" checked>No Filtrar
 &nbsp;
 <input type="radio" name = "filtro">No. Lista
 &nbsp;
 <input type="radio" name = "filtro">Nombre
 &nbsp;
 <input type="radio" name = "filtro">Edad
 &nbsp;
 <input type="radio" name = "filtro">Nuevo Ingreso
 &nbsp;
 <input type="radio" name = "filtro">Repetidor
   <button class="actualizar" onclick="mostrarAlumnosPorDocente(${docente.idDocente});">Actualizar Tabla</button>
 <br><br>

 &nbsp;&nbsp;&nbsp;&nbsp;Ingrese el dato a buscar: &nbsp;&nbsp;&nbsp;<input type="text" size="106" id="entrada" onkeypress="inicio();" required>  

  <br><br><br>
    <hr>
 <fieldset>

    <legend>Informaci&oacute;n de inscripciones</legend>
	
	 <table style="width:100%" border=2px id = "tabla">
	 
  <tr>
  	<th></th>
    <th>No. Lista</th>
    <th>Nombre del alumno</th>
	<th>Fecha Nacimiento</th>
	<th>Sexo</th>
	<th>Domicilio</th>
	<th>Nombre del Tutor</th>
	<th>Ocupación</th>
	<th>Telefono</th>
  </tr>
</table> 

 </fieldset>
 <br>
 </div>
</main>
</body>