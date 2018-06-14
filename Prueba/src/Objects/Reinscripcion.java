package Objects;

public class Reinscripcion
{
	int idReinscripcion;
	int idAlumno;
	int idDatoEscolar;
	int idDocente;
	String recursaEsteGrado;
	String estatus;
	public int getIdReinscripcion()
	{
		return idReinscripcion;
	}
	public void setIdReinscripcion(int idReinscripcion)
	{
		this.idReinscripcion = idReinscripcion;
	}
	public int getIdAlumno()
	{
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno)
	{
		this.idAlumno = idAlumno;
	}
	public int getIdDatoEscolar()
	{
		return idDatoEscolar;
	}
	public void setIdDatoEscolar(int idDatoEscolar)
	{
		this.idDatoEscolar = idDatoEscolar;
	}
	public int getIdDocente()
	{
		return idDocente;
	}
	public void setIdDocente(int idDocente)
	{
		this.idDocente = idDocente;
	}
	public String getRecursaEsteGrado()
	{
		return recursaEsteGrado;
	}
	public void setRecursaEsteGrado(String recursaEsteGrado)
	{
		this.recursaEsteGrado = recursaEsteGrado;
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
		return "Reinscripcion [idReinscripcion=" + idReinscripcion + ", idAlumno=" + idAlumno + ", idDatoEscolar="
				+ idDatoEscolar + ", idDocente=" + idDocente + ", recursaEsteGrado=" + recursaEsteGrado + ", estatus=" + estatus + "]";
	}
	
}
