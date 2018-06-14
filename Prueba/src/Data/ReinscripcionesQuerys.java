package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

import Objects.Alumno;
import Objects.DatosEs;
import Objects.Opcion;
import Objects.Reinscripcion;

import java.util.*;

public class ReinscripcionesQuerys
{

	public ReinscripcionesQuerys()
	{
		// TODO Auto-generated constructor stub
	}

	
	public String consultaTodasLasReinscripciones()
	{
		String sql = "SELECT DISTINCT alu.NoControl, reins.recursaEsteGrado recursara,"
				+ " ci.nombre nombreCiclo, gra.idGrado, gru.nombre nombreGrupo, gru.turno,"
				+ " indo.nombre nombreDocente, reins.idReinscripcion FROM reinscripciones reins, alumnos alu,"
				+ " datosescolares daes, docentes doce, cargosdocentes car, cicloescolar ci,"
				+ " infodocente indo, grados gra, grupos gru where reins.estatus = 'A' and alu.idAlumno = reins.idAlumno"
				+ " and daes.idAlumno = alu.idAlumno and ci.idCiclo = daes.idCiclo and"
				+ " doce.idDocente = reins.idDocente and car.idCargoDocente = doce.idCargoDocente"
				+ " and indo.idInfoDocente = doce.idInfoDocente and gru.idGrupo = car.idGrupo"
				+ " and gra.idGrado = gru.idGrado and ci.idCiclo = daes.idCiclo;";
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
				json.put("recursara", rs.getString("recursara"));
				json.put("nombreCiclo", rs.getInt("nombreCiclo"));
				json.put("idGrado", rs.getString("idGrado"));
				json.put("nombreGrupo", rs.getString("nombreGrupo"));
				json.put("turno", rs.getString("turno"));
				json.put("nombreDocente", rs.getString("nombreDocente"));
				json.put("idReinscripcion", rs.getString("idReinscripcion"));
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
	
	public boolean quitarReinscripcion(String id)
	{
		boolean estatus = false;
		String sql = "update reinscripciones set estatus = 'B' where idReinscripcion = ?;";
		
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
	
	public boolean actualizarDE(DatosEs daes)
	{
		boolean estatus = false;
		String sql = "update datosescolares set idCiclo = ?, idDocente = ?, idParcial = ?, idCalificacionGlobal = ?,"
				+ "estaRepitiendo = ?, estadoEscolar = ?, estatus = ?  where idDatoEscolar = ?;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(sql);
			ps.setInt(1, daes.getIdCiclo());
			ps.setInt(2, daes.getIdDocente());
			ps.setInt(3, daes.getIdParcial());
			ps.setInt(4, daes.getIdCalificacionGlobal());
			ps.setString(5, daes.getEstaRepitiendo());
			ps.setString(6, daes.getEstadoEscolar());
			ps.setString(7, daes.getEstatus());
			ps.setInt(8, daes.getIdDatoEscolar());
			if (ps.executeUpdate() == 1)
			{
				estatus = true;
			}
			System.out.println(">>>>>>>>> Dato escolar actualizado con exito");
			ps.close();
			con.close();
			
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta: \n" + e.getMessage());
		}
		return estatus;
	}
	
	public boolean insertar(Reinscripcion r)
	{
		String query = "INSERT INTO `reinscripciones`(`idReinscripcion`, `idAlumno`,"
				+ " `idDatoEscolar`, `idDocente`, `recursaEsteGrado`, `estatus`)"
				+ " VALUES (null, ?, ?, ?, ?, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setInt(1, r.getIdAlumno());
			ps.setInt(2, r.getIdDatoEscolar());
			ps.setInt(3, r.getIdDocente());
			ps.setString(4, r.getRecursaEsteGrado());
			ps.setString(5, r.getEstatus());
			ps.execute();
			ps.close();
			con.close();
			System.out.println(">>>>>>>>>>>> Reinscripcion insertado con exito");
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}
}
