<script type="text/javascript" src="/Prueba/js/materias/materia.js">
</script>
<script type="text/javascript" src="/Prueba/js/AJAX/MateriasAJAX.js">
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo3.css">
<body onload="generarTablaM(); ocultar(); OcultarCanf(); imagen();")>
<main id = "main" class = "main1">
<form action="#" method="post">
<fieldset>
<legend>MENU</legend>
<fieldset style="width:70%">

<div class="menu5">
 <ul>
<button type="button" id="btnnn" class = "nuevo" onclick="mostrar(); OcularTodo(); limpiar();">Nueva Materia</button>
<button type="button" id="btnen" class = "editar" onclick="mostrar(); OcularTodo(); limpiar();">Editar Materia</button>
<button type="button" id="btnbn" class = "borrar" onclick="eliminarMaterias(); OcularTodo(); MostrarCanf();">Eliminar Materia</button>
 </ul>
 </div>
 </fieldset>
</fieldset>
<br><br><br>


<div id="panel">
<fieldset>
<legend>DATOS</legend>
<br>
 <br>
 <img id="imagenm" src="/Prueba/imagenes/imagenpredeterminada.png">
 <br>
<input type="file" id = "fi">
 <br>
NOMBRE DEL MATERIA:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input required="required" id= "entrada" onkeypress="camdes();" size = "30"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</input>Grado:&nbsp;&nbsp;&nbsp;&nbsp;
<select required="required">
 <br> value="Primero">Primero</option>
		<option value="Primero">Primero</option>
		<option value="Segundo">Segundo</option>
		<option value="Tercero">Tercero</option>
		<option value="Cuarto">Cuarto</option>
		<option value="Quinto">Quinto</option>
		<option value="Sexto">Sexto</option>
		</select>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;DESCRIPCION  :   </input >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </input><br>
&nbsp;&nbsp;&nbsp;&nbsp;<textarea id="texta" rows="10" cols="50" required="required"></textarea>

<br>
<br>
<div class="menu6">
 <ul>
<input type="submit" class = "guardar" value="Guardar">
<button type="button" class = "cancelar" onclick="ocultar(); MostrarTodo(); limpiar();">Cancelar</button>
 </ul>
 </div>
 </fieldset>
</fieldset>
<br><br>
</div>
<fieldset>
<legend>INFORMACION DE LAS MATERIAS</legend>
<input type="button" id = "canf" class = "btn-danger" value="Cancelar La Eliminacion" onclick="OcultarCanf(); MostrarTodo(); generarTablaM();">
<table style="width:100%" border=2px id="tabla">
  <tr>
  <th></th>
    <th>Nombre</th>
    <th>Grado</th>
	<th>Descripcion</th>
  </tr>
</table> 
</fieldset>
</fieldset>
</form>
</main>
</body>