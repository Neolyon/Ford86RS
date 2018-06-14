

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DocentesQuerys;
import Data.GruposQuerys;
import Data.MateriasQuerys;
import Data.SesionQuerys;
import Objects.Cargo;
import Objects.Ciclo;
import Objects.Docente;
import Objects.InfoDocente;
import Objects.Login;
import Objects.Materia;


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
		boolean red = false;
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
			case "i":
				String nom = request.getParameter("nom");
				String fecha = request.getParameter("fecha");
				String sexo = request.getParameter("sexo");
				String tel1 = request.getParameter("tel1");
				String tel2 = request.getParameter("tel2");
				String dom = request.getParameter("dom");
				String nomu = request.getParameter("nomu");
				String nivel = request.getParameter("nivel");
				String passu = request.getParameter("passu");
				String nip = request.getParameter("nip");
				
				System.out.println("Nom: " + nom);
				
				Docente  d = new Docente();
				InfoDocente info = new InfoDocente();
				Login lo = new Login();
				lo.setUsuario(nomu);
				lo.setPass(passu);
				lo.setNip(nip);
				lo.setNivel(nivel);
				lo.setEstatus("A");
				
				info.setNombre(nom);
				info.setFechaNacimiento(fecha);
				info.setSexo(sexo);
				info.setTelefono1(tel1);
				info.setTelefono2(tel2);
				info.setDomicilio(dom);
				info.setEstatus("A");
				
				dq = new DocentesQuerys();
				dq.insertarLogin(lo);
				dq.insertarInfo(info);
				
				d.setIdUsuario(dq.cLogin(nomu).getIdLogin());
				d.setIdInfoDocente(dq.cInfo(nom, fecha).getIdInfoDocente());
				d.setEstatus("A");
				d.setIdCargoDocente(0);
				
				dq.insertar(d);
				
				rd = request.getRequestDispatcher("Direccion?op=doc1");
				red = true;
				break;
			case "e":
					String nombre = request.getParameter("nombre");
					
					dq = new DocentesQuerys();
					InfoDocente indo = dq.cInfoDo(nombre);
					Docente doc = dq.cDo(indo.getIdInfoDocente());
					Login log = dq.cL(doc.getIdUsuario());
					Cargo c = dq.cCargoDocente(doc.getIdCargoDocente());
					
					if (dq.quitarCargo(c.getIdCargoDocente()+"") == true &&
							dq.quitarDocente(doc) == true && dq.quitarInfo(indo)
							&& dq.quitarLogin(log) == true)
					{
						System.out.println("Bien");
					}
					else
					{
						System.out.println("Eror al eliminar.");
					}
					rd = request.getRequestDispatcher("Direccion?op=doc2");
					red = true;
					break;
			case "cargo":
				nom = request.getParameter("nombre");
				String grupo = request.getParameter("grupo");
				String grado = request.getParameter("grado");
				String turno = request.getParameter("turno");
				String salon = request.getParameter("salon");
				String desc = request.getParameter("desc");
				String listam = request.getParameter("listaM");
				
				dq = new DocentesQuerys();
				indo = dq.cInfoDo(nom);
				doc = dq.cDo(indo.getIdInfoDocente());

				Cargo car = new Cargo();
				car.setIdGrupo(dq.cGrupo(grupo, turno, salon).getIdGrupo());
				c = dq.cCargoDocente(doc.getIdCargoDocente());
				int year = Calendar.getInstance().get(Calendar.YEAR);
				SesionQuerys sq = new SesionQuerys();
				Ciclo ci = sq.getCiclo((year-1) + "-" + year);
				car.setIdCiclo(ci.getIdCiclo());
				String a[] = listam.split(" ");
				String lis = "";
				for (int i = 0; i < a.length; i++)
				{
					if (i == 0)
					{
						lis = dq.cMateria(a[i]).getIdMateria()+"";
					}
					else
					{
						lis += " " + dq.cMateria(a[i]).getIdMateria();
					}
				}
				car.setListaMaterias(lis);
				car.setDescripcion(desc);
				car.setVigente("A");
				
				if (dq.insertaCargo(car) == true)
				{
					System.out.println("Cargo EXITO >>>>>>>>>>>>>>>>>");
				}
				
				String idC = dq.cCargoDoc(car.getIdGrupo()+"", car.getListaMaterias(), car.getDescripcion()).getIdCargoDocente()+"";
				dq.registrarCargo(doc.getIdDocente()+"", idC);
				
				rd = request.getRequestDispatcher("Direccion?op=doc3");
				red = true;
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
