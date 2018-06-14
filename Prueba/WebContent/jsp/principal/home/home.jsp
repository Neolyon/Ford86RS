<script type="text/javascript" src="/Prueba/js/home/home.js">
</script>
<!--  /Prueba/imagenes/user_1.png -->
<main id = "main" class = "main1">
<div class = "dbhomeuser">
<label>¡Bienvenid@ ${sesion.usuario}!</label>
<label>ID Docente ${docente.idDocente}</label>
<label>Nombre ${info.nombre}</label>
<label>ID Grupo ${cargo.idGrupo}</label>
 <img id="imagen" value = "${sesion.idLogin}" src="Sesion?op=im&id=${sesion.idLogin}" width="150" height="150">
 <br>
 <input name = "file" type="file" id="fileInput">
 <!-- <input type="submit" value="Guardar" class="btn-info"> -->
 <br>
</div>

<form action="Sesion?op=cs" method="post">
<div class = "dbhomeuser2">
<button type ="submit" class = "btntrans"><img src="/Prueba/imagenes/cerrarSesion.png">

<div class = "dlhomeuser">
<label>Cerrar Sesión</label>
</div>
</div>
</form>

<form action="Sesion?op=s" method="post">
<div class = "dbhomeuser3">
<button  type ="submit" class = "btntrans"><img src="/Prueba/imagenes/cerrarPrograma.png">

<div class = "dlhomeuser">
<label>Salir</label>
</div>
</div>
</form>
</main>