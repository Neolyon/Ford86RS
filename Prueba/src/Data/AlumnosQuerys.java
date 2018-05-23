package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

import Objects.Opcion;
import java.util.*;

public class AlumnosQuerys
{

	public AlumnosQuerys()
	{
		// TODO Auto-generated constructor stub
	}

	public String consultaPorDocente(String idDocente)
	{
		String sql = "SELECT a.NoControl, da.nombre, da.fechaNacimiento, da.sexo FROM alumnos a, datosalumno da,"
				+ " datosescolares daes, docentes doce, cargosdocentes carg where doce.idDocente = "+idDocente+""
				+ " and carg.idCargoDocente = doce.idCargoDocente and daes.idDocente = doce.idDocente"
				+ " and daes.idCiclo = carg.idCiclo and a.idAlumno = daes.idAlumno and a.estatus = 'A'"
				+ " and da.idDatosAlumno = a.idDatosAlumno;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("NoControl", rs.getString("NoControl"));
				json.put("nombre", rs.getString("nombre"));
				json.put("fechaNacimiento", rs.getString("fechaNacimiento"));
				json.put("sexo", rs.getString("sexo"));
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
	
	public String consultaPorDocenteConCal(String idDocente)
	{
		String sql = "SELECT a.NoControl, da.sexo, daes.estaRepitiendo repitiendo, cg.promedioPrimero, cg.promedioSegundo,"
				+ " cg.promedioTercero, cg.promedioCuarto, cg.promedioQuintegero, cg.promedioSexto, gru.idGrado grado"
				+ " FROM alumnos a, datosalumno da, datosescolares daes, docentes doce, cargosdocentes carg,"
				+ " calificacionesglobal cg, grupos gru where doce.idDocente = "+idDocente+" and carg.idCargoDocente"
				+ " = doce.idCargoDocente and daes.idDocente = doce.idDocente and daes.idCiclo = carg.idCiclo"
				+ " and a.idAlumno = daes.idAlumno and a.estatus = 'A' and da.idDatosAlumno = a.idDatosAlumno"
				+ " and cg.idAlumno = a.idAlumno and gru.idGrupo = carg.idGrupo;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("NoControl", rs.getString("NoControl"));
				json.put("sexo", rs.getString("sexo"));
				json.put("repitiendo", rs.getString("repitiendo"));
				json.put("promedioPrimero", rs.getString("promedioPrimero"));
				json.put("promedioSegundo", rs.getString("promedioSegundo"));
				json.put("promedioTercero", rs.getString("promedioTercero"));
				json.put("promedioCuarto", rs.getString("promedioCuarto"));
				json.put("promedioQuinto", rs.getString("promedioQuintegero"));
				json.put("promedioSexto", rs.getString("promedioSexto"));
				json.put("grado", rs.getString("grado"));
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
	
	public String consultaCal(String nc)
	{
		String sql = "SELECT cg.promedioPrimero, cg.promedioSegundo, cg.promedioTercero, cg.promedioCuarto,"
				+ " cg.promedioQuintegero, cg.promedioSexto, cg.promedioGlobalPrimaria FROM"
				+ " calificacionesglobal cg, alumnos a WHERE a.NoControl = '"+nc+"' and cg.idAlumno = a.idAlumno;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();;
				json.put("promedioPrimero", rs.getString("promedioPrimero"));
				json.put("promedioSegundo", rs.getString("promedioSegundo"));
				json.put("promedioTercero", rs.getString("promedioTercero"));
				json.put("promedioCuarto", rs.getString("promedioCuarto"));
				json.put("promedioQuinto", rs.getString("promedioQuintegero"));
				json.put("promedioSexto", rs.getString("promedioSexto"));
				json.put("promedioGlobalPrimaria", rs.getString("promedioGlobalPrimaria"));
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

