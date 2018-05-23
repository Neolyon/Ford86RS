function cerrarSesion() 
{
	if (confirm('¿Deseas cerrar sesión?')) 
	{
		location.href = '/Prueba/jsp/login/login.jsp';
	}
}

function salir() 
{
	if (confirm('¿Deseas salir?')) 
	{
		location.href = '/Prueba/jsp/principal/exit.jsp';
	}
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
				document.getElementById('fileInput').value = "";
			}

			reader.readAsDataURL(file);	
		} else {
			fileDisplayArea.innerHTML = "File not supported!"
		}
	});

}