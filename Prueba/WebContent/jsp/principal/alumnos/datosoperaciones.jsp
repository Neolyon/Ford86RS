<script type="text/javascript" src="/Prueba/js/alumnos/operaciones.js">
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo3.css">
<body onload="ocultar();">
<main id = "main" class = "main1">
<form>
<div> 
<fieldset style="width:50%">
 <legend>Men&uacute;</legend>
 <div class="menu1">
 <ul>
 <button id = "btnc" class = "btnconsultainfo" type="button" onclick="mostrarNC(); OcularTodo(); OcultarC(); limpiarNC();">Consultar Información</button>
 <button id = "btne" class = "btneditarinfo"  type="button" onclick="mostrarAlumnoEditar(); OcularT(); limpiarNC();">Editar Información</button>
 <button id = "btnb" class = "btnbaja"  type="button" onclick="mostrarNCBaja(); OcularT(); limpiarNC();">Dar de Baja</button><br>
 </ul>
 </div>
 </fieldset>
 
 <br><br>
 <div id="nc"> 
 <fieldset>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/Prueba/imagenes/alumno.png">
    <b>No. Control del Alumno:* <b>&nbsp;&nbsp;&nbsp;<input id="numc" type="text" size="20" pattern="[0-9]{4}[A-Z]{2}[0-9]{4}" placeholder="Ejemplo: 2018MO0987" required> 
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class = "btn-info" type="button" onclick="validarNC();" value="Cargar Alumno">
	&nbsp;&nbsp;&nbsp;&nbsp;<button class = "btn-danger" type="button" onclick="ocultarNC(); MostrarTodo(); limpiarNC();">Cancelar</button>
 </fieldset>
 <br>
 <div id="ncbaja"> 
 <fieldset>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/Prueba/imagenes/alumno.png">
    <b>No. Control del Alumno:* <b>&nbsp;&nbsp;&nbsp;<input id="numcb" type="text" size="20" pattern="[0-9]{4}[A-Z]{2}[0-9]{4}" placeholder="Ejemplo: 2018MO0987" required> 
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class = "btn-info" type="submit" onclick="validarNCB();" value="Dar de Baja">
	&nbsp;&nbsp;&nbsp;&nbsp;<button class = "btn-danger" type="button" onclick="ocultarNCBaja(); MostrarTodo(); limpiarNC();">Cancelar</button>
 </fieldset>
</div>
</div>
<br><br>

<div id="opciones">
<fieldset style="width:30%">
 <legend>Opciones</legend>
<div class="menu2">
<ul>
 <button class = "btnguardar"  type="submit" onclick="guardar(); MostrarTodo();">Guardar</button>
 <button class = "btncancelar"  type="submit" onclick="ocultar(); MostrarTodo();">Cancelar</button>
 <button class = "btnlimpiar"  type="submit" onclick="limpiar();">Limpiar</button>
 </ul>
 </div>
</fieldset>
</div>
<br><br><br>

<div id="datos">
<fieldset>
 <legend>Informaci&oacute;n del Alumno</legend>
	<fieldset>
	  <legend>Personal</legend>
	   Nombre: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id = "nombrea">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fecha de nacimiento: &nbsp;&nbsp;
		<input type="date" size="12" id="fechaa">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sexo: &nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name = "sexo" id="ha" checked>&nbsp;H&nbsp;<input type="radio"  name = "sexo" id="ma">&nbsp;M &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<br>
		CURP: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="curpa"><br><br>
	    Lugar de nacimiento: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="lugara">
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <br>
	    Domicilio: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="80" id="domicilioa"><br><br>
	   Tel&eacute;fonos de emergencia &nbsp;&nbsp;&nbsp; Tel&eacute;fono #1: &nbsp;&nbsp;&nbsp;<input type="text" size="12" id="tel1a">
	    &nbsp;&nbsp;&nbsp; Tel&eacute;fono #2: &nbsp;&nbsp;&nbsp;<input type="text" size="12" id="tel2a">&nbsp;&nbsp;&nbsp;&nbsp;
		Vive con:&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name = "padres" id="ambos" checked>Ambos padres&nbsp;<input type="radio" name = "padres" id="pa">Padre&nbsp;<input type="radio" name = "padres" id="ma">Madre&nbsp;<input type="radio" name = "padres" id="tu">Tutor <br><br>
	   Enfermedades: <textarea cols="150" rows="8" name="descripcion" id="enfera"></textarea>
	</fieldset>
</fieldset>
<br>
<fieldset>
 <legend>Familiar</legend>
 Nombre del Padre: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="nombrep"><br><br>
  Estudios: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="estp"> <br><br>
  Ocupaci&oacute;n: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="ocup"><br><br>
  Fecha de nacimiento: &nbsp; <input type="date" size="12" id="fechap"><br><br>
  
  <hr>
  
  Nombre de la Madre: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="nombrem"><br><br>
  Estudios: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="estm"> <br><br>
  Ocupaci&oacute;n: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="ocum"><br><br>
  Fecha de nacimiento: &nbsp; <input type="date" size="12" id="fecham"><br><br>
  
  <hr>
  
  Nombre del tutor: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="nombret"><br><br>
  Estudios: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="estt"> <br><br>
  Ocupaci&oacute;n: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="60" id="ocut"><br><br>
  Fecha de nacimiento: &nbsp; <input type="date" size="12" id="fechat"><br><br>
</fieldset>
<br>
<!-- 
<fieldset>
 <legend>Escolar</legend>
 No. Control: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="20" id="numcon"> &nbsp;&nbsp;&nbsp;&nbsp;
     Grado: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="20" id="grado"> &nbsp;&nbsp;&nbsp;&nbsp;
     Grupo: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="20" id="grupo"> &nbsp;&nbsp;&nbsp;&nbsp;
     Turno: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="20" id="turno"> &nbsp;&nbsp;&nbsp;&nbsp;
     <br>
	 Es Repetidor: &nbsp;&nbsp;&nbsp; <input type="radio" name = "si"  id="si "checked>S&iacute;&nbsp;&nbsp;<input type="radio" name = "si" id="no">No 
 <br><br>
 <fieldset>
	<legend>Promedio</legend>
	Elige el grado: &nbsp;&nbsp;<select id="gradoelegido">
		<option value="Primero">Primero</option>
		<option value="Segundo">Segundo</option>
		<option value="Tercero">Tercero</option>
		<option value="Cuarto">Cuarto</option>
		<option value="Quinto">Quinto</option>
		<option value="Sexto">Sexto</option>
		</select> &nbsp;&nbsp;&nbsp;&nbsp;
		Promedio del Grado: &nbsp;&nbsp;&nbsp;<input type="text" size="5" id="promedio"> &nbsp;&nbsp;&nbsp;&nbsp;
		Promedio Global: &nbsp;&nbsp;&nbsp;<input type="text" size="5" id="promediog">
</fieldset>
<br>
<fieldset>
	<legend>Asesor</legend>
<center>
<p id="asesor">Oscar Mart&iacute;n Silva Compar&aacute;n</p>
</center>
</fieldset>
-->
</div>
</div>
</form>
</main>
</body>