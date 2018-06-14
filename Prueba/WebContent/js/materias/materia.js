function ocultarMenu() 
{
	document.getElementById("menu").style.visibility = "hidden";
}

function mostrarMenu() 
{
	document.getElementById("menu").style.visibility = "visible";
}

function ocultar1() 
{
	document.getElementById("pinsertar").style.visibility = "hidden";
}

function mostrar1() 
{
	document.getElementById("pinsertar").style.visibility = "visible";
}

function ocultar2() 
{
	document.getElementById("peditar").style.visibility = "hidden";
}

function mostrar2() 
{
	document.getElementById("peditar").style.visibility = "visible";
}

function camdes() 
{
	var en = document.getElementById('entrada');
	
	if (en.value.length >= 10) 
	{
		var entrada = en.value.split('');
		entrada.pop();
		en.value = entrada.join("");
	}
}

function limpiar1() 
{
	document.getElementById("nom1").value = "";
	document.getElementById("desc1").value = "";
	document.getElementById("idg1").index = 0;
	document.getElementById("imagenm1").src = "/Prueba/imagenes/imagenpredeterminada.png"; 
}

function limpiar2() 
{
	document.getElementById("nom2").value = "";
	document.getElementById("desc2").value = "";
	document.getElementById("idg2").index = 0;
	document.getElementById("imagenm2").src = "/Prueba/imagenes/imagenpredeterminada.png"; 
}

function limpiarT() 
{
	document.getElementById("entra").value = "";

}

function camdest() 
{
	var en = document.getElementById('entra');
	
	if (en.value.length >= 20) 
	{
		var entrada = en.value.split('');
		entrada.pop();
		en.value = entrada.join("");
	}
}

function guardar() 
{
	document.getElementById("panel").style.visibility = "hidden";
	limpiar();
	alert('Se guardo con éxito.');
}

function eliminar() 
{
	var tabla = document.getElementById('tabla');
	
	var c = document.createElement('input');
	c.type = 'checkbox';
	c.id = 'e';
	var cnombre = document.createTextNode('Eliminar');
	c.appendChild(cnombre);
	var tr = document.createElement('tr');
	var td = document.createElement('td');
	td.appendChild(c);
	tr.appendChild(td);
	tabla.appendChild(tr);
}

function imagen1() 
{
	var fileInput = document.getElementById('fi1');

	fileInput.addEventListener('change', function(e) {
		var file = fileInput.files[0];
		var imageType = /image.*/;

		if (file.type.match(imageType)) {
			var reader = new FileReader();

			reader.onload = function(e) {

				var img = new Image();
				img.src = reader.result;
				

				document.getElementById('imagenm1').src = img.src;
				document.getElementById("imagenm1").width = '150';
				document.getElementById("imagenm1").height = '150';
				document.getElementById('fi1').value = "";
			}

			reader.readAsDataURL(file);	
		} else {
			fileDisplayArea.innerHTML = "File not supported!"
		}
	});

}

function OcularTodo()
{
	document.getElementById("btnnn").style.visibility = "hidden";
	document.getElementById("btnen").style.visibility = "hidden";
	document.getElementById("btnbn").style.visibility = "hidden";
}

function OcultarCanf()
{
	document.getElementById("canf").style.visibility = "hidden";
}

function MostrarCanf()
{
	document.getElementById("canf").style.visibility = "visible";
}

function MostrarTodo()
{
	document.getElementById("btnnn").style.visibility = "visible";
	document.getElementById("btnen").style.visibility = "visible";
	document.getElementById("btnbn").style.visibility = "visible";
}