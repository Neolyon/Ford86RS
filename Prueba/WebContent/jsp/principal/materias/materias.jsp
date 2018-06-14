<script type="text/javascript" src="/Prueba/js/materias/materia.js">
</script>
<script type="text/javascript" src="/Prueba/js/AJAX/MateriasAJAX.js">
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo3.css">
<body onload="ocultar1(); ocultar2(); imagen1(); OcultarCanf(); generarTablaM();")>
<main id = "main" class = "main1">
<fieldset>
<legend>MENU</legend>
<fieldset style="width:70%">

<div class="menu5" id = "menu">
 <ul>
<button type="button" id="btnnn" class = "nuevo" onclick="mostrar1(); limpiar1(); ocultarMenu();">Nueva Materia</button>
<button type="button" id="btnen" class = "editar" onclick="editarMaterias(); ocultarMenu(); ">Editar Materia</button>
<button type="button" id="btnbn" class = "borrar" onclick="eliminarMaterias(); MostrarCanf(); ocultarMenu();">Eliminar Materia</button>
 </ul>
 </div>
 </fieldset>
</fieldset>
<br><br><br>








<div id = "pinsertar">
<form action="Materias?op=i" method="post">

<div id="panel">
<fieldset>
<legend>DATOS</legend>
<br>
 <br>
 <img id="imagenm1" src="/Prueba/imagenes/imagenpredeterminada.png">
 <br>
<input type="file" id = "fi1">
 <br>
NOMBRE DEL MATERIA:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input required="required" name = "nom1" id = "nom1" onkeypress="camdes();" size = "30"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</input>Grado:&nbsp;&nbsp;&nbsp;&nbsp;
<select required="required" name = "idg1" id = "idg1">
 <br> value="Primero">Primero</option>
		<option value="1">Primero</option>
		<option value="2">Segundo</option>
		<option value="3">Tercero</option>
		<option value="4">Cuarto</option>
		<option value="5">Quinto</option>
		<option value="6">Sexto</option>
		</select>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;DESCRIPCION  :   </input >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </input><br>
&nbsp;&nbsp;&nbsp;&nbsp;<textarea id="desc1" name = "desc1" rows="10" cols="50" required="required"></textarea>

<br>
<br>
<div class="menu6">
 <ul>
<input type="submit" class = "guardar" value="Guardar">
<button type="button" class = "cancelar" onclick="limpiar1(); ocultar1(); mostrarMenu();">Cancelar</button>
 </ul>
 </div>
 </fieldset>
</fieldset>
<br><br>
</div>
</form>
</div>






<div id = "peditar">
<form action="Materias?op=ed" method="post">
<input id = "idM" name = "idM" hidden="hidden">
<div id="panel">
<fieldset>
<legend>DATOS</legend>
<br>
 <br>
 <img id="imagenm2" src="/Prueba/imagenes/imagenpredeterminada.png">
 <br>
<input type="file" id = "fi2">
 <br>
NOMBRE DEL MATERIA:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input required="required" name = "nom2" id = "nom2" onkeypress="camdes();" size = "30"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</input>Grado:&nbsp;&nbsp;&nbsp;&nbsp;
<select required="required" name = "idg2" id = "idg2">
 <br> value="Primero">Primero</option>
		<option value="1">Primero</option>
		<option value="2">Segundo</option>
		<option value="3">Tercero</option>
		<option value="4">Cuarto</option>
		<option value="5">Quinto</option>
		<option value="6">Sexto</option>
		</select>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;DESCRIPCION  :   </input >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </input><br>
&nbsp;&nbsp;&nbsp;&nbsp;<textarea id="desc2" name = "desc2" rows="10" cols="50" required="required"></textarea>

<br>
<br>
<div class="menu6">
 <ul>
<input type="submit" class = "guardar" value="Guardar">
<button type="button" class = "cancelar" onclick="limpiar2(); ocultar2(); mostrarMenu();">Cancelar</button>
 </ul>
 </div>
 </fieldset>
</fieldset>
<br><br>
</div>
</form>
</div>









<fieldset>
<legend>INFORMACION DE LAS MATERIAS</legend>
<input type="button" id = "canf" class = "btn-danger" value="Cancelar La Eliminacion" onclick="OcultarCanf(); generarTablaM(); mostrarMenu();">
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
<br>
</main>
</body>