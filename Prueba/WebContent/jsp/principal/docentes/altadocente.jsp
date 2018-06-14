<script type="text/javascript" src="/Prueba/js/docentes/alta.js">
</script>
<body>
<main id = "main" class = "main1">
<form action="Docentes?op=i" method="post">
<div> 
 <fieldset>
    <legend>Datos Personales</legend>
    Nombre:* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="80" name = "nom" id="nombre" required><br><br>
    Fecha de nacimiento:* &nbsp;&nbsp;<input type="date" value="AAAA-MM-DD" size="12" id="fecha" name = "fecha" required> 
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;Sexo:* &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name = "sexo" id="h" value = "H" checked>H&nbsp;<input type="radio" value = "M" name = "sexo" id="m">M<br><br>
	Tel&eacute;fonos de Emergencia: <br><br>
	Tel&eacute;fono #1:* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name = "tel1" pattern="[0-9]{10}" placeholder="Ejemplo: 1234567890" type="text" size="24" id="tel1" required> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tel&eacute;fono #2:* &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="24" id="tel2" name = "tel2" pattern="[0-9]{10}" placeholder="Ejemplo: 1234567890" required><br><br>
	Domicilio:* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name = "dom" type="text" size="80" id="domicilio" required><br><br>
 </fieldset>
 <br><br>
 <fieldset>
 <legend>Datos de Inicio de Sesi&oacute;n</legend>
 <br>
 <center>
 <img id="imagen" src="/Prueba/imagenes/user_1.png">
 <br>
 <input type="file" id="fileInput">
 </center>
 <br>
    Nombre de Usuario:* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name = "nomu" type="text" size="20" id="usuario" pattern="[\w]{1,20}" placeholder="Ejemplo: Molo_Oscar" required> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Nivel de usuario:*  &nbsp;&nbsp;<select name = "nivel" id="nivel">
  <option value="Do">Docente</option>
  </select> <br><br>
    Password:* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name = "passu" type="password" size="30" id="password" pattern="[\w]{1,20}" placeholder="Ejemplo: Molo_Oscar" required>&nbsp;&nbsp;&nbsp;&nbsp;   NIP:* &nbsp;&nbsp;&nbsp;<input name = "nip" type="text" size="34" id="nip" pattern="[\w]{6}" placeholder="Ejemplo: HMN98G" required><br><br>
 </fieldset>
  <br>
  <center>
  <img src="/Prueba/imagenes/guardar.png"><input type="submit" class = "btntrans" type="submit" value="Guardar">
  &nbsp;&nbsp;&nbsp;&nbsp;
  <button class = "btntrans" type="button" onclick="limpiar();"><img src="/Prueba/imagenes/cancelar.png">Cancelar</button>
  </center>
  <br>
</div>
</form>
</main>
</body>