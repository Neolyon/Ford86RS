import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Direccion",urlPatterns="/Direccion")
public class Direccion extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public Direccion() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String op=request.getParameter("op");
		
		RequestDispatcher rd=request.getRequestDispatcher("jsp/principal/principal.jsp");
		
		switch (op) 
		{
		case "h":
			rd = request.getRequestDispatcher("jsp/principal/principal.jsp");
			break;
		case "i":
			rd = request.getRequestDispatcher("jsp/principal/inscripciones.jsp");
			break;
		case "r":
			rd = request.getRequestDispatcher("jsp/principal/reinscripciones.jsp");
			break;
		case "a":
			rd = request.getRequestDispatcher("jsp/principal/alumnos.jsp");
			break;
		case "d":
			rd = request.getRequestDispatcher("jsp/principal/docentes.jsp");
			break;
		case "g":
			rd = request.getRequestDispatcher("jsp/principal/grupos.jsp");
			break;
		case "m":
			rd = request.getRequestDispatcher("jsp/principal/materias.jsp");
			break;
		case "alu1":
			rd = request.getRequestDispatcher("jsp/principal/alumnos.jsp");
			break;
		case "alu2":
			rd = request.getRequestDispatcher("jsp/principal/datosoperaciones.jsp");
			break;
		case "doc1":
			rd = request.getRequestDispatcher("jsp/principal/altadocente.jsp");
			break;
		case "doc2":
			rd = request.getRequestDispatcher("jsp/principal/quitardocente.jsp");
			break;
		case "doc3":
			rd = request.getRequestDispatcher("jsp/principal/cargodocente.jsp");
			break;
		case "doc4":
			rd = request.getRequestDispatcher("jsp/principal/infocargos.jsp");
			break;
		case "ins1":
			rd = request.getRequestDispatcher("jsp/principal/inscripciones.jsp");
			break;
		case "ins2":
			rd = request.getRequestDispatcher("jsp/principal/inscripcionesinfo.jsp");
			break;
		case "ins3":
			rd = request.getRequestDispatcher("jsp/principal/inscripcionesinfotodas.jsp");
			break;
		case "rei1":
			rd = request.getRequestDispatcher("jsp/principal/reinscripciones.jsp");
			break;
		case "rei2":
			rd = request.getRequestDispatcher("jsp/principal/reinscripcionesinfo.jsp");
			break;
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}