import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.AlumnosQuerys;

/**
 * Servlet implementation class Alumnos
 */
@WebServlet(name="Alumnos",urlPatterns="/Alumnos")
public class Alumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		RequestDispatcher rd = request.getRequestDispatcher("jsp/opciones/consulta.jsp");
		switch (op)
		{
			case "ct":
				String idD = request.getParameter("idD");
				AlumnosQuerys aq = new AlumnosQuerys();
				String json = aq.consultaPorDocente(idD);
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
			case "ctt":
				idD = request.getParameter("idD");
				aq = new AlumnosQuerys();
				json = aq.consultaPorDocenteConCal(idD);
				out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
			case "cal":
				idD = request.getParameter("nc");
				aq = new AlumnosQuerys();
				json = aq.consultaCal(idD);
				out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
