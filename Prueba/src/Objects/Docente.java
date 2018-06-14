package Objects;

public class Docente
{
	int idDocente;
	int idUsuario;
	int idInfoDocente;
	int idCargoDocente;
	String estatus;
	public int getIdDocente()
	{
		return idDocente;
	}
	public void setIdDocente(int idDocente)
	{
		this.idDocente = idDocente;
	}
	public int getIdUsuario()
	{
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario)
	{
		this.idUsuario = idUsuario;
	}
	public int getIdInfoDocente()
	{
		return idInfoDocente;
	}
	public void setIdInfoDocente(int idInfoDocente)
	{
		this.idInfoDocente = idInfoDocente;
	}
	public int getIdCargoDocente()
	{
		return idCargoDocente;
	}
	public void setIdCargoDocente(int idCargoDocente)
	{
		this.idCargoDocente = idCargoDocente;
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
		return "Docente [idDocente=" + idDocente + ", idUsuario=" + idUsuario + ", idInfoDocente=" + idInfoDocente
				+ ", idCargoDocente=" + idCargoDocente + ", estatus=" + estatus + "]";
	}
}
