package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;

import Objects.Ciclo;
import Objects.Login;
import Objects.Opcion;
import java.util.*;

public class SesionQuerys
{

	public SesionQuerys()
	{
		// TODO Auto-generated constructor stub
	}

	public String consultaGeneral()
	{
		String sql = "select * from logeo";
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("idLogin", rs.getInt("idLogin"));
				json.put("usuario", rs.getString("usuario"));
				json.put("pass", rs.getString("pass"));
				json.put("nip", rs.getString("nip"));
				json.put("nivel", rs.getString("nivel"));
				json.put("imagen", rs.getBlob("imagen"));
				json.put("estatus", rs.getString("estatus"));
				array.add(json);
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		System.out.println(array.toString());
		return array.toString();
	}

	public ArrayList<Login> consultaSesiones()
	{
		String sql = "select * from logeo";
		ArrayList<Login> array = new ArrayList<Login>();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				Login l = new Login();
				l.setIdLogin(rs.getInt("idLogin"));
				l.setUsuario(rs.getString("usuario"));
				l.setPass(rs.getString("pass"));
				l.setNip(rs.getString("nip"));
				l.setNivel(rs.getString("nivel"));
				l.setImagen(rs.getBlob("imagen"));
				l.setEstatus(rs.getString("estatus"));
				array.add(l);
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return array;
	}

	public boolean insertar(Login l)
	{
		String query = "insert into logeo values(?,?,?,?,?,?,?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setInt(1, l.getIdLogin());
			ps.setString(2, l.getUsuario());
			ps.setString(3, l.getPass());
			ps.setString(4, l.getNip());
			ps.setString(5, l.getNivel());
			ps.setBlob(6, l.getImagen());
			ps.setString(7, l.getEstatus());
			ps.execute();
			ps.close();
			con.close();
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}

	public boolean actualizar(Login l, int id)
	{
		String query = "update logeo set imagen = ? where idLogin = " + id;
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setBlob(1, l.getImagen());
			ps.execute();
			ps.close();
			con.close();
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}

	public Login ci(String u, String p)
	{
		Login l = null;
		String sql = "select * from logeo where usuario = '"+u+"' and pass = '"+p+"' and estatus = 'A'";
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				l = new Login();
				l.setIdLogin(rs.getInt("idLogin"));
				l.setUsuario(rs.getString("usuario"));
				l.setPass(rs.getString("pass"));
				l.setNip(rs.getString("nip"));
				l.setNivel(rs.getString("nivel"));
				l.setImagen(rs.getBlob("imagen"));
				l.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return l;
	}
	
	public Ciclo getCiclo(String dato)
	{
		Ciclo c = null;
		String sql = "select * from cicloescolar where vigente = 'A' and nombre = '"+dato+"'";
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				c = new Ciclo();
				c.setIdCiclo(rs.getInt("idCiclo"));
				c.setNombre(rs.getString("nombre"));
				c.setVigente(rs.getString("vigente"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return c;
	}
	
	public byte[] getImagen(String id)
	{
		String sql = "select imagen from logeo where idLogin = " + id;
		byte[] datos = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				datos = rs.getBytes("imagen");
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		
		return datos;
	}
	
	public void actualizarImagen(String id, InputStream inp)
	{
		System.out.println(inp.toString());
		String query = "update logeo set imagen = ? where idLogin = " + id;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setBlob(1, inp);
			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
	}
	
//	public byte[] getImagen(int id) throws Exception, SQLException
//	{
//
//		String req = "";
//		Blob img;
//		byte[] imgData = null;
//		ConnectionDB con = new ConnectionDB();
//		Statement stmt = con.get().createStatement();
//
//		// Query
//		req = "select imagen from logeo where idLogin = " + id;
//
//		ResultSet rset = stmt.executeQuery(req);
//
//		while (rset.next())
//		{
//			img = rset.getBlob(1);
//			imgData = img.getBytes(1, (int) img.length());
//		}
//
//		rset.close();
//		stmt.close();
//
//		return imgData;
//	}
}
