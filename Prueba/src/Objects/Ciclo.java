package Objects;

public class Ciclo
{
	int idCiclo;
	String nombre;
	String vigente;
	public int getIdCiclo()
	{
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo)
	{
		this.idCiclo = idCiclo;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
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
		return "Ciclo [idCiclo=" + idCiclo + ", nombre=" + nombre + ", vigente=" + vigente + "]";
	}
}
