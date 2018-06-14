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

function consultarAlumno(nc)
{
	XMLHttpRequest 
	ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			infoConsultada(this.responseText);
		}
	};
	
	ajax.open("get", "Alumnos?op=ca&nc="+nc, true);
	ajax.send();
}

function infoConsultada(datos) 
{
	var array = eval(datos);
	document.getElementById('nombrea').value = array[0].nomA;
	document.getElementById('curpa').value = array[0].curpA;
	document.getElementById('lugara').value = array[0].lugarA;
	document.getElementById('fechaa').value = array[0].fechaA;
	document.getElementById('domicilioa').value = array[0].domA;
	document.getElementById('tel1a').value = array[0].tel1A;
	document.getElementById('tel2a').value = array[0].tel2A;
	document.getElementById('asesora').value = array[0].nomD;
	document.getElementById('gradoa').value = array[0].graA;
	document.getElementById('grupoa').value = array[0].gruA;
	document.getElementById('asesorasig').value = array[0].nomND;
	document.getElementById('gradoc').value = array[0].graN;
	document.getElementById('grupoc').value = array[0].gruN;
	document.getElementById('turnoc').value = array[0].turN;
}