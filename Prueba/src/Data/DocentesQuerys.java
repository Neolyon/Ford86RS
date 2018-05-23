package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

import Objects.Opcion;
import java.util.*;

public class DocentesQuerys
{

	public DocentesQuerys()
	{
		// TODO Auto-generated constructor stub
	}

	public String consultaDocentes()
	{
		String sql = "SELECT doce.idDocente, indo.nombre FROM docentes doce, infodocente indo WHERE"
				+ " doce.estatus = 'A' and indo.idInfoDocente = doce.idInfoDocente and doce.idDocente != 1;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("idDocente", rs.getString("idDocente"));
				json.put("nombre", rs.getString("nombre"));
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
	
	public String consultaCargos()
	{
		String sql = "SELECT c.idCargoDocente, ci.nombre ciclo, info.nombre nombreDocente, gru.nombre nombreGrupo,"
				+ " gra.descripcion grado, gru.turno, c.listaMaterias FROM cargosdocentes c,"
				+ " docentes d, infodocente info, cicloescolar ci, grupos gru, grados gra WHERE"
				+ " ci.idCiclo = c.idCiclo and d.idCargoDocente = c.idCargoDocente and"
				+ " info.idInfoDocente = d.idInfoDocente and gru.idGrupo = c.idGrupo and"
				+ " gra.idGrado = gru.idGrado and c.vigente = 'A'";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("idCargoDocente", rs.getString("idCargoDocente"));
				json.put("ciclo", rs.getString("ciclo"));
				json.put("nombreDocente", rs.getString("nombreDocente"));
				json.put("nombreGrupo", rs.getString("nombreGrupo"));
				json.put("grado", rs.getString("grado"));
				json.put("turno", rs.getString("turno"));
				json.put("listaMaterias", rs.getString("listaMaterias"));
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
	
	public boolean quitarCargo(String id)
	{
		boolean estatus = false;
		String sql = "update cargosdocentes set vigente = 'B' where idCargoDocente = ?;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(sql);
			ps.setString(1, id);
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
