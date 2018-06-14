
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

import Data.AlumnosQuerys;
import Data.DocentesQuerys;
import Data.InscripcionesQuerys;
import Data.SesionQuerys;
import Objects.Alumno;
import Objects.Ciclo;
import Objects.DatosAlumno;
import Objects.DatosEs;
import Objects.Docente;
import Objects.Inscripcion;
import Objects.PadreTutor;

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
//		try
//		{
			String op = request.getParameter("op");
			RequestDispatcher rd = request.getRequestDispatcher("jsp/opciones/consulta.jsp");
			boolean red = false;
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
				case "i":
					String idL = request.getParameter("idL");
					String noma = request.getParameter("nombrea");
					String fechaa = request.getParameter("fechaa");
					String curpa = request.getParameter("curpa");
					String lugara = request.getParameter("lugara");
					String sexoa = request.getParameter("sexoa");
					String tel1a = request.getParameter("tel1a");
					String tel2a = request.getParameter("tel2a");
					String domicilioa = request.getParameter("domicilioa");
					String enfermedades = request.getParameter("enfermedades");
					String situacion = request.getParameter("ingreso");
					String situaa = request.getParameter("situaa");
					String nomp = request.getParameter("nomp");
					String estp = request.getParameter("estp");
					String ocup = request.getParameter("ocup");
					String fechap = request.getParameter("fechap");
					String nomm = request.getParameter("nomm");
					String estm = request.getParameter("estm");
					String ocum = request.getParameter("ocum");
					String fecham = request.getParameter("fecham");
					String nomt = request.getParameter("nomt");
					String estt = request.getParameter("estt");
					String ocut = request.getParameter("ocut");
					String fechat = request.getParameter("fechat");
					String vivecon = request.getParameter("vivecon");
					
					int year = Calendar.getInstance().get(Calendar.YEAR);
					SesionQuerys sq = new SesionQuerys();
					System.out.println(year);
					Ciclo ci = sq.getCiclo((year-1) + "-" + year);
					System.out.println(ci);
					Inscripcion ins = new Inscripcion();
					ins.setIdCiclo(ci.getIdCiclo());
					DocentesQuerys dq = new DocentesQuerys();
					Docente d = dq.ci(Integer.parseInt(idL));
					ins.setIdDocentes(d.getIdDocente());
					AlumnosQuerys aq = new AlumnosQuerys();
					Alumno a = new Alumno();
					DatosAlumno da = new DatosAlumno();
					da.setNombre(noma);
					da.setFechaNacimiento(fechaa);
					da.setSexo(sexoa);
					da.setCurp(curpa);
					da.setLugarNacimiento(lugara);
					da.setTelefono1(tel1a);
					da.setTelefono2(tel2a);
					da.setDomicilio(domicilioa);
					da.setEnfermedades(enfermedades);
					da.setEstatus("A");
					
					PadreTutor pp = new PadreTutor();
					pp.setNombre(nomp);
					pp.setSexo("H");
					pp.setFechaNacimiento(fechap);
					pp.setEstudios(estp);
					pp.setOcupacion(ocup);
					pp.setEstatus("A");
					
					aq.insertarPadreTutor(pp);
					
					PadreTutor pm = new PadreTutor();
					pm.setNombre(nomm);
					pm.setSexo("M");
					pm.setFechaNacimiento(fecham);
					pm.setEstudios(estm);
					pm.setOcupacion(ocum);
					pm.setEstatus("A");
					
					aq.insertarPadreTutor(pm);
					
					PadreTutor pt = new PadreTutor();
					pt.setNombre(nomt);
					pt.setSexo("H");
					pt.setFechaNacimiento(fechat);
					pt.setEstudios(estt);
					pt.setOcupacion(ocut);
					pt.setEstatus("A");
					
					aq.insertarPadreTutor(pt);
					
					Random r = new Random();
					int r1 = (int)(r.nextDouble() * 9 + 0);  
					int r2 = (int)(r.nextDouble() * 9 + 0); 
					int r3 = (int)(r.nextDouble() * 9 + 0); 
					int r4 = (int)(r.nextDouble() * 9 + 0); 
					String s = year+""+curpa.charAt(0)+curpa.charAt(0)+r1+r2+r3+r4;
					System.out.println(">>>>> nocontrol: " + s);
					a.setNoControl(s);
					
					da.setListaPadresTutores(aq.ciPT(pp.getNombre(), pp.getFechaNacimiento()) + " " 
					+ aq.ciPT(pm.getNombre(), pm.getFechaNacimiento()) + " " + 
							aq.ciPT(pt.getNombre(), pt.getFechaNacimiento()));
					aq.insertarDatosAlumno(da);
					
					a.setIdDatosAlumno(Integer.parseInt(aq.ciDA(da.getNombre(), da.getCurp())));
					a.setEstatus("A");
					
					aq.insertar(a);
					
					ins.setIdAlumno(Integer.parseInt(aq.ciA(a.getNoControl())));
					ins.setViveCon(vivecon);
					ins.setOtrasSituaciones(situaa);
					ins.setSituacionEscolar(situacion);
					ins.setEstatus("A");
					
					InscripcionesQuerys iq1 = new InscripcionesQuerys();
					iq1.insertar(ins);
					
					DatosEs datoe = new DatosEs();
					datoe.setIdCiclo(ci.getIdCiclo());
					datoe.setIdAlumno(Integer.parseInt(aq.ciA(a.getNoControl())));
					datoe.setIdDocente(d.getIdDocente());
					datoe.setEstaRepitiendo("N");
					datoe.setEstadoEscolar("Cu");
					datoe.setEstatus("A");
					iq1.insertarDAES(datoe);
					red = true;
					rd = request.getRequestDispatcher("jsp/principal/inscripciones.jsp");
					break;
			}
			if (red == true)
			{
				rd.forward(request, response);
			}
//		} catch (NullPointerException n)
//		{
//			System.out.println("<<<Error>>>: " + n.getCause());
//		}
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