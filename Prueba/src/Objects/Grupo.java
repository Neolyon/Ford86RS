package Objects;

public class Grupo
{
	int idGrupo;
	String nombre;
	int idGrado;
	String salon;
	String turno;
	String descripcion;
	String estatus;
	public int getIdGrupo()
	{
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo)
	{
		this.idGrupo = idGrupo;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public int getIdGrado()
	{
		return idGrado;
	}
	public void setIdGrado(int idGrado)
	{
		this.idGrado = idGrado;
	}
	public String getSalon()
	{
		return salon;
	}
	public void setSalon(String salon)
	{
		this.salon = salon;
	}
	public String getTurno()
	{
		return turno;
	}
	public void setTurno(String turno)
	{
		this.turno = turno;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
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
		return "Grupo [idGrupo=" + idGrupo + ", nombre=" + nombre + ", idGrado=" + idGrado + ", salon=" + salon
				+ ", turno=" + turno + ", descripcion=" + descripcion + ", estatus=" + estatus + "]";
	}
}
