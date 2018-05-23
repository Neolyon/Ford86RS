function login()
{
	var usuario = document.getElementById('userName');
	var password = document.getElementById('userPassword');
	
	if (usuario.value != '')
	{
		if (password.value != '')
		{
			if (usuario.value.length <= 20)
			{
				if (password.value.length <= 20)
				{
					location.href = '/Prueba/jsp/principal/principal.jsp';
				}
				else
				{
					alert('El campo de password permite hasta 20 caracteres.');
				}
			}
			else
			{
				alert('El campo de usuario permite hasta 20 caracteres.');
			}
		}
		else
		{
			alert('El campo de password esta vacío.');
		}
	}
	else
	{
		alert('El campo de usuario esta vacío.');
	}
}

function recuperacion() 
{
	var nip = document.getElementById('nip');
	
	if (nip.value != '')
	{
		if (nip.value.length == 6)
		{
			alert("Se recupero tu información.");
		}
		else
		{
			alert('El campo de nip es de 6 digitos.');
		}
	}
	else
	{
		alert('El campo de nip esta vacío.');
	}
}