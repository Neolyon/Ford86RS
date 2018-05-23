<script type="text/javascript" src="/Prueba/js/inscripciones/inscripciones.js">
</script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/estilo.css">
<body onload="ocultar(); OcularTodo();">
<main id = "main" class = "main1">
<form action="#" method="post">
<div id="principal">		
							<legend>Menú</legend>
					
					
					<div class="menu">
							<ul>
								
								<button id="btnn" class="nueva" onclick="nuevaInscripcion(); OcularNuevo();">Nueva Inscripción</button>
								<input id="btng" type="submit" class="guardar" onclick="" value="Guardar Inscripción">
								<button id="btnc" class="cancelar" onclick="cancelarInscripcion(); OcularTodo();">Cancelar Inscripción</button>
								<button id="btnl" class="limpiar" onclick="limpiar();">Limpiar todos los Campos</button>
								
							</ul>
					</div>	
				
					<div class="info">
						<hr size=" "  width="1330" align="left">
					
							<ul>
						        <p>Informacion Extra</p>
								<p>Ciclo escolar:</p>
								<p>Grado:</p>
								<p>Grupo:</p>
								<p>Maestr@:</p>
							</ul>
					</div>
					
					<div id = "panel">
					<section class="cuadros"></section>
					
					<section class="datos">
					
					<section class="cuadros">
				     	<p>Datos de Inscripción</p>
						
						
							
							<table>
								
								<tr><td> Nombre del alumno: *</td> <td> <input type="text" id="nombrea" required></td> </tr>
								<tr><td> Fecha de nacimiento: *</td>  <td><input type="date" id="fechaa" required></td>  <td> Sexo: *</td> <td> <input type="radio" name = "sexo" id="ha" checked></td> <td> H</td> <td> <input type="radio" name = "sexo" id="ma"></td> <td> M</td>  </tr>
								<tr><td> CURP: *</td> <td> <input type="text" id="curpa" pattern="[A-Z]{4}[0-9]{6}[A-Z]{6}[0-9]{2}" placeholder="Ejemplo: MOLO960301HMNRNS05" required></td> </tr>
								<tr><td> Lugar de naciminento: * <br></td> <td> <input type="text" id="lugara" required></td> </tr>
							</table>
							<table>
							<br>
							<hr>
							<tr><td> Telefonos de Emergencia: *</td> </tr>
								<tr><td> Telefono #1: *</td> <td> <input type="text" id="tel1a" pattern="[0-9]{10}" placeholder="Ejemplo: 1234567890" required></td><td> Telefono #2: *</td> <td> <input type="text" id="tel2a" pattern="[0-9]{10}" placeholder="Ejemplo: 1234567890" required></td> </tr>
								<tr><td> Domicilio: *</td> <td> <input type="text" id="domicilioa" required></td> </tr>
								
							</table>
							<hr>
							
							<p>Enfermedades:</p>
									<textarea name="enfermedades" rows="4" cols="70" id = "enfera" required>  </textarea>
									<hr>
									<p>Situacion del alumno:*</p>
									
									<table>
								
							
								<tr><td> <input type="radio" name = "ingreso" id = "nia" checked></td> <td> Nuevo Ingreso</td> </tr>
								<tr><td> <input type="radio" name = "ingreso" id = "ra"></td> <td> Repetidor</td> </tr>
								
								
							</table>
							<p>Otras Situaciones:</p>
								<textarea name="situaciones" rows="4" cols="70" id = "situaa" required>  </textarea>
							
					</section>	
					
					<section class="cuadros2">
				     	<p>Datos del Padre</p>
						
						</table>
							
							<table>
								
								<tr><td> Nombre del padre: *</td> <td> <input type="text"id="nombrep" required></td> </tr>
								<tr><td> Estudios: *</td> <td> <input type="text" id="estp" required></td> </tr>
								<tr><td> Ocupación: *</td> <td> <input type="text" id="ocup" required></td> </tr>
								<tr><td> Fecha de nacimiento: *</td>  <td><input type="date" id="fechap" required></td></tr>

							<table>
							
							<hr>
							
								<p>Datos de la Madre</p>
						
						</table>
							
							<table>
								
								<tr><td> Nombre de la Madre: *</td> <td> <input type="text" id="nombrem" required></td> </tr>
								<tr><td> Estudios: *</td> <td> <input type="text" id="estm" required></td> </tr>
								<tr><td> Ocupación: *</td> <td> <input type="text" id="ocum" required></td> </tr>
								<tr><td> Fecha de nacimiento: *</td>  <td><input type="date" id="fecham" required></td></tr>

							<table>
							
							<hr>
								<p>Datos del Tutor </p>
						
						</table>
							
							<table>
								
								<tr><td> Nombre del Tutor: *</td> <td> <input type="text" id="nombret" required></td> </tr>
								<tr><td> Estudios: *</td> <td> <input type="text" id="estt" required></td> </tr>
								<tr><td> Ocupación: *</td> <td> <input type="text" id="ocut" required></td> </tr>
								<tr><td> Fecha de nacimiento: *</td>  <td><input type="date" id="fechat" required></td></tr>

							<table>
							<hr>
							
								<p>Situación familiar  del alumno:*</p>
									
									<table>
								
							
								<tr><td> <input type="radio" name = "vivecon" id="ambos" checked></td> <td> Vive con ambos Padres</td> <td> <input type="radio" name = "vivecon" id="madre"></td> <td> Vive con su Madre</td> </tr>
								<tr><td> <input type="radio" name = "vivecon" id="padre"></td> <td>Vive con su Padre</td> <td> <input type="radio" name = "vivecon" id="tutor"></td> <td>Vive con Tutor</td> </tr>
								
								
							</table>

									
							
					</section>	
				
					
					</section>
					</div>
			</div>
					</form>
</main>
</body>