

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.MateriasQuerys;
import Objects.Materia;

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
		boolean red = false;
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
			case "i":
				String nom = request.getParameter("nom1");
				String desc = request.getParameter("desc1");
				int idg = Integer.parseInt(request.getParameter("idg1"));
				
				System.out.println("Nom: " + nom);
				System.out.println("Desc: " + desc);
				System.out.println("IDG: " + idg);
				
				Materia m = new Materia();
				m.setNombre(nom);
				m.setDescripcion(desc);
				m.setIdGrado(idg);
				m.setEstatus("A");
				gq = new MateriasQuerys();
				if (gq.insertar(m) != true)
				{
					System.out.println("Eror al insertar.");
				}
				rd = request.getRequestDispatcher("jsp/principal/materias.jsp");
				red = true;
				break;
			case "ed":
				String idM = request.getParameter("idM");
				nom = request.getParameter("nom2");
				desc = request.getParameter("desc2");
				idg = Integer.parseInt(request.getParameter("idg2"));
				
				System.out.println("Nom: " + nom);
				System.out.println("Desc: " + desc);
				System.out.println("IDG: " + idg);
				System.out.println("ID: " + idM);	
				
				m = new Materia();
				m.setIdMateria(Integer.parseInt(idM));
				m.setNombre(nom);
				m.setDescripcion(desc);
				m.setIdGrado(idg);
				m.setEstatus("A");
				gq = new MateriasQuerys();
				if (gq.actualizar(m) != true)
				{
					System.out.println("Eror al actualizar.");
				}
				rd = request.getRequestDispatcher("jsp/principal/materias.jsp");
				red = true;
				break;
			case "cc":
				System.out.println("Entro");
				int id = Integer.parseInt(request.getParameter("id"));
				gq = new MateriasQuerys();
				json = gq.ci(id);
				out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
		}
		if (red == true)
		{
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
