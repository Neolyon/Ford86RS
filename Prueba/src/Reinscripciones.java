import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Random;

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
import Data.InscripcionesQuerys;
import Data.ReinscripcionesQuerys;
import Data.SesionQuerys;
import Objects.Alumno;
import Objects.Cargo;
import Objects.Ciclo;
import Objects.DatosAlumno;
import Objects.DatosEs;
import Objects.Docente;
import Objects.Grupo;
import Objects.InfoDocente;
import Objects.Inscripcion;
import Objects.Login;
import Objects.PadreTutor;
import Objects.Reinscripcion;

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
		boolean red = false;
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
			case "ca":
				String idND = request.getParameter("idND");
				String nc = request.getParameter("nc");
				AlumnosQuerys aq = new AlumnosQuerys();
				Alumno a = aq.cAlumno(nc);
				DatosAlumno da = aq.cDA(a.getIdDatosAlumno()+"");
				DatosEs de = aq.cDE(a.getIdAlumno()+"");
				DocentesQuerys dq = new DocentesQuerys();
				Docente  d =  dq.cDoce(de.getIdDocente());
				InfoDocente info = dq.cInfoDocente(d.getIdInfoDocente());
				Cargo car = dq.cCargoDocente(d.getIdCargoDocente());
				Grupo g = dq.cGru(car.getIdGrupo());
				
				System.out.println(idND);
				System.out.println(nc);
				System.out.println(da);
				System.out.println(g);
				System.out.println(info);
				JSONObject js = new JSONObject();
				js.put("nomA", da.getNombre());
				js.put("sexA", da.getSexo());
				js.put("curpA", da.getCurp());
				js.put("lugarA", da.getLugarNacimiento());
				js.put("fechaA", da.getFechaNacimiento());
				js.put("domA", da.getDomicilio());
				js.put("tel1A", da.getTelefono1());
				js.put("tel2A", da.getTelefono2());
				js.put("nomD", info.getNombre());
				js.put("graA", g.getIdGrado());
				js.put("gruA", g.getNombre());
				Docente  nd =  dq.cDoce(Integer.parseInt(idND));
				InfoDocente infon = dq.cInfoDocente(nd.getIdInfoDocente());
				Cargo carn = dq.cCargoDocente(nd.getIdCargoDocente());
				Grupo gn = dq.cGru(carn.getIdGrupo());
				
				System.out.println(infon);
				System.out.println(gn);
				js.put("nomND", infon.getNombre());
				js.put("graN", gn.getIdGrado());
				js.put("gruN", gn.getNombre());
				js.put("turN", gn.getTurno());
				
				JSONArray array = new JSONArray();
				array.add(js);
				
				out = response.getWriter();
				response.setContentType("application/json");
				String j = array.toString();
				out.println(j);
				out.close();
				break;
			case "i":
				nc = request.getParameter("numcon");
				System.out.println("?????>>>>>> NC: " + nc);
				int idD = Integer.parseInt(request.getParameter("idD"));

				dq = new DocentesQuerys();
				aq = new AlumnosQuerys();
				d = dq.cDoce(idD);
				a = aq.cAlumno(nc);
				InfoDocente indo = dq.cInfoDocente(d.getIdInfoDocente());
				Cargo c = dq.cCargoDocente(d.getIdCargoDocente());
				DatosEs datoe = aq.cDE(a.getIdAlumno()+"");
				
				datoe.setIdCiclo(c.getIdCiclo());
				datoe.setIdDocente(d.getIdDocente());
				datoe.setIdParcial(0);
				datoe.setIdCalificacionGlobal(0);
				datoe.setEstaRepitiendo("N");
				datoe.setEstadoEscolar("Cu");
				datoe.setEstatus("A");
				
				rq = new ReinscripcionesQuerys();
				rq.actualizarDE(datoe);
				
				Reinscripcion r = new Reinscripcion();
				r.setIdAlumno(a.getIdAlumno());
				r.setIdDatoEscolar(datoe.getIdDatoEscolar());
				r.setIdDocente(d.getIdDocente());
				r.setRecursaEsteGrado("N");
				r.setEstatus("A");
				
				rq.insertar(r);
				
				red = true;
				rd = request.getRequestDispatcher("jsp/principal/reinscripciones.jsp");
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
