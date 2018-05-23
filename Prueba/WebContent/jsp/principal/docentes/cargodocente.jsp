<script type="text/javascript" src="/Prueba/js/docentes/cargodocentes.js">
</script>
<script type="text/javascript" src="/Prueba/js/AJAX/DocentesAJAX.js">
</script>
<script type="text/javascript" src="/Prueba/js/AJAX/CicloEscolar.js">
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo3.css">
<body onload="obtenerCicloActual(); generarComboGrupos(); generarComboMaterias();">
<main id = "main" class = "main1">
<form action="#" method="post">
<div>
 
 <fieldset>
    <legend>Cargo</legend>
    <center>
    Ciclo Escolar Actual:
	<input type="text" size="5" id="ciclo" readonly>
	</center>
	<br>
	Grupo:* <select id="grupo" onchange="generarComboSeleccionado();" required="required">
  	</select>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	Grado:* &nbsp;&nbsp;<input type="text" size="4" id="grado" readonly required="required">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
	Turno:*&nbsp;&nbsp;<input type="text" size="8" id ="turno" readonly required="required">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
	Sal&oacute;n:*&nbsp;&nbsp;<input type="text" size="3" id="salon" readonly required="required"> 
        <br>
    Descripcion: <input type="text" size="60" id="desc" required="required">
        <br>
        <br>
	<fieldset>
	<legend>Elegir Materias</legend>
	Elegir materia a cargar:* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="materiasa">
		</select>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button class = "btntrans" id="agregar" onclick="agregarMateria();"><img src="/Prueba/imagenes/agregar.png">Cargar Materia</button>
	<br>
	Elegir materia a Quitar:* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="materiasq" required="required">
		</select>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button class = "btntrans" id="quitar" onclick="quitarMateria();"><img src="/Prueba/imagenes/quitar.png">Quitar Materia</button>
	</fieldset>
 </fieldset>
<br><br><br>
 <fieldset>
    <legend>Informaci&oacute;n de materias a impartir</legend>	
	<table style="width:100%" border=2px id="tabla">
  <tr>
    <th>Nombre</th>
    <th>Descripci&oacute;n</th>
  </tr>
  </table> 
 </fieldset>
<br><br>
</div>
<center>
	<img src="/Prueba/imagenes/aceptar.png"><input type="submit" class = "btntrans" type="submit" id="alta" value="Dar de Alta">
	<button class = "btntrans" id="cancelar" onclick="limpiar();"><img src="/Prueba/imagenes/cancelar.png">Cancelar Operaci&oacute;n</button>
</center>
<br>
</form>
</main>
</body>