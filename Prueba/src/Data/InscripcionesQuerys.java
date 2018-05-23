package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

import Objects.Opcion;
import java.util.*;

public class InscripcionesQuerys
{

	public InscripcionesQuerys()
	{
		// TODO Auto-generated constructor stub
	}

	public String consultaPorDocente(int idDocente)
	{
		String sql = "select a.idAlumno, a.NoControl, a.idDatosAlumno, a.estatus, da.nombre,"
				+ " da.fechaNacimiento, da.sexo, da.domicilio, da.telefono1, pt.nombre as nombreTutor, pt.ocupacion from alumnos a,"
				+ " datosalumno da, padrestutores pt, docentes doc, inscripciones ins "
				+ "where doc.idDocente = "+idDocente+" and ins.idDocente = doc.idDocente and "
						+ "a.idAlumno = ins.idAlumno and da.idDatosAlumno = a.idDatosAlumno and ins.estatus = 'A' and "
						+ "pt.idPadreTutor = SPLIT_STR(da.listaPadresTutores, ' ', 3);";
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("idAlumno", rs.getInt("idAlumno"));
				json.put("NoControl", rs.getString("NoControl"));
				json.put("idDatosAlumno", rs.getInt("idDatosAlumno"));
				json.put("estatus", rs.getString("estatus"));
				json.put("nombre", rs.getString("nombre"));
				json.put("fechaNacimiento", rs.getString("fechaNacimiento"));
				json.put("sexo", rs.getString("sexo"));
				json.put("domicilio", rs.getString("domicilio"));
				json.put("telefono1", rs.getString("telefono1"));
				json.put("nombreTutor", rs.getString("nombreTutor"));
				json.put("ocupacion", rs.getString("ocupacion"));
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
	
	public String consultaTodasLasInscripciones()
	{
		String sql = "select a.NoControl, da.nombre, gra.idGrado, gru.nombre as nombreGrupo, gru.turno,"
				+ " indo.nombre as nombreDocente from alumnos a, datosalumno da, docentes doc, inscripciones ins,"
				+ " cargosdocentes ca, infodocente indo, grupos gru, grados gra where doc.idDocente = ins.idDocente"
				+ " and a.idAlumno = ins.idAlumno and da.idDatosAlumno = a.idDatosAlumno and"
				+ " ca.idCargoDocente = doc.idCargoDocente and indo.idInfoDocente = doc.idInfoDocente"
				+ " and gru.idGrupo = ca.idGrupo and gra.idGrado = gru.idGrado and ins.estatus = 'A';";
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
				json.put("idGrado", rs.getInt("idGrado"));
				json.put("nombreGrupo", rs.getString("nombreGrupo"));
				json.put("turno", rs.getString("turno"));
				json.put("nombreDocente", rs.getString("nombreDocente"));
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
	
	public boolean quitarInscripcion(String nc)
	{
		boolean estatus = false;
		String sql = "update inscripciones set estatus = 'B' where idAlumno = (select idAlumno from alumnos where NoControl = ?);";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(sql);
			ps.setString(1, nc);
			ps.executeUpdate();
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

	public ArrayList<Opcion> consultaOpciones()
	{
		String sql = "select idOpcion,nombre,descripcion " + "from opciones";
		ArrayList<Opcion> array = new ArrayList<Opcion>();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				Opcion o = new Opcion();
				o.setId(rs.getInt("idOpcion"));
				o.setNombre(rs.getString("nombre"));
				o.setDescripcion(rs.getString("descripcion"));
				array.add(o);
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

	public boolean insertar(Opcion o)
	{
		String query = "insert into opciones values(null,?,?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setString(1, o.getNombre());
			ps.setString(2, o.getDescripcion());
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

	public boolean actualizar(Opcion o, int id)
	{
		String query = "update opciones set NOMBRE = '" + o.getNombre() + "', DESCRIPCION = '" + o.getDescripcion()
				+ "' " + "where IDOPCION = " + id;
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

	public Opcion ci(int i)
	{
		Opcion o = new Opcion();
		String sql = "select idOpcion,nombre,descripcion from opciones where idOpcion =" + i;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				o.setId(rs.getInt("idOpcion"));
				o.setNombre(rs.getString("nombre"));
				o.setDescripcion(rs.getString("descripcion"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return o;
	}
}
