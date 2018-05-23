<script type="text/javascript" src="/Prueba/js/grupos/grupo.js">
</script>
<script type="text/javascript" src="/Prueba/js/AJAX/GruposAJAX.js">
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo3.css">
<body onload="generarTablaG(); ocultar(); OcultarCan();">
<main id = "main" class = "main1">
<form action="#" method="post">
<fieldset>
<legend>MENU</legend>
<fieldset style="width:70%">

<div class="menu5">
 <ul>
<button id = "btnn" class = "nuevo" onclick="mostrar(); OcularTodo();">Nuevo Grupo</button>
<button id = "btne" class = "editar" onclick="mostrar(); OcularTodo();">Editar Grupo</button>
<button id = "btnb" class = "borrar" onclick="eliminarTodosLosGrupos(); MostrarCan(); OcularTodo();">Eliminar Grupo</button>
 </ul>
 </div>
</fieldset>

<div id="panel">
<fieldset>
<legend>Datos</legend>
<br>
Grado</input><select id = "grado">
 <br> value="Primero">Primero</option>
 		<option value="Primero">Primero</option>
		<option value="Segundo">Segundo</option>
		<option value="Tercero">Tercero</option>
		<option value="Cuarto">Cuarto</option>
		<option value="Quinto">Quinto</option>
		<option value="Sexto">Sexto</option>
		</select>
		
		Nombre del Grupo<input id= "nombre" onkeypress="" size = "2" pattern="[A-Z]{1}" placeholder="Ej. A" required>

		
		Turno<input id= "turno" onkeypress="" size = "2" pattern="[M|V]{1}" placeholder="Ej. M"  required>

		Numero del Salon<input id= "salon" onkeypress="" size = "2" pattern="[0-9]{1,2}" placeholder="Ej. 1" required>
		
		Descripcion<input id= "desc" onkeypress="camdes();" size = "90" required>
		
		<br><br>
		<div class="menu6">
 <ul>
<input class = "guardar" type = "submit" value="Guardar">
<button class = "cancelar" onclick="ocultar(); MostrarTodo();">Cancelar</button>
 </ul>
 </div>
		</fieldset>


</div>

<fieldset>
<br><br>
<input type="button" id = "can" class = "btn-danger" value="Cancelar La Eliminacion" onclick="OcultarCan(); MostrarTodo(); generarTablaG();">
<legend>INFORMACION</legend>
<table style="width:100%" border=2px id="tabla">
  <tr>
  <th></th>
    <th>Nombre</th>
    <th>Grado</th>
	<th>No. Salon</th>
	<th>Turno</th>
	<th>Descripcion</th>
  </tr>
</table> 
</fieldset>
</fieldset>
</form>
</main>
</body>