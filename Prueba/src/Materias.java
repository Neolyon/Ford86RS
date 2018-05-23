

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.MateriasQuerys;

/**
 * Servlet implementation class Materias
 */
@WebServlet(name="Materias",urlPatterns="/Materias")
public class Materias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Materias() {
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
			case "c":
				MateriasQuerys gq = new MateriasQuerys();
				String json = gq.consultaMaterias();
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
			case "e":
				String nombre = request.getParameter("nombre");
				gq = new MateriasQuerys();
				if (gq.quitarMateria(nombre) == true)
				{
					json = gq.consultaMaterias();
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
