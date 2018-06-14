package Objects;

public class Inscripcion
{
	int idInscripciones;
	int idCiclo;
	int idDocentes;
	int idAlumno;
	String viveCon;
	String otrasSituaciones;
	String estatus;
	String situacionEscolar;
	public int getIdInscripciones()
	{
		return idInscripciones;
	}
	public void setIdInscripciones(int idInscripciones)
	{
		this.idInscripciones = idInscripciones;
	}
	public int getIdCiclo()
	{
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo)
	{
		this.idCiclo = idCiclo;
	}
	public int getIdDocentes()
	{
		return idDocentes;
	}
	public void setIdDocentes(int idDocentes)
	{
		this.idDocentes = idDocentes;
	}
	public int getIdAlumno()
	{
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno)
	{
		this.idAlumno = idAlumno;
	}
	public String getViveCon()
	{
		return viveCon;
	}
	public void setViveCon(String viveCon)
	{
		this.viveCon = viveCon;
	}
	public String getOtrasSituaciones()
	{
		return otrasSituaciones;
	}
	public void setOtrasSituaciones(String otrasSituaciones)
	{
		this.otrasSituaciones = otrasSituaciones;
	}
	public String getEstatus()
	{
		return estatus;
	}
	public void setEstatus(String estatus)
	{
		this.estatus = estatus;
	}
	public String getSituacionEscolar()
	{
		return situacionEscolar;
	}
	public void setSituacionEscolar(String situacionEscolar)
	{
		this.situacionEscolar = situacionEscolar;
	}
	@Override
	public String toString()
	{
		return "Inscripcion [idInscripciones=" + idInscripciones + ", idCiclo=" + idCiclo + ", idDocentes=" + idDocentes
				+ ", idAlumno=" + idAlumno + ", viveCon=" + viveCon + ", otrasSituaciones=" + otrasSituaciones
				+ ", estatus=" + estatus + ", situacionEscolar=" + situacionEscolar + "]";
	}
	
}