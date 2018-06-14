package Objects;

public class Cargo
{
	int idCargoDocente;
	int idGrupo;
	String listaMaterias;
	int idCiclo;
	String descripcion;
	String vigente;
	public int getIdCargoDocente()
	{
		return idCargoDocente;
	}
	public void setIdCargoDocente(int idCargoDocente)
	{
		this.idCargoDocente = idCargoDocente;
	}
	public int getIdGrupo()
	{
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo)
	{
		this.idGrupo = idGrupo;
	}
	public String getListaMaterias()
	{
		return listaMaterias;
	}
	public void setListaMaterias(String listaMaterias)
	{
		this.listaMaterias = listaMaterias;
	}
	public int getIdCiclo()
	{
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo)
	{
		this.idCiclo = idCiclo;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	public String getVigente()
	{
		return vigente;
	}
	public void setVigente(String vigente)
	{
		this.vigente = vigente;
	}
	@Override
	public String toString()
	{
		return "Cargo [idCargoDocente=" + idCargoDocente + ", idGrupo=" + idGrupo + ", listaMaterias=" + listaMaterias
				+ ", idCiclo=" + idCiclo + ", descripcion=" + descripcion + ", vigente=" + vigente + "]";
	}
}