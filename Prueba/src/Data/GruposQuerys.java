package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

import Objects.Grupo;
import Objects.Materia;
import Objects.Opcion;
import java.util.*;

public class GruposQuerys
{

	public GruposQuerys()
	{
		// TODO Auto-generated constructor stub
	}

	public String consultaGrupos()
	{
		String sql = "SELECT gru.idGrupo, gru.nombre, gra.descripcion grado, gru.salon, gru.turno, gru.descripcion"
				+ " FROM grupos gru, grados gra where gru.estatus = 'A' and gra.idGrado = gru.idGrupo;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("idGrupo", rs.getInt("idGrupo"));
				json.put("nombre", rs.getString("nombre"));
				json.put("grado", rs.getString("grado"));
				json.put("salon", rs.getString("salon"));
				json.put("turno", rs.getString("turno"));
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
	
	public String consultaGrados()
	{
		String sql = "SELECT idGrado, descripcion FROM grados where estatus = 'A';";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
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
	
	public boolean quitarGrupo(String nombre)
	{
		boolean estatus = false;
		String sql = "update grupos set estatus = 'B' where nombre = ?;";
		
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
	
	public boolean insertar(Grupo g)
	{
		String query = "INSERT INTO `grupos`(`idGrupo`, `nombre`, `idGrado`, `salon`, `turno`, `descripcion`, `estatus`) VALUES (null, ?, ?, ?, ?, ?, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setString(1, g.getNombre());
			ps.setInt(2, g.getIdGrado());
			ps.setString(3, g.getSalon());
			ps.setString(4, g.getTurno());
			ps.setString(5, g.getDescripcion());
			ps.setString(6, g.getEstatus());
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
	
	public boolean actualizar(Grupo g)
	{
		String query = "update grupos set nombre = '" + g.getNombre() + "', descripcion = '" + g.getDescripcion()
				+ "', idGrado = "+g.getIdGrado()+", salon = '"+g.getSalon()+"', turno = '"+g.getTurno()+"' " + "where idGrupo = " + g.getIdGrupo();
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
	
	public String ci(int id)
	{
		String sql = "SELECT * FROM grupos where estatus = 'A' and idGrupo = "+id+";";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("idGrupo", rs.getString("idGrupo"));
				json.put("nombre", rs.getString("nombre"));
				json.put("idGrado", rs.getString("idGrado"));
				json.put("descripcion", rs.getString("descripcion"));
				json.put("salon", rs.getString("salon"));
				json.put("turno", rs.getString("turno"));
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
}
