package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

import Objects.Materia;
import Objects.Opcion;
import java.util.*;

public class MateriasQuerys
{

	public MateriasQuerys()
	{
		// TODO Auto-generated constructor stub
	}

	public String consultaMaterias()
	{
		String sql = "SELECT idMateria, nombre, idGrado, descripcion FROM materias where estatus = 'A';";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("idMateria", rs.getString("idMateria"));
				json.put("nombre", rs.getString("nombre"));
				json.put("idGrado", rs.getString("idGrado"));
				json.put("descripcion", rs.getString("descripcion"));
				array.add(json);
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}
		System.out.println(array.toString());
		return array.toString();
	}

	public boolean quitarMateria(String nombre)
	{
		boolean estatus = false;
		String sql = "update materias set estatus = 'B' where nombre = ?;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(sql);
			ps.setString(1, nombre);
			if (ps.executeUpdate() == 1)
			{
				estatus = true;
			}
			ps.close();
			con.close();
			
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta: \n" + e.getMessage());
		}
		return estatus;
	}
	
	public boolean insertar(Materia m)
	{
		String query = "INSERT INTO `materias`(`idMateria`, `nombre`, `idGrado`, `descripcion`, `imagen`, `estatus`) VALUES (null, ?, ?, ?, ?, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setString(1, m.getNombre());
			ps.setInt(2, m.getIdGrado());
			ps.setString(3, m.getDescripcion());
			ps.setBlob(4, m.getImagen());
			ps.setString(5, m.getEstatus());
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
	
	public String ci(int id)
	{
		String sql = "SELECT * FROM materias where estatus = 'A' and idMateria = "+id+";";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("idMateria", rs.getString("idMateria"));
				json.put("nombre", rs.getString("nombre"));
				json.put("idGrado", rs.getString("idGrado"));
				json.put("descripcion", rs.getString("descripcion"));
				array.add(json);
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}
		System.out.println(array.toString());
		return array.toString();
	}
	
	public boolean actualizar(Materia m)
	{
		String query = "update materias set nombre = '" + m.getNombre() + "', descripcion = '" + m.getDescripcion()
				+ "', idGrado = "+m.getIdGrado()+" " + "where idMateria = " + m.getIdMateria();
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
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
}
