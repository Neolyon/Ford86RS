import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Data.AlumnosQuerys;
import Data.DocentesQuerys;
import Objects.Alumno;
import Objects.Cargo;
import Objects.DatosAlumno;
import Objects.DatosEs;
import Objects.Docente;
import Objects.Grupo;
import Objects.InfoDocente;

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
			case "ca":
				String nc = request.getParameter("nc");
				aq = new AlumnosQuerys();
				Alumno a = aq.cAlumno(nc);
				DatosAlumno da = aq.cDA(a.getIdDatosAlumno()+"");
				
				System.out.println(nc);
				System.out.println(da);
				JSONObject js = new JSONObject();
				js.put("nomA", da.getNombre());
				js.put("sexA", da.getSexo());
				js.put("curpA", da.getCurp());
				js.put("lugarA", da.getLugarNacimiento());
				js.put("fechaA", da.getFechaNacimiento());
				js.put("domA", da.getDomicilio());
				js.put("tel1A", da.getTelefono1());
				js.put("tel2A", da.getTelefono2());
				
				JSONArray array = new JSONArray();
				array.add(js);
				
				out = response.getWriter();
				response.setContentType("application/json");
				String j = array.toString();
				out.println(j);
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
