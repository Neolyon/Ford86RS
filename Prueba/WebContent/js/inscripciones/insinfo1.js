function inicio() 
{
	var en = document.getElementById('entrada');
	
	if (en.value.length >= 60) 
	{
		var entrada = en.value.split('');
		entrada.pop();
		en.value = entrada.join("");
	}
}

function actualizarTabla()
{
	alert('Se ha actulizado la tabla.');
}