

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DocentesQuerys;
import Data.GruposQuerys;


/**
 * Servlet implementation class Docentes
 */
@WebServlet(name="Docentes",urlPatterns="/Docentes")
public class Docentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Docentes() {
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
			case "cc":
				DocentesQuerys dq = new DocentesQuerys();
				String json = dq.consultaDocentes();
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
			case "c":
				dq = new DocentesQuerys();
				json = dq.consultaCargos();
				out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
			case "ec":
				String id = request.getParameter("id");
				dq = new DocentesQuerys();
				if (dq.quitarCargo(id) == true)
				{
					json = dq.consultaCargos();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
