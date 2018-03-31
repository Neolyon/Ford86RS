var estado = 0;
var estadoins = 0;
var estadorei = 0;
var estadoalu = 0;
var estadodoc = 0;

function clikeobtnnav()
{	
	var e = document.getElementById('sidebar');
	var m = document.getElementById('main');
	var e1 = document.getElementById('1');
	var e2 = document.getElementById('2');
	var e3 = document.getElementById('3');
	var e4 = document.getElementById('4');
	var e5 = document.getElementById('5');
	var e6 = document.getElementById('6');
	var e7 = document.getElementById('7');
	if (estado == 0) 
	{
		e.classList.toggle("active");
		e1.classList.toggle("pp");
		e2.classList.toggle("pp");
		e3.classList.toggle("pp");
		e4.classList.toggle("pp");
		e5.classList.toggle("pp");
		e6.classList.toggle("pp");
		e7.classList.toggle("pp");
		m.classList.toggle("main2");
	}
	else if (estado == 1) 
	{
		e.classList.toggle("sidebar");
		e1.classList.toggle("p");
		e2.classList.toggle("p");
		e3.classList.toggle("p");
		e4.classList.toggle("p");
		e5.classList.toggle("p");
		e6.classList.toggle("p");
		e7.classList.toggle("p");
		m.classList.toggle("main1");
		
		estado = 0;
	}
}

function subins()
{
	var e = document.getElementById('submenui');
	var b1 = document.getElementById('bi1');
	var b2 = document.getElementById('bi2');
	var b3 = document.getElementById('bi3');
	if (estadoins == 0) 
	{
		e.classList.toggle("subinsactive");
		b1.classList.toggle("uno");
		b2.classList.toggle("uno");
		b3.classList.toggle("uno");
	}
	else if (estadoins == 1) 
	{
		e.classList.toggle("subins");
		b1.classList.toggle("cero");
		b2.classList.toggle("cero");
		b3.classList.toggle("cero");
		estadoins = 0;
	}
}

function subrei()
{
	var e = document.getElementById('submenur');
	var b1 = document.getElementById('br1');
	var b2 = document.getElementById('br2');
	if (estadorei == 0) 
	{
		e.classList.toggle("subreiactive");
		b1.classList.toggle("uno");
		b2.classList.toggle("uno");
	}
	else if (estadorei == 1) 
	{
		e.classList.toggle("subrei");
		b1.classList.toggle("cero");
		b2.classList.toggle("cero");
		estadoins = 0;
	}
}

function subalu()
{
	var e = document.getElementById('submenua');
	var b1 = document.getElementById('ba1');
	var b2 = document.getElementById('ba2');
	if (estadoalu == 0) 
	{
		e.classList.toggle("subaluactive");
		b1.classList.toggle("uno");
		b2.classList.toggle("uno");
	}
	else if (estadoalu == 1) 
	{
		e.classList.toggle("subalu");
		b1.classList.toggle("cero");
		b2.classList.toggle("cero");
		estadoalu = 0;
	}
}

function subdoc()
{
	var e = document.getElementById('submenud');
	var b1 = document.getElementById('bd1');
	var b2 = document.getElementById('bd2');
	var b3 = document.getElementById('bd3');
	var b4 = document.getElementById('bd4');
	if (estadodoc == 0) 
	{
		e.classList.toggle("subdocactive");
		b1.classList.toggle("uno");
		b2.classList.toggle("uno");
		b3.classList.toggle("uno");
		b4.classList.toggle("uno");
	}
	else if (estadodoc == 1) 
	{
		e.classList.toggle("subdoc");
		b1.classList.toggle("cero");
		b2.classList.toggle("cero");
		b3.classList.toggle("cero");
		b4.classList.toggle("cero");
		estadodoc = 0;
	}
}

/*
 * var ei = document.getElementById('submenui');
	var bi1 = document.getElementById('bi1');
	var bi2 = document.getElementById('bi2');
	var bi3 = document.getElementById('bi3');
	
	var er = document.getElementById('submenur');
	var br1 = document.getElementById('br1');
	var br2 = document.getElementById('br2');
	
	var ea = document.getElementById('submenua');
	var ba1 = document.getElementById('ba1');
	var ba2 = document.getElementById('ba2');
	
	var ed = document.getElementById('submenud');
	var bd1 = document.getElementById('bd1');
	var bd2 = document.getElementById('bd2');
	var bd3 = document.getElementById('bd3');
	var bd4 = document.getElementById('bd4');
	
	ei.classList.toggle("subins");
	bi1.classList.toggle("cero");
	bi2.classList.toggle("cero");
	bi3.classList.toggle("cero");
	er.classList.toggle("subrei");
	br1.classList.toggle("cero");
	br2.classList.toggle("cero");
	ea.classList.toggle("subalu");
	ba1.classList.toggle("cero");
	ba2.classList.toggle("cero");
	ed.classList.toggle("subdoc");
	bd1.classList.toggle("cero");
	bd2.classList.toggle("cero");
	bd3.classList.toggle("cero");
	bd4.classList.toggle("cero");
 * 
 */