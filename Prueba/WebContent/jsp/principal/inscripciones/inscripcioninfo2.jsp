<script type="text/javascript" src ="/Prueba/js/inscripciones/insinfo2.js"></script>
<script type="text/javascript" src ="/Prueba/js/AJAX/InscripcionesAJAX.js"></script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo2.css">
<body onload="mostrarTodosLosAlumnosInscritos();">
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
	 <b>Localidad: Zamora de Hidalgo<b>
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
 <input type="radio" name = "filtro">No. Control
 &nbsp;
 <input type="radio" name = "filtro">Nombre
 &nbsp;
 <input type="radio" name = "filtro">Grado
 &nbsp;
 <input type="radio" name = "filtro">Grupo
 &nbsp;
 <input type="radio" name = "filtro">Turno
  &nbsp;
 <input type="radio" name = "filtro">Asesor
 
   <button class="actualizar" onclick="mostrarTodosLosAlumnosInscritos();">Actualizar Tabla</button>
  <button class="eliminar" onclick="eliminarTodosLosAlumnosInscritos();">Eliminar Registro</button>
 <br><br>

 &nbsp;&nbsp;&nbsp;&nbsp;Ingrese el dato a buscar: &nbsp;&nbsp;&nbsp;<input type="text" size="106" id="entrada" onkeypress="inicio();">  

  <br><br><br>
    <hr>
 <fieldset>

    <legend>Informaci&oacute;n de todas las inscripciones</legend>
	
	 <table id="tabla" style="width:100%" border=2px>
	 
  <tr>
  	<th></th>
    <th>No. Control</th>
    <th>Nombre del alumno</th>
	<th>Grado</th>
	<th>Grupo</th>
	<th>Turno</th>
	<th>Asesor</th>
  </tr>
</table> 

 </fieldset>
 <br>
 </div>
</main>
</body>