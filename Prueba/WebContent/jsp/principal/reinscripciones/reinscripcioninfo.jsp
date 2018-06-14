<script type="text/javascript" src ="/Prueba/js/reinscripciones/reinsinfo.js">
</script>
<script type="text/javascript" src ="/Prueba/js/AJAX/ReinscripcionesAJAX.js">
</script>
<link rel=
"stylesheet" type="text/css" href="/Prueba/css/estilo2.css">
<body onload="mostrarTodosLosAlumnosReinscritos();">
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
 <input type="radio" name = "filtrar" checked>No Filtrar
 &nbsp;
 <input type="radio"name = "filtrar">No. Control
 &nbsp;
 <input type="radio" name = "filtrar">Ciclo Escolar
 &nbsp;
 <input type="radio" name = "filtrar">Grado
 &nbsp;
 <input type="radio" name = "filtrar">Grupo
 &nbsp;
 <input type="radio" name = "filtrar">Asesor
 
   <button class="actualizar" onclick="mostrarTodosLosAlumnosReinscritos();">Actualizar Tabla</button>
  <button class="eliminar" onclick="eliminarTodosLosAlumnosReinscritos();">Eliminar Registro</button>
 <br><br>

 &nbsp;&nbsp;&nbsp;&nbsp;Ingrese el dato a buscar: &nbsp;&nbsp;&nbsp;<input type="text" size="106" id="entrada" onkeypress="inicio();">  

  <br><br><br>
    <hr>
 <fieldset>

    <legend>Informaci&oacute;n de todas las Reinscripciones</legend>
	
	 <table id="tabla" style="width:100%" border=2px>
	 
  <tr>
  	<th></th>
    <th>No. Control</th>
    <th>Recursa</th>
	<th>Ciclo Escolar</th>
	<th>Grado a Cursar</th>
	<th>Grupo Asignado</th>
	<th>Turno Asignado</th>
	<th>Asesor Asignado</th>
  </tr>
</table> 

 </fieldset>
 <br>
 </div>
</main>
</body>