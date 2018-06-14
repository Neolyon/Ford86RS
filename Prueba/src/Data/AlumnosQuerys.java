package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

import Objects.Alumno;
import Objects.DatosAlumno;
import Objects.DatosEs;
import Objects.Inscripcion;
import Objects.Login;
import Objects.Opcion;
import Objects.PadreTutor;

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
//		String sql = "SELECT a.NoControl, da.sexo, daes.estaRepitiendo repitiendo, cg.promedioPrimero, cg.promedioSegundo,"
//				+ " cg.promedioTercero, cg.promedioCuarto, cg.promedioQuintegero, cg.promedioSexto, gru.idGrado grado"
//				+ " FROM alumnos a, datosalumno da, datosescolares daes, docentes doce, cargosdocentes carg,"
//				+ " calificacionesglobal cg, grupos gru where doce.idDocente = "+idDocente+" and carg.idCargoDocente"
//				+ " = doce.idCargoDocente and daes.idDocente = doce.idDocente and daes.idCiclo = carg.idCiclo"
//				+ " and a.idAlumno = daes.idAlumno and a.estatus = 'A' and da.idDatosAlumno = a.idDatosAlumno"
//				+ " and cg.idAlumno = a.idAlumno and gru.idGrupo = carg.idGrupo;";
		String sql = "SELECT a.NoControl, da.sexo, daes.estaRepitiendo repitiendo FROM"
				+ " alumnos a, datosalumno da, datosescolares daes, docentes doce,"
				+ " cargosdocentes carg where doce.idDocente = "+idDocente+" and"
				+ " carg.idCargoDocente = doce.idCargoDocente and"
				+ " daes.idDocente = doce.idDocente and daes.idCiclo"
				+ " = carg.idCiclo and a.idAlumno = daes.idAlumno and"
				+ " a.estatus = 'A' and da.idDatosAlumno = a.idDatosAlumno;";
		
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
//				json.put("promedioPrimero", rs.getString("promedioPrimero"));
//				json.put("promedioSegundo", rs.getString("promedioSegundo"));
//				json.put("promedioTercero", rs.getString("promedioTercero"));
//				json.put("promedioCuarto", rs.getString("promedioCuarto"));
//				json.put("promedioQuinto", rs.getString("promedioQuintegero"));
//				json.put("promedioSexto", rs.getString("promedioSexto"));
//				json.put("grado", rs.getString("grado"));
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
	
	public boolean insertar(Alumno a)
	{
		String query = "INSERT INTO `alumnos`(`idAlumno`, `NoControl`, `idDatosAlumno`, `estatus`) VALUES (null, ?, ?, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setString(1, a.getNoControl());
			ps.setInt(2, a.getIdDatosAlumno());
			ps.setString(3, a.getEstatus());
			ps.execute();
			ps.close();
			con.close();
			System.out.println(">>>>>>>>>>>> Alumno insertado con exito");
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}
	
	public boolean insertarDatosAlumno(DatosAlumno d)
	{
		String query = "INSERT INTO `datosalumno`(`idDatosAlumno`, `nombre`, `fechaNacimiento`,"
				+ " `sexo`, `curp`, `lugarNacimiento`, `telefono1`, `telefono2`, `domicilio`,"
				+ " `enfermedades`, `listaPadresTutores`, `estatus`) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setString(1, d.getNombre());
			ps.setString(2, d.getFechaNacimiento());
			ps.setString(3, d.getSexo());
			ps.setString(4, d.getCurp());
			ps.setString(5, d.getLugarNacimiento());
			ps.setString(6, d.getTelefono1());
			ps.setString(7, d.getTelefono2());
			ps.setString(8, d.getDomicilio());
			ps.setString(9, d.getEnfermedades());
			ps.setString(10, d.getListaPadresTutores());
			ps.setString(11, d.getEstatus());
			ps.execute();
			ps.close();
			con.close();
			System.out.println(">>>>>>>>>>>> Datos del alumno Alumno insertado con exito");
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}
	
	public boolean insertarPadreTutor(PadreTutor p)
	{
		String query = "INSERT INTO `padrestutores`(`idPadreTutor`, `nombre`, `sexo`,"
				+ " `fechaNacimiento`, `estudios`, `ocupacion`, `estatus`)"
				+ " VALUES (null, ?, ?, ?, ?, ?, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getSexo());
			ps.setString(3, p.getFechaNacimiento());
			ps.setString(4, p.getEstudios());
			ps.setString(5, p.getOcupacion());
			ps.setString(6, p.getEstatus());
			ps.execute();
			ps.close();
			con.close();
			
			System.out.println(">>>>>>>>>>>> Padre Tutor insertado con exito");
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}
	
	public String ciPT(String nombre, String fecha)
	{
		String id = null;
		String sql = "select * from padrestutores where nombre = '"+nombre+"' and fechaNacimiento = '"+fecha+"' and estatus = 'A'";
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				id = rs.getInt("idPadreTutor")+"";
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return id;
	}
	
	public String ciDA(String nombre, String curp)
	{
		String id = null;
		String sql = "select * from datosalumno where nombre = '"+nombre+"' and curp = '"+curp+"' and estatus = 'A'";
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				id = rs.getInt("idDatosAlumno")+"";
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return id;
	}
	
	public String ciA(String nc)
	{
		String id = null;
		String sql = "select * from alumnos where NoControl = '"+nc+"' and estatus = 'A'";
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				id = rs.getInt("idAlumno")+"";
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return id;
	}
	
	public Alumno cAlumno(String nc)
	{
		Alumno a = null;
		String sql = "select * from alumnos where NoControl = '"+nc+"' and estatus = 'A'";
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				a = new Alumno();
				a.setIdAlumno(Integer.parseInt(rs.getString("idAlumno")));
				a.setNoControl(rs.getString("NoControl"));
				a.setIdDatosAlumno(Integer.parseInt(rs.getString("idDatosAlumno")));
				a.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return a;
	}
	
	public DatosAlumno cDA(String id)
	{
		DatosAlumno a = null;
		String sql = "select * from datosalumno where idDatosAlumno = "+id+" and estatus = 'A'";
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				a = new DatosAlumno();
				a.setIdDatosAlumno(Integer.parseInt(rs.getString("idDatosAlumno")));
				a.setNombre(rs.getString("nombre"));
				a.setFechaNacimiento(rs.getString("fechaNacimiento"));
				a.setSexo(rs.getString("sexo"));
				a.setCurp(rs.getString("curp"));
				a.setLugarNacimiento(rs.getString("lugarNacimiento"));
				a.setTelefono1(rs.getString("telefono1"));
				a.setTelefono2(rs.getString("telefono2"));
				a.setDomicilio(rs.getString("domicilio"));
				a.setEnfermedades(rs.getString("enfermedades"));
				a.setListaPadresTutores(rs.getString("listaPadresTutores"));
				a.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return a;
	}
	
	public DatosEs cDE(String id)
	{
		DatosEs a = null;
		String sql = "select * from datosescolares where idAlumno = "+id+" and estatus = 'A'";
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				a = new DatosEs();
				a.setIdDatoEscolar(Integer.parseInt(rs.getString("idDatoEscolar")));
				a.setIdCiclo(Integer.parseInt(rs.getString("idCiclo")));
				a.setIdAlumno(Integer.parseInt(rs.getString("idAlumno")));
				a.setIdDocente(Integer.parseInt(rs.getString("idDocente")));
				a.setEstaRepitiendo(rs.getString("estaRepitiendo"));
				a.setEstadoEscolar(rs.getString("estadoEscolar"));
				a.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println("Error al ejecutar la consulta" + e.getMessage());
		}
		return a;
	}
}

