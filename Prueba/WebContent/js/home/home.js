//function cerrarSesion() 
//{
//	if (confirm('¿Deseas cerrar sesión?')) 
//	{
//		location.href = '/Prueba/jsp/login/login.jsp';
//	}
//}

function salir() 
{
	if (confirm('¿Deseas salir?')) 
	{
		location.href = '/Prueba/jsp/principal/exit.jsp';
	}
}

function cerrarSesion() 
{
	if (confirm('¿Deseas cerrar sesión?')) 
	{
		XMLHttpRequest 
		ajax = new XMLHttpRequest();
		
		ajax.onreadystatechange = function() 
		{
			if (this.readyState == 4 && this.status == 200) 
			{
			}
		};
		
		ajax.open("get", "Sesion?op=cs", true);
		ajax.send();
	}
}

window.onload = function() {
	

//    let binary = new Uint8Array(json.message[0].partner_image)
//	let blob = new Blob([ binary ])
//	let img = new Image()
//	img.src = URL.createObjectURL(blob)

	var fileInput = document.getElementById('fileInput');


	fileInput.addEventListener('change', function(e) {
		alert(fileInput.value);
		var file = fileInput.files[0];
		var imageType = /image.*/;
		if (file.type.match(imageType)) {
			var reader = new FileReader();
			alert(reader.readAsDataURL(document.getElementById("fileInput").files[0]));
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