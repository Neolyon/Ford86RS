package Objects;

import java.sql.Blob;

public class Materia
{
	int idMateria;
	String nombre;
	int idGrado;
	String descripcion;
	Blob imagen;
	String estatus;
	public int getIdMateria()
	{
		return idMateria;
	}
	public void setIdMateria(int idMateria)
	{
		this.idMateria = idMateria;
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
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	public Blob getImagen()
	{
		return imagen;
	}
	public void setImagen(Blob imagen)
	{
		this.imagen = imagen;
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
		return "Materia [idMateria=" + idMateria + ", nombre=" + nombre + ", idGrado=" + idGrado + ", descripcion="
				+ descripcion + ", imagen=" + imagen + ", estatus=" + estatus + "]";
	}
}