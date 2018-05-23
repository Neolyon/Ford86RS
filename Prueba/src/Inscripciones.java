
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.InscripcionesQuerys;

/**
 * Servlet implementation class Inscripciones
 */
@WebServlet(name = "Inscripciones", urlPatterns = "/Inscripciones")
public class Inscripciones extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscripciones()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String op = request.getParameter("op");
			RequestDispatcher rd = request.getRequestDispatcher("jsp/opciones/consulta.jsp");
			switch (op)
			{
				case "ct":
					int idDocente = Integer.parseInt(request.getParameter("idDocente"));
					InscripcionesQuerys iq = new InscripcionesQuerys();
					String json = iq.consultaPorDocente(idDocente);
					PrintWriter out = response.getWriter();
					response.setContentType("application/json");
					out.println(json);
					out.close();
					break;
				case "ctt":
					iq = new InscripcionesQuerys();
					json = iq.consultaTodasLasInscripciones();
					out = response.getWriter();
					response.setContentType("application/json");
					out.println(json);
					out.close();
					break;
				case "e":
					String nc = request.getParameter("nc");
					iq = new InscripcionesQuerys();
					if (iq.quitarInscripcion(nc) == true)
					{
						json = iq.consultaTodasLasInscripciones();
						out = response.getWriter();
						response.setContentType("application/json");
						out.println(json);
						out.close();
					}
					else
					{
						System.out.println("Eror al actualizar.");
					}
					break;
			}
		} catch (NullPointerException n)
		{
			System.out.println("<<<Error>>>: " + n.getCause());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}