package Objects;

public class Alumno
{
	 int idAlumno;
	 String NoControl;
	 int idDatosAlumno;
	 String estatus;
	public int getIdAlumno()
	{
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno)
	{
		this.idAlumno = idAlumno;
	}
	public String getNoControl()
	{
		return NoControl;
	}
	public void setNoControl(String noControl)
	{
		NoControl = noControl;
	}
	public int getIdDatosAlumno()
	{
		return idDatosAlumno;
	}
	public void setIdDatosAlumno(int idDatosAlumno)
	{
		this.idDatosAlumno = idDatosAlumno;
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
		return "Alumno [idAlumno=" + idAlumno + ", NoControl=" + NoControl + ", idDatosAlumno=" + idDatosAlumno
				+ ", estatus=" + estatus + "]";
	}
}