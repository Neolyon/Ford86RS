<script type="text/javascript" src="/Prueba/js/grupos/grupo.js">
</script>
<script type="text/javascript" src="/Prueba/js/AJAX/GruposAJAX.js">
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo3.css">
<body onload="generarTablaG(); OcultarCan(); ocultar2(); ocultar1();">
<main id = "main" class = "main1">
<fieldset>
<legend>MENU</legend>
<fieldset style="width:70%">

<div class="menu5" id = "menu">
 <ul>
<button id = "btnn" class = "nuevo" onclick="mostrar1(); limpiar1(); ocultarMenu();">Nuevo Grupo</button>
<button id = "btne" class = "editar" onclick="editarGrupos(); ocultarMenu();">Editar Grupo</button>
<button id = "btnb" class = "borrar" onclick="eliminarTodosLosGrupos(); MostrarCan(); ocultarMenu();">Eliminar Grupo</button>
 </ul>
 </div>
</fieldset>









<form action="Grupos?op=i" method="post">
<div id = "pinsertar">
<div id="panel">
<fieldset>
<legend>Datos</legend>
<br>
Grado</input><select id = "idg1" name = "idg1">
 <br> value="Primero">Primero</option>
 		<option value="1">Primero</option>
		<option value="2">Segundo</option>
		<option value="3">Tercero</option>
		<option value="4">Cuarto</option>
		<option value="5">Quinto</option>
		<option value="6">Sexto</option>
		</select>
		
		Nombre del Grupo<input id= "nombre1" name = "nombre1" onkeypress="" size = "2" pattern="[A-Z]{1}" placeholder="Ej. A" required>

		
		Turno<input id= "turno1" name = "turno1"onkeypress="" size = "2" pattern="[M|V]{1}" placeholder="Ej. M"  required>

		Numero del Salon<input id= "salon1" name = "salon1" onkeypress="" size = "2" pattern="[0-9]{1,2}" placeholder="Ej. 1" required>
		
		Descripcion<input id= "desc1" name = "desc1" onkeypress="camdes();" size = "90" required>
		
		<br><br>
		<div class="menu6">
 <ul>
<input class = "guardar" type = "submit" value="Guardar">
<button class = "cancelar" onclick="mostrarMenu(); limpiar1(); ocultar1();">Cancelar</button>
 </ul>
 </div>
		</fieldset>
</div>
</div>
</form>









<div id = "peditar">
<form action="Grupos?op=ed" method="post">
<input id = "idG" name = "idG" hidden="hidden">
<div id="panel">
<fieldset>
<legend>Datos</legend>
<br>
Grado</input><select id = "idg2" name = "idg2">
 <br> value="Primero">Primero</option>
 		<option value="1">Primero</option>
		<option value="2">Segundo</option>
		<option value="3">Tercero</option>
		<option value="4">Cuarto</option>
		<option value="5">Quinto</option>
		<option value="6">Sexto</option>
		</select>
		
		Nombre del Grupo<input id= "nombre2" name = "nombre2" onkeypress="" size = "2" pattern="[A-Z]{1}" placeholder="Ej. A" required>

		
		Turno<input id= "turno2" name = "turno2"onkeypress="" size = "2" pattern="[M|V]{1}" placeholder="Ej. M"  required>

		Numero del Salon<input id= "salon2" name = "salon2" onkeypress="" size = "2" pattern="[0-9]{1,2}" placeholder="Ej. 1" required>
		
		Descripcion<input id= "desc2" name = "desc2" onkeypress="camdes();" size = "90" required>
		
		<br><br>
		<div class="menu6">
 <ul>
<input class = "guardar" type = "submit" value="Guardar">
<button class = "cancelar" onclick="mostrarMenu(); limpiar2(); ocultar2();">Cancelar</button>
 </ul>
 </div>
		</fieldset>
</div>
</form>
</div>

<fieldset>
<br><br>
<input type="button" id = "can" class = "btn-danger" value="Cancelar La Eliminacion" onclick="OcultarCan(); mostrarMenu(); generarTablaG();">
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
</main>
</body>