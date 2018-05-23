<script type="text/javascript" src="/Prueba/js/reinscripciones/reinscripciones.js">
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo3.css">
<body onload="ocultar(); OcularTodo();">
<main id = "main" class = "main1">
<form action="#" method="post">
<div id="principal">
							<legend>Menú</legend>
					
					
					<div class="menu">
							<ul>
								
								<button type="button" id="btnn" class="nueva" onclick="mostrarnc(); OcultarT();">Nueva Reinscripción</button>
								<input id="btng" type="submit" class="guardar" value="Guardar Reinscripción">
								<button type="button" id="btnc" class="cancelar" onclick="ocultar(); OcularTodo(); limpiar();">Cancelar Reinscripción</button>
								<!-- <button type="button" id="btnl" class="limpiar" onclick="limpiar();">Limpiar todos los Campos</button> -->
								
							</ul>
					</div>	
				
					<div id="nc">
					<div class="info">
						<hr size=" "  width="1330" align="left">
							<img src="/Prueba/imagenes/alumno.png">No. Control del alumno:  <td> <input id="numc" type="text" pattern="[0-9]{4}[A-Z]{2}[0-9]{4}" placeholder="Ejemplo: 2018MO0987"></td>
							<input type="button" class="btn-info" value="Cargar Alumno" onclick="validarNC();"><input type="button" class="btn-danger" value="Cancelar" onclick="limpiar(); OcularTodo(); ocultar();">
							
					</div>
					</div>
					
					<br><br><br>
					
					<div id="datos">
					<section class="datos">
					
					<fieldset>
					
						<legend>Datos personales</legend>
						
							<table>
								
								<tr><td> Nombre del alumno: *</td> <td> <input required="required" id="nombrea"  type="text"  size="50" readonly></td> <td> Sexo: *</td> <td> <input type="radio" name = "sexo" disabled='disabled'id="ha"  checked></td> <td> H</td> <td> <input type="radio" name = "sexo" id="ma"  disabled='disabled'></td> <td> M</td>  </tr>
								
							</table>
							
							<table>
								<tr> <td> CURP: *</td> <td> <input required="required" id="curpa"  type="text" size="50" readonly></td></tr>
								<tr><td> Lugar de naciminento: * <br></td> <td> <input required="required" id="lugara" type="text" size="50" readonly></td>  </tr>
								<tr><td> Fecha de nacimiento: *</td>  <td><input required="required" id="fechaa"  type="date" readonly></td> </tr>
								<tr><td> Domicilio: * <br></td> <td> <input required="required" id="domicilioa"  type="text" size="50" readonly></td>  </tr>

							</table>
							
							<table>
					
								<p> Telefonos de Emergencia:</p>
								<tr><td> Tel #1: * <br></td> <td> <input required="required" id="tel1a" type="text" size="50" readonly></td> <td> Tel #2: * <br></td> <td> <input required="required" id="tel2a" type="text" size="50" readonly></td>  </tr>
							
							</table>
					
					</fieldset>
					
					<br>
					
					<fieldset>
					
						<legend>Datos Académicos</legend>
						
						
							<table>
								<tr> <td> Asesor Anterior: *</td> <td> <input required="required" id="asesora" type="text" size="100" readonly></td></tr>
							</table>
							
							<table>
								<tr><td> Grado Anterior: * <br></td> <td> <input required="required" id="gradoa" type="text" size="5" readonly></td> 
								<td> Grupo Anterior: *</td>  <td><input required="required" type="text" id="grupoa"  size="5" readonly></td></tr>
								<tr><td> Promedio Anterior: *</td>  <td><input required="required" id="promedioa"  type="text" size="10" readonly></td> 
								<td> Promedio Global: *</td>  <td><input required="required" id="promediog"  type="text" size="10" readonly></td>
								<td></td><td> ¿Debe Recursar el Grado Anterior? </td>   <td> Si</td> <td> <input type="radio" name = "gradocursar" disabled='disabled'  id="si" checked></td> <td> No</td> <td> <input type="radio" name="gradocursar" id="no"  disabled='disabled'></td></tr>
							</table>

					</fieldset>
					
					<br>
					
					<fieldset>
					
						<legend>Solicitud</legend>
						
						
							<table>
								<tr> <td> Asesor Asignado: *</td> <td> <input id="asesorasig" type="split" size="100" readonly></td>
								<td></td><td> ¿Debe Recursar? </td>   <td> Si</td> <td> <input type="radio" name="gradorecursar"  disabled='disabled' id="sii"  checked></td> <td> No</td> <td> <input type="radio" type="radio" name = "gradorecursar" id="noo" disabled='disabled'></td></tr>
							</table>
							
							<table>
								<tr><td> Grado a Cursar: * <br></td> <td> <input id="gradoc" type="text" size="5" readonly></td> 
								<td> Grupo a Cursar: *</td>  <td><input id="grupoc"  type="text" size="5" readonly></td>
								<td> Turno Asignado: *</td>  <td><input id="turnoc"  type="text" size="5" readonly></td> </tr>
							</table>

					</fieldset>
					
					
					</section>
					</div>
			</div>
			</form>
</main>
</body>