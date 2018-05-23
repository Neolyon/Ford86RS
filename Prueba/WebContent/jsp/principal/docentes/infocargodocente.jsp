<scipt type="text/javascript" src="/Prueba/js/docentes/infocargo.js"></scipt>
<script type="text/javascript" src="/Prueba/js/AJAX/DocentesAJAX.js"></script>
<script type="text/javascript">
function OcultarCann()
{
	document.getElementById("cann").style.visibility = "hidden";
}

function MostrarCann()
{
	document.getElementById("cann").style.visibility = "visible";
}

function Oculto()
{
	document.getElementById("el").style.visibility = "hidden";
	document.getElementById("ac").style.visibility = "hidden";
}

function Mostrar()
{
	document.getElementById("el").style.visibility = "visible";
	document.getElementById("ac").style.visibility = "visible";
}
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo3.css">
<body onload="generarTablaCargo(); OcultarCann();">
<main id = "main" class = "main1">
<img alt="Imagen" src="/Prueba/imagenes/filtrar.png">Filtrar informacion por:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</input> 
<input type="radio" name = "filtro" checked>No Filtrar
 &nbsp;
 <input type="radio" name = "filtro">Clo. Escolar
 &nbsp;
 <input type="radio" name = "filtro">No. Docente
 &nbsp;
 <input type="radio" name = "filtro">Turno
 &nbsp;
 <input type="radio" name = "filtro">Materia
 <br> <br>
INGRESA EL DATO A BUSCAR: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input SIZE = "63" id="entrada" onkeypress="inicio();">
 <br> <br> <br> <br> 
<fieldset>
<legend>MENU</legend>
<fieldset style="width:70%">
<div class="menu4">
 <ul>
<button id="el" class = "borrar" onclick="eliminarCargos(); MostrarCann(); Oculto();">Eliminar Cargo</button>
<button id="ac" class = "actualizar" onclick="generarTablaCargo();">Actualizar Tabla</button>
 </ul>
 </div>
 </fieldset>
 
</fieldset>
<fieldset>
<legend>Informacion de cargos asignados.</legend>
<input type="button" id = "cann" class = "btn-danger" value="Cancelar La Eliminacion" onclick="OcultarCann(); generarTablaCargo(); Mostrar();">
<table style="width:100%" border=2px id="tabla">
  <tr>
  <th></th>
    <th>Ciclo Escolar</th>
    <th>Nombre de Docente</th>
	<th>Grado y Grupo</th>
	<th>Turno</th>
	<th>Materia</th>
  </tr>
</table> 
</fieldset>
</fieldset>
<br>
</main>
</body>