<script type="text/javascript" src="/Prueba/js/docentes/docentes.js">
</script>
<script type="text/javascript" src="/Prueba/js/AJAX/DocentesAJAX.js">
</script>
<body onload="mostrarDocentesDisponibles();">
<main id = "main" class = "main1">
<form action="Docentes?op=e" method="post">
<div> 
 <fieldset style="width:30%">
    <b>Elige el docente:* <b>&nbsp;&nbsp;&nbsp; <select id="combo" name = "nombre" required="required">
		</select>
		 <input class = "btntrans" type="submit" value = "Quitar"><img src="/Prueba/imagenes/guardar.png">
 </fieldset>
</div>
</form>
</main>
</body>