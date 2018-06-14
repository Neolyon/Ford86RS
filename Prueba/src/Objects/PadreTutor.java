package Objects;

public class PadreTutor
{ 
	int idPadreTutor;
	String nombre;
	String sexo;
	String fechaNacimiento;
	String estudios;
	String ocupacion;
	String estatus;
	public int getIdPadreTutor()
	{
		return idPadreTutor;
	}
	public void setIdPadreTutor(int idPadreTutor)
	{
		this.idPadreTutor = idPadreTutor;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getSexo()
	{
		return sexo;
	}
	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}
	public String getFechaNacimiento()
	{
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEstudios()
	{
		return estudios;
	}
	public void setEstudios(String estudios)
	{
		this.estudios = estudios;
	}
	public String getOcupacion()
	{
		return ocupacion;
	}
	public void setOcupacion(String ocupacion)
	{
		this.ocupacion = ocupacion;
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
		return "PadreTutor [idPadreTutor=" + idPadreTutor + ", nombre=" + nombre + ", sexo=" + sexo
				+ ", fechaNacimiento=" + fechaNacimiento + ", estudios=" + estudios + ", ocupacion=" + ocupacion
				+ ", estatus=" + estatus + "]";
	}
}
