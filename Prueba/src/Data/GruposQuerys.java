package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

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
		String sql = "SELECT gru.nombre, gra.descripcion grado, gru.salon, gru.turno, gru.descripcion"
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
}
