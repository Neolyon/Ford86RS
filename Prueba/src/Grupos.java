

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.GruposQuerys;
import Data.MateriasQuerys;
import Data.ReinscripcionesQuerys;
import Objects.Grupo;
import Objects.Materia;

/**
 * Servlet implementation class Grupos
 */
@WebServlet(name="Grupos",urlPatterns="/Grupos")
public class Grupos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Grupos() {
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
			case "cgru":
				GruposQuerys gq = new GruposQuerys();
				String json = gq.consultaGrupos();
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
			case "cgra":
				gq = new GruposQuerys();
				json = gq.consultaGrados();
				out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
			case "e":
				String nombre = request.getParameter("nombre");
				gq = new GruposQuerys();
				if (gq.quitarGrupo(nombre) == true)
				{
					json = gq.consultaGrados();
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
				String nom = request.getParameter("nombre1");
				String desc = request.getParameter("desc1");
				String tur = request.getParameter("turno1");
				String sal = request.getParameter("salon1");
				int idg = Integer.parseInt(request.getParameter("idg1"));
				
				System.out.println("Nom: " + nom);
				System.out.println("Desc: " + desc);
				System.out.println("IDG: " + idg);
				
				Grupo g = new Grupo();
				g.setNombre(nom);
				g.setDescripcion(desc);
				g.setIdGrado(idg);
				g.setTurno(tur);
				g.setSalon(sal);
				g.setEstatus("A");
				gq = new GruposQuerys();
				if (gq.insertar(g) != true)
				{
					System.out.println("Eror al insertar.");
				}
				rd = request.getRequestDispatcher("jsp/principal/grupos.jsp");
				red = true;
				break;
			case "ed":
				String idG = request.getParameter("idG");
				nom = request.getParameter("nombre2");
				desc = request.getParameter("desc2");
				tur = request.getParameter("turno2");
				sal = request.getParameter("salon2");
				idg = Integer.parseInt(request.getParameter("idg2"));
				
				System.out.println("Nom: " + nom);
				System.out.println("Desc: " + desc);
				System.out.println("IDG: " + idg);
				System.out.println("ID: " + idG);	
				
				g = new Grupo();
				g.setIdGrupo(Integer.parseInt(idG));
				g.setNombre(nom);
				g.setDescripcion(desc);
				g.setIdGrado(idg);
				g.setTurno(tur);
				g.setSalon(sal);
				g.setEstatus("A");
				gq = new GruposQuerys();
				if (gq.actualizar(g) != true)
				{
					System.out.println("Eror al actualizar.");
				}
				rd = request.getRequestDispatcher("jsp/principal/grupos.jsp");
				red = true;
				break;
			case "cc":
				int id = Integer.parseInt(request.getParameter("id"));
				gq = new GruposQuerys();
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
