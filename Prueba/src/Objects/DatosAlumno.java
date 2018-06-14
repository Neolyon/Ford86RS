package Objects;

public class DatosAlumno
{
	int idDatosAlumno;
	String nombre;
	String fechaNacimiento;
	String sexo;
	String curp;
	String lugarNacimiento;
	String telefono1;
	String telefono2;
	String domicilio;
	String enfermedades;
	String listaPadresTutores;
	String estatus;
	public int getIdDatosAlumno()
	{
		return idDatosAlumno;
	}
	public void setIdDatosAlumno(int idDatosAlumno)
	{
		this.idDatosAlumno = idDatosAlumno;
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
	public String getCurp()
	{
		return curp;
	}
	public void setCurp(String curp)
	{
		this.curp = curp;
	}
	public String getLugarNacimiento()
	{
		return lugarNacimiento;
	}
	public void setLugarNacimiento(String lugarNacimiento)
	{
		this.lugarNacimiento = lugarNacimiento;
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
	public String getEnfermedades()
	{
		return enfermedades;
	}
	public void setEnfermedades(String enfermedades)
	{
		this.enfermedades = enfermedades;
	}
	public String getListaPadresTutores()
	{
		return listaPadresTutores;
	}
	public void setListaPadresTutores(String listaPadresTutores)
	{
		this.listaPadresTutores = listaPadresTutores;
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
		return "DatosAlumno [idDatosAlumno=" + idDatosAlumno + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", sexo=" + sexo + ", curp=" + curp + ", lugarNacimiento=" + lugarNacimiento
				+ ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", domicilio=" + domicilio
				+ ", enfermedades=" + enfermedades + ", listaPadresTutores=" + listaPadresTutores + ", estatus="
				+ estatus + "]";
	}
}
