<!-- Menu Lateral -->
<script src = "/Prueba/js/nav/animacion.js"></script>
<script src = "/Prueba/js/direccionamiento.js"></script>
<link rel="stylesheet" type="text/css" href="/Prueba/css/style4.css">
<nav id="sidebar">
	<!-- Boton del Menu -->
			<div>
				<button type="button" id="sidebarCollapse" class="boton" onclick="clikeobtnnav();"></button>
			</div>

	<!-- Botones del Menu -->
	<br>
	<br>
	<br>
	<div>
	<ul>
		<li>
		<a Class="navbar-btnhome" onclick="reenviar('/Prueba/Direccion?op=h');">
				<p id = "1" class="p">Inicio</p>
		</a>
		</li>
		
		
		<li>
		<a Class="navbar-btnin" onclick="subins();">
				<p id = "2" class="p">Inscripciones</p>
		</a> 
		<ul id = "submenui" class = "subins">
		<li><a Class="btnsubins"  onclick="reenviar('/Prueba/Direccion?op=ins1');"><p id = "bi1" class = "cero">Inscripciones</p></a></li>
		<li><a Class="btnsubins"  onclick="reenviar('/Prueba/Direccion?op=ins2');"><p id = "bi2" class = "cero">Ver Realizadas</p></a></li>
		<li><a Class="btnsubins"  onclick="reenviar('/Prueba/Direccion?op=ins3');"><p id = "bi3"  class = "cero">Ver Todas</p></a></li>
		</ul>
		</li>
		
		
		<li>
		<a Class="navbar-btnre" onclick="subrei();">
				<p id = "3" class="p">Reinscripciones</p>
		</a> 
		<ul id = "submenur" class = "subrei">
		<li><a Class="btnsubrei"  onclick="reenviar('/Prueba/Direccion?op=rei1');"><p id = "br1" class = "cero">Reinscripciones</p></a></li>
		<li><a Class="btnsubrei"  onclick="reenviar('/Prueba/Direccion?op=rei2');"><p id = "br2" class = "cero">Ver Todas</p></a></li>
		</ul>
		</li>
		
		
		<li>
		<a Class="navbar-btnal" onclick="subalu();">
				<p id = "4" class="p">Alumnos</p> 
		</a>
		<ul id = "submenua" class = "subalu">
		<li><a Class="btnsubalu"  onclick="reenviar('/Prueba/Direccion?op=alu1');"><p id = "ba1" class = "cero">Alumnos</p></a></li>
		<li><a Class="btnsubalu"  onclick="reenviar('/Prueba/Direccion?op=alu2');"><p id = "ba2" class = "cero">Operaciones</p></a></li>
		</ul>
		</li>
		
		
		<li>
		<a Class="navbar-btndo" onclick="subdoc();">
				<p id = "5" class="p">Docentes</p>
		</a> 
		<ul id = "submenud" class = "subdoc">
		<li><a Class="btnsubdoc"  onclick="reenviar('/Prueba/Direccion?op=doc1');"><p id = "bd1" class = "cero">Alta</p></a></li>
		<li><a Class="btnsubdoc"  onclick="reenviar('/Prueba/Direccion?op=doc2');"><p id = "bd2" class = "cero">Baja</p></a></li>
		<li><a Class="btnsubdoc"  onclick="reenviar('/Prueba/Direccion?op=doc3');"><p id = "bd3" class = "cero">Asignar Cargo</p></a></li>
		<li><a Class="btnsubdoc"  onclick="reenviar('/Prueba/Direccion?op=doc4');"><p id = "bd4" class = "cero">Info Cargo</p></a></li>
		</ul>
		</li>
		
		
		<li>
		<a Class="navbar-btngru" onclick="reenviar('/Prueba/Direccion?op=g');">
				<p id = "6" class="p">Grupos</p>
		</a> 
		</li>
		<li>
		<a Class="navbar-btnma" onclick="reenviar('/Prueba/Direccion?op=m');">
				<p id = "7" class="p">Materias</p>
		</a>
		</li>
	</ul>
	</div>
</nav>