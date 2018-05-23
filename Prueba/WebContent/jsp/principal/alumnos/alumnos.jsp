<script type="text/javascript" src="/Prueba/js/alumnos/alumnos.js">
</script>
<script type="text/javascript" src="/Prueba/js/AJAX/AlumnosAJAX.js">
</script>
<body onload="cargarInfo();">
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
	 <b>Grado: 6<b>
	 &nbsp;&nbsp;&nbsp;
	 <b>Grupo: A<b>
	 </center>
 </fieldset>
 <br><br>
 <img src="/Prueba/imagenes/filtrar.png">Filtrar Informaci&oacute;n por:
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="radio" name = "filtrar" checked>No Filtrar
 &nbsp;
 <input type="radio" name = "filtrar" >No. Lista
 &nbsp;
 <input type="radio" name = "filtrar" >No. Control
 &nbsp;
 <input type="radio" name = "filtrar" >Nombre
 &nbsp;
 <input type="radio" name = "filtrar" >Sexo
 &nbsp;
 <input type="radio" name = "filtrar" >Edad
 &nbsp;
 <input type="radio" name = "filtrar" >Repetidor
 <br><br>
 &nbsp;&nbsp;&nbsp;&nbsp;Ingrese el dato a buscar: &nbsp;&nbsp;&nbsp;<input id = "entrada" type="text" size="106" onkeypress="inicio();">
  <br><br><br>
 <fieldset>
    <legend>Alumnos</legend>
	 <table style="width:100%" border=2px id="tabla">
  <tr>
    <th>No. Lista</th>
    <th>No. Control</th>
	<th>Nombre</th>
	<th>Fecha de Nacimiento</th>
	<th>Sexo</th>
  </tr>
</table> 
 </fieldset>
 <br>
 <fieldset>
    <legend>Informaci&oacute;n</legend>
	 <table style="width:100%" border=2px>
  <tr>
    <th>Campo</th>
    <th>Hombres</th>
	<th>Mujeres</th>
	<th>Total</th>
  </tr>
  <tr>
    <td>Alumnos Inscritos</td>
    <td id = "aih"></td>
    <td id = "aim"></td>
	<td id = "ait"></td>
  </tr>
  <tr>
    <td>Repetidores</td>
    <td id = "rh"></td>
    <td id = "rm"></td>
	<td id = "rt"></td>
  </tr>
    <tr>
    <td>Promovidos</td>
    <td id = "ph"></td>
    <td id = "pm"></td>
	<td id = "pt"></td>
  </tr>
    <tr>
    <td>No Promovidos</td>
    <td id = "nph"></td>
    <td id = "npm"></td>
	<td id = "npt"></td>
  </tr>
</table> 
 </fieldset>
</div>
</main>
</body>