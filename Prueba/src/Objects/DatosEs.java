package Objects;

public class DatosEs
{ 
	int idDatoEscolar;
	int idCiclo;
	int idAlumno;
	int idDocente;
	int idParcial;
	int idCalificacionGlobal;
	String estaRepitiendo;
	String estadoEscolar;
	String estatus;
	public int getIdDatoEscolar()
	{
		return idDatoEscolar;
	}
	public void setIdDatoEscolar(int idDatoEscolar)
	{
		this.idDatoEscolar = idDatoEscolar;
	}
	public int getIdCiclo()
	{
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo)
	{
		this.idCiclo = idCiclo;
	}
	public int getIdAlumno()
	{
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno)
	{
		this.idAlumno = idAlumno;
	}
	public int getIdDocente()
	{
		return idDocente;
	}
	public void setIdDocente(int idDocente)
	{
		this.idDocente = idDocente;
	}
	public int getIdParcial()
	{
		return idParcial;
	}
	public void setIdParcial(int idParcial)
	{
		this.idParcial = idParcial;
	}
	public int getIdCalificacionGlobal()
	{
		return idCalificacionGlobal;
	}
	public void setIdCalificacionGlobal(int idCalificacionGlobal)
	{
		this.idCalificacionGlobal = idCalificacionGlobal;
	}
	public String getEstaRepitiendo()
	{
		return estaRepitiendo;
	}
	public void setEstaRepitiendo(String estaRepitiendo)
	{
		this.estaRepitiendo = estaRepitiendo;
	}
	public String getEstadoEscolar()
	{
		return estadoEscolar;
	}
	public void setEstadoEscolar(String estadoEscolar)
	{
		this.estadoEscolar = estadoEscolar;
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
		return "DatosEs [idDatoEscolar=" + idDatoEscolar + ", idCiclo=" + idCiclo + ", idAlumno=" + idAlumno
				+ ", idDocente=" + idDocente + ", idParcial=" + idParcial + ", idCalificacionGlobal="
				+ idCalificacionGlobal + ", estaRepitiendo=" + estaRepitiendo + ", estadoEscolar=" + estadoEscolar
				+ ", estatus=" + estatus + "]";
	}
}
