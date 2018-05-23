function inicio() 
{
	var en = document.getElementById('entrada');
	
	if (en.value.length >= 5) 
	{
		var entrada = en.value.split('');
		entrada.pop();
		en.value = entrada.join("");
	}
}