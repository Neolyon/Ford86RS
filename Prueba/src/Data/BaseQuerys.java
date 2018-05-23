package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.PreparedStatement;

import Objects.Opcion;
import java.util.*;

public class BaseQuerys
{

	public BaseQuerys()
	{
		// TODO Auto-generated constructor stub
	}

	public String consultaGeneral()
	{
		String sql = "select idOpcion,nombre,descripcion " + "from opciones";
		JSONArray array = new JSONArray();
		try
		{
			ConnectionDB con = new ConnectionDB();
			Statement sentencia = con.get().createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			while (rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("id", rs.getInt("idOpcion"));
				json.put("nombre", rs.getString("nombre"));
				json.put("descripcion", rs.getString("descripcion"));
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
