import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.ReinscripcionesQuerys;

/**
 * Servlet implementation class Reinscripciones
 */
@WebServlet(name="Reinscripciones",urlPatterns="/Reinscripciones")
public class Reinscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reinscripciones() {
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
//			case "l":
//				rd.forward(request, response);
//				break;
//			case "cg":
//				OpcionesDAO odao = new OpcionesDAO();
//				String json = odao.consultaGeneral();
//				PrintWriter out = response.getWriter();
//				response.setContentType("application/json");
//				out.println(json);
//				out.close();
//				break;
//			case "n":
//				rd = request.getRequestDispatcher("jsp/opciones/alta.jsp");
//				rd.forward(request, response);
//				break;
//			case "i":
//				Opcion o = new Opcion();
//				odao = new OpcionesDAO();
//				o.setNombre(request.getParameter("tipo"));
//				o.setDescripcion(request.getParameter("desc"));
//				if (odao.insertar(o))
//				{
//					rd = request.getRequestDispatcher("jsp/opciones/consultaGeneral.jsp");
//					request.setAttribute("opciones", odao.consultaOpciones());
//
//				} else
//				{
//					rd = request.getRequestDispatcher("jsp/opciones/alta.jsp");
//
//				}
//				rd.forward(request, response);
//				break;
//			case "u":
//				o = new Opcion();
//				odao = new OpcionesDAO();
//				o.setId(Integer.parseInt(request.getParameter("id")));
//				o.setNombre(request.getParameter("nom"));
//				o.setDescripcion(request.getParameter("desc"));
//				if (odao.actualizar(o, o.getId()))
//				{
//					rd = request.getRequestDispatcher("jsp/opciones/consultaGeneral.jsp");
//					request.setAttribute("opciones", odao.consultaOpciones());
//
//				} else
//				{
//					rd = request.getRequestDispatcher("jsp/opciones/alta.jsp");
//
//				}
//				rd.forward(request, response);
//				break;
//			case "e":
//				odao = new OpcionesDAO();
//				rd = request.getRequestDispatcher("jsp/opciones/editar.jsp");
//				request.setAttribute("opciones", odao.ci(Integer.parseInt(request.getParameter("idOpcion"))));
//				rd.forward(request, response);
//				break;
			case "ct":
				ReinscripcionesQuerys rq = new ReinscripcionesQuerys();
				String json = rq.consultaTodasLasReinscripciones();
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.println(json);
				out.close();
				break;
			case "e":
				String id = request.getParameter("id");
				rq = new ReinscripcionesQuerys();
				if (rq.quitarReinscripcion(id) == true)
				{
					json = rq.consultaTodasLasReinscripciones();
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
