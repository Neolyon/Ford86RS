package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

import Objects.Cargo;
import Objects.Docente;
import Objects.Grupo;
import Objects.InfoDocente;
import Objects.Login;
import Objects.Materia;
import Objects.Opcion;
import Objects.PadreTutor;

import java.util.*;

public class DocentesQuerys
{

	public DocentesQuerys()
	{
		// TODO Auto-generated constructor stub
	}
	
	public boolean registrarCargo(String idD, String idC)
	{
		boolean estatus = false;
		String sql = "update docentes set idCargoDocente = ? where idDocente = ?;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(sql);
			ps.setString(1, idC);
			ps.setString(2, idD);
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
		if (id != "0")
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
		return false;
	}
	
	public boolean quitarDocente(Docente d)
	{
		boolean estatus = false;
		String sql = "update docentes set estatus = 'B' where idDocente = ?;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(sql);
			ps.setInt(1, d.getIdDocente());
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
	
	public boolean quitarLogin(Login l)
	{
		boolean estatus = false;
		String sql = "update logeo set estatus = 'B' where idLogin = ?;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(sql);
			ps.setInt(1, l.getIdLogin());
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
	
	public boolean quitarInfo(InfoDocente info)
	{
		boolean estatus = false;
		String sql = "update infodocente set estatus = 'B' where idInfoDocente = ?;";
		
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(sql);
			ps.setInt(1, info.getIdInfoDocente());
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
	
	public Docente ci(int idLogin)
	{
		String sql = "SELECT * FROM docentes where estatus = 'A' and idUsuario = "+idLogin+"";
		
		Docente d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new Docente();
				d.setIdDocente(Integer.parseInt(rs.getString("idDocente")));
				d.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
				d.setIdInfoDocente(Integer.parseInt(rs.getString("idInfoDocente")));
				d.setIdCargoDocente(Integer.parseInt(rs.getString("idCargoDocente")));
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public Materia cMateria(String nombre)
	{
		String sql = "SELECT * FROM materias where estatus = 'A' and nombre = '"+nombre+"';";
		
		Materia m = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				m = new Materia();
				m.setIdMateria(Integer.parseInt(rs.getString("idMateria")));
				m.setNombre(rs.getString("nombre"));
				m.setIdGrado(Integer.parseInt(rs.getString("idGrado")));
				m.setDescripcion(rs.getString("descripcion"));
				m.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return m;
	}
	
	public Docente cDo(int idInfo)
	{
		String sql = "SELECT * FROM docentes where estatus = 'A' and idInfoDocente = "+idInfo+"";
		
		Docente d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new Docente();
				d.setIdDocente(Integer.parseInt(rs.getString("idDocente")));
				d.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
				d.setIdInfoDocente(Integer.parseInt(rs.getString("idInfoDocente")));
				if (rs.getString("idCargoDocente") != null)
				{
					d.setIdCargoDocente(Integer.parseInt(rs.getString("idCargoDocente")));
				}
				else
				{
					d.setIdCargoDocente(0);
				}
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public Docente cDoce(int idD)
	{
		String sql = "SELECT * FROM docentes where estatus = 'A' and idDocente = "+idD+"";
		
		Docente d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new Docente();
				d.setIdDocente(Integer.parseInt(rs.getString("idDocente")));
				d.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
				d.setIdInfoDocente(Integer.parseInt(rs.getString("idInfoDocente")));
				if (rs.getString("idCargoDocente") != null)
				{
					d.setIdCargoDocente(Integer.parseInt(rs.getString("idCargoDocente")));
				}
				else
				{
					d.setIdCargoDocente(0);
				}
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	public Login cLogin(String nom)
	{
		String sql = "SELECT * FROM logeo where estatus = 'A' and usuario = '"+nom+"'";
		
		Login d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new Login();
				d.setIdLogin(Integer.parseInt(rs.getString("idLogin")));
				d.setUsuario(rs.getString("usuario"));
				d.setPass(rs.getString("pass"));
				d.setNip(rs.getString("nip"));
				d.setNivel(rs.getString("nivel"));
				d.setImagen(rs.getBlob("imagen"));
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public Login cL(int idL)
	{
		String sql = "SELECT * FROM logeo where estatus = 'A' and idLogin = "+idL+"";
		
		Login d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new Login();
				d.setIdLogin(Integer.parseInt(rs.getString("idLogin")));
				d.setUsuario(rs.getString("usuario"));
				d.setPass(rs.getString("pass"));
				d.setNip(rs.getString("nip"));
				d.setNivel(rs.getString("nivel"));
				d.setImagen(rs.getBlob("imagen"));
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	public InfoDocente cInfoDocente(int idInfo)
	{
		String sql = "SELECT * FROM infodocente where estatus = 'A' and idInfoDocente = "+idInfo+"";
		
		InfoDocente d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new InfoDocente();
				d.setIdInfoDocente(Integer.parseInt(rs.getString("idInfoDocente")));
				d.setNombre(rs.getString("nombre"));
				d.setFechaNacimiento(rs.getString("fechaNacimiento"));
				d.setSexo(rs.getString("sexo"));
				d.setTelefono1(rs.getString("telefono1"));
				d.setTelefono2(rs.getString("telefono2"));
				d.setDomicilio(rs.getString("domicilio"));
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public InfoDocente cInfo(String nom, String fecha)
	{
		String sql = "SELECT * FROM infodocente where estatus = 'A' and nombre = '"+nom+"' and fechaNacimiento = '"+fecha+"'";
		
		InfoDocente d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new InfoDocente();
				d.setIdInfoDocente(Integer.parseInt(rs.getString("idInfoDocente")));
				d.setNombre(rs.getString("nombre"));
				d.setFechaNacimiento(rs.getString("fechaNacimiento"));
				d.setSexo(rs.getString("sexo"));
				d.setTelefono1(rs.getString("telefono1"));
				d.setTelefono2(rs.getString("telefono2"));
				d.setDomicilio(rs.getString("domicilio"));
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public InfoDocente cInfoDo(String nom)
	{
		String sql = "SELECT * FROM infodocente where estatus = 'A' and nombre = '"+nom+"'";
		
		InfoDocente d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new InfoDocente();
				d.setIdInfoDocente(Integer.parseInt(rs.getString("idInfoDocente")));
				d.setNombre(rs.getString("nombre"));
				d.setFechaNacimiento(rs.getString("fechaNacimiento"));
				d.setSexo(rs.getString("sexo"));
				d.setTelefono1(rs.getString("telefono1"));
				d.setTelefono2(rs.getString("telefono2"));
				d.setDomicilio(rs.getString("domicilio"));
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public Cargo cCargoDocente(int idCargo)
	{
		String sql = "SELECT * FROM cargosdocentes where vigente = 'A' and idCargoDocente = "+idCargo+"";
		
		 Cargo d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new  Cargo();
				d.setIdCargoDocente(Integer.parseInt(rs.getString("idCargoDocente")));
				d.setIdGrupo(Integer.parseInt(rs.getString("idGrupo")));
				d.setListaMaterias(rs.getString("listaMaterias"));
				d.setIdCiclo(Integer.parseInt(rs.getString("idCiclo")));
				d.setDescripcion(rs.getString("descripcion"));
				d.setVigente(rs.getString("vigente"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public Cargo cCargoDoc(String idG, String lm, String desc)
	{
		String sql = "SELECT * FROM cargosdocentes where vigente = 'A' and idGrupo = "+idG+" and listaMaterias = '"+lm+"'"
				+ "and descripcion = '"+desc+"'";
		
		 Cargo d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				System.out.println(">>>>>>>>>>>>>>  Si");
				d = new  Cargo();
				d.setIdCargoDocente(Integer.parseInt(rs.getString("idCargoDocente")));
				d.setIdGrupo(Integer.parseInt(rs.getString("idGrupo")));
				d.setListaMaterias(rs.getString("listaMaterias"));
				d.setIdCiclo(Integer.parseInt(rs.getString("idCiclo")));
				d.setDescripcion(rs.getString("descripcion"));
				d.setVigente(rs.getString("vigente"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public Grupo cGrupo(String nombre, String turno, String salon)
	{
		String sql = "SELECT * FROM grupos where estatus = 'A' and nombre = '"+nombre+"' and turno = '"+turno+"' and salon = '"+salon+"'";
		
		 Grupo d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new  Grupo();
				d.setIdGrupo(Integer.parseInt(rs.getString("idGrupo")));
				d.setNombre(rs.getString("nombre"));
				d.setIdGrado(Integer.parseInt(rs.getString("idGrado")));
				d.setSalon(rs.getString("salon"));
				d.setTurno(rs.getString("turno"));
				d.setDescripcion(rs.getString("descripcion"));
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public Grupo cGru(int id)
	{
		String sql = "SELECT * FROM grupos where estatus = 'A' and idGrupo = "+id+"";
		
		 Grupo d = null;
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				d = new  Grupo();
				d.setIdGrupo(Integer.parseInt(rs.getString("idGrupo")));
				d.setNombre(rs.getString("nombre"));
				d.setIdGrado(Integer.parseInt(rs.getString("idGrado")));
				d.setSalon(rs.getString("salon"));
				d.setTurno(rs.getString("turno"));
				d.setDescripcion(rs.getString("descripcion"));
				d.setEstatus(rs.getString("estatus"));
			}
			sentencia.close();
			rs.close();
			con.close();
		} catch (SQLException e)
		{
			System.err.println("<<<MySQL>>> Error al ejecutar la consulta" + e.getMessage());
		}

		return d;
	}
	
	public boolean insertar(Docente d)
	{
		String query = "INSERT INTO `docentes`(`idDocente`, `idUsuario`, `idInfoDocente`,"
				+ " `idCargoDocente`, `estatus`)"
				+ " VALUES (null, ?, ?, null, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setInt(1, d.getIdUsuario());
			ps.setInt(2, d.getIdInfoDocente());
			ps.setString(3, d.getEstatus());
			ps.execute();
			ps.close();
			con.close();
			
			System.out.println(">>>>>>>>>>>> Docente insertado con exito");
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}
	
	public boolean insertarLogin(Login l)
	{
		String query = "INSERT INTO `logeo`(`idLogin`, `usuario`, `pass`, `nip`,"
				+ " `nivel`, `imagen`, `estatus`)"
				+ " VALUES (null, ?, ?, ?, ?, null, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setString(1, l.getUsuario());
			ps.setString(2, l.getPass());
			ps.setString(3, l.getNip());
			ps.setString(4, l.getNivel());
			ps.setString(5, l.getEstatus());
			ps.execute();
			ps.close();
			con.close();
			
			System.out.println(">>>>>>>>>>>> Login insertado con exito");
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}
	
	public boolean insertarInfo(InfoDocente info)
	{
		String query = "INSERT INTO `infodocente`(`idInfoDocente`, `nombre`, `fechaNacimiento`,"
				+ " `sexo`, `telefono1`, `telefono2`, `domicilio`, `estatus`)"
				+ " VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setString(1, info.getNombre());
			ps.setString(2, info.getFechaNacimiento());
			ps.setString(3, info.getSexo());
			ps.setString(4, info.getTelefono1());
			ps.setString(5, info.getTelefono2());
			ps.setString(6, info.getDomicilio());
			ps.setString(7, info.getEstatus());
			ps.execute();
			ps.close();
			con.close();
			
			System.out.println(">>>>>>>>>>>> Info insertado con exito");
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}
	
	public boolean insertaCargo(Cargo c)
	{
		String query = "INSERT INTO `cargosdocentes`(`idCargoDocente`, `idGrupo`,"
				+ " `listaMaterias`, `idCiclo`, `descripcion`, `vigente`)"
				+ " VALUES (null, ?, ?, ?, ?, ?)";
		boolean ban = false;
		try
		{
			ConnectionDB con = new ConnectionDB();
			PreparedStatement ps = con.get().prepareStatement(query);
			ps.setInt(1, c.getIdGrupo());
			ps.setString(2, c.getListaMaterias());
			ps.setInt(3, c.getIdCiclo());
			ps.setString(4, c.getDescripcion());
			ps.setString(5, c.getVigente());
			ps.execute();
			ps.close();
			con.close();
			
			System.out.println(">>>>>>>>>>>> Cargo insertado con exito");
			ban = true;
		} catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		return ban;
	}
}
