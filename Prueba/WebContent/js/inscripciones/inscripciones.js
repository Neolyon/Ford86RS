function mostrar() 
{
	document.getElementById("panel").style.visibility = "visible";
}

function ocultar() 
{
	document.getElementById("panel").style.visibility = "hidden";
}

function nuevaInscripcion() 
{
	mostrar();
	limpiar();
}

function guardarInscripcion() 
{
	if (estanVacios() == false) 
	{
		alert('Se realizó la inscripción con éxito.');
		ocultar();
		limpiar();
	}
	else
	{
		alert('Existen campos sin completar...');
	}
}

function cancelarInscripcion() 
{
	ocultar();
	limpiar();
}

function limpiar() 
{
	document.getElementById("nombrea").value = "";
	document.getElementById("fechaa").value = "";
	document.getElementById("ha").checked = true;
	document.getElementById("curpa").value = "";
	document.getElementById("lugara").value = "";
	document.getElementById("tel1a").value = "";
	document.getElementById("tel2a").value = "";
	document.getElementById("domicilioa").value = "";
	document.getElementById("enfera").value = "";
	document.getElementById("nia").checked = true;
	document.getElementById("situaa").value = "";
	document.getElementById("nombrep").value = "";
	document.getElementById("estp").value = "";
	document.getElementById("ocup").value = "";
	document.getElementById("fechap").value = "";
	document.getElementById("nombrem").value = "";
	document.getElementById("estm").value = "";
	document.getElementById("ocum").value = "";
	document.getElementById("fecham").value = "";
	document.getElementById("nombret").value = "";
	document.getElementById("estt").value = "";
	document.getElementById("ocut").value = "";
	document.getElementById("fechat").value = "";
	document.getElementById("ambos").checked = true;
}

function estanVacios() 
{
	var estado = true;
	if (document.getElementById("nombrea").value != '') 
	{
		if (document.getElementById("fechaa").value != '') 
		{
			if (document.getElementById("curpa").value != '') 
			{
				if (document.getElementById("lugara").value != '') 
				{
					if (document.getElementById("tel1a").value != '') 
					{
						if (document.getElementById("tel2a").value != '') 
						{
							if (document.getElementById("domicilioa").value != '') 
							{
								if (document.getElementById("enfera").value != '') 
								{
									if (document.getElementById("situaa").value != '') 
									{
										if (document.getElementById("nombrep").value != '') 
										{
											if (document.getElementById("estp").value != '') 
											{
												if (document.getElementById("ocup").value != '') 
												{
													if (document.getElementById("fechap").value != '') 
													{
														if (document.getElementById("nombrem").value != '') 
														{
															if (document.getElementById("estm").value != '') 
															{
																if (document.getElementById("ocum").value != '') 
																{
																	if (document.getElementById("fecham").value != '') 
																	{
																		if (document.getElementById("nombret").value != '') 
																		{
																			if (document.getElementById("estt").value != '') 
																			{
																				if (document.getElementById("ocut").value != '') 
																				{
																					if (document.getElementById("fechat").value != '') 
																					{
																						estado = false;
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	return estado;
}

function OcularTodo()
{
	document.getElementById("btnn").style.visibility = "visible";
	document.getElementById("btng").style.visibility = "hidden";
	document.getElementById("btnc").style.visibility = "hidden";
	document.getElementById("btnl").style.visibility = "hidden";
}
function OcularNuevo()
{
	document.getElementById("btnn").style.visibility = "hidden";
	document.getElementById("btng").style.visibility = "visible";
	document.getElementById("btnc").style.visibility = "visible";
	document.getElementById("btnl").style.visibility = "visible";
}