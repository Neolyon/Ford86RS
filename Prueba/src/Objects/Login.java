package Objects;

import java.sql.Blob;

public class Login
{
	int idLogin;
	String usuario;
	String pass;
	String nip;
	String nivel;
	Blob imagen;
	String estatus;
	
	public int getIdLogin()
	{
		return idLogin;
	}
	public void setIdLogin(int idLogin)
	{
		this.idLogin = idLogin;
	}
	public String getUsuario()
	{
		return usuario;
	}
	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}
	public String getPass()
	{
		return pass;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getNip()
	{
		return nip;
	}
	public void setNip(String nip)
	{
		this.nip = nip;
	}
	public String getNivel()
	{
		return nivel;
	}
	public void setNivel(String nivel)
	{
		this.nivel = nivel;
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
		return "Login [idLogin=" + idLogin + ", usuario=" + usuario + ", pass=" + pass + ", nip=" + nip + ", nivel="
				+ nivel + ", imagen=" + imagen + ", estatus=" + estatus + "]";
	}
}