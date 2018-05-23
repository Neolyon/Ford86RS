function limpiar() 
{
	document.getElementById("nombre").value = "";
	document.getElementById("fecha").value = "";
	document.getElementById("h").checked = true;
	document.getElementById("tel1").value = "";
	document.getElementById("tel2").value = "";
	document.getElementById("domicilio").value = "";
	document.getElementById("usuario").value = "";
	document.getElementById("password").value = "";
	document.getElementById("nip").value = "";
	document.getElementById("nivel").selectedIndex = "0";
	document.getElementById("imagen").src = "/Prueba/imagenes/user_1.png"; 
	document.getElementById('fileInput').value = '';
}

function guardar() 
{
	limpiar();
	alert('Se agrego el docente correctamente.');
}

window.onload = function() {

	var fileInput = document.getElementById('fileInput');


	fileInput.addEventListener('change', function(e) {
		var file = fileInput.files[0];
		var imageType = /image.*/;

		if (file.type.match(imageType)) {
			var reader = new FileReader();

			reader.onload = function(e) {

				var img = new Image();
				img.src = reader.result;

				document.getElementById('imagen').src = img.src;
				document.getElementById("imagen").width = '150';
				document.getElementById("imagen").height = '150';
				
			}

			reader.readAsDataURL(file);	
		} else {
			fileDisplayArea.innerHTML = "File not supported!"
		}
	});

}