package Objects;

public class InfoDocente
{
	int idInfoDocente;
	String nombre;
	String fechaNacimiento;
	String sexo;
	String telefono1;
	String telefono2;
	String domicilio;
	String estatus;
	public int getIdInfoDocente()
	{
		return idInfoDocente;
	}
	public void setIdInfoDocente(int idInfoDocente)
	{
		this.idInfoDocente = idInfoDocente;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getFechaNacimiento()
	{
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo()
	{
		return sexo;
	}
	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}
	public String getTelefono1()
	{
		return telefono1;
	}
	public void setTelefono1(String telefono1)
	{
		this.telefono1 = telefono1;
	}
	public String getTelefono2()
	{
		return telefono2;
	}
	public void setTelefono2(String telefono2)
	{
		this.telefono2 = telefono2;
	}
	public String getDomicilio()
	{
		return domicilio;
	}
	public void setDomicilio(String domicilio)
	{
		this.domicilio = domicilio;
	}
	public String getEstatus()
	{
		return estatus;
	}
	public void setEstatus(String estatus)
	{
		this.estatus = estatus;
	}
	@Override
	public String toString()
	{
		return "InfoDocente [idInfoDocente=" + idInfoDocente + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", sexo=" + sexo + ", telefono1=" + telefono1 + ", telefono2=" + telefono2
				+ ", domicilio=" + domicilio + ", estatus=" + estatus + "]";
	}
}
