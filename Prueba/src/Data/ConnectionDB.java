package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB
{
	Connection conn;
	String url = "jdbc:mysql://localhost:3306/f86rsdb";

	public ConnectionDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Connected....");
		} catch (SQLException e)
		{
			System.err.println("Error al conectar con la Base de Datos." + e.getMessage());
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection get()
	{
		return conn;
	}

	public void close()
	{
		try
		{
			conn.close();
		} catch (SQLException e)
		{
			System.err.println("Error al cerrar la conexion." + e.getMessage());
		}
	}
}
