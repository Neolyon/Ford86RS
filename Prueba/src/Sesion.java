import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Data.AlumnosQuerys;
import Data.DocentesQuerys;
import Data.SesionQuerys;
import Objects.Cargo;
import Objects.Docente;
import Objects.InfoDocente;
import Objects.Login;

@WebServlet(name="Sesion",urlPatterns="/Sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sesion() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		RequestDispatcher rd = request.getRequestDispatcher("jsp/principal/error.jsp");
		System.out.println("Opcion = " + op);
		System.out.println("ID = " + id);
		switch (op)
		{
			case "l":
				String u = request.getParameter("user");
				String p = request.getParameter("pass");
				SesionQuerys sq = new SesionQuerys();
				Login l = sq.ci(u, p);
				DocentesQuerys dq = new DocentesQuerys();
				Docente d = dq.ci(l.getIdLogin());
				System.out.println(d);
				InfoDocente i = dq.cInfoDocente(d.getIdInfoDocente());
				System.out.println(i);
				Cargo c = dq.cCargoDocente(d.getIdCargoDocente());
				System.out.println(c);
				if (l != null)
				{
					HttpSession sesion=request.getSession(true);
					sesion.setAttribute("sesion", l);
					sesion.setAttribute("docente", d);
					sesion.setAttribute("info", i);
					sesion.setAttribute("cargo", c);
					sesion.setMaxInactiveInterval(15*60);
					rd=request.getRequestDispatcher("jsp/principal/principal.jsp");
				}
				else
				{
					rd=request.getRequestDispatcher("jsp/principal/error.jsp");
				}
				break;
			case "im":
				id = request.getParameter("id");
				sq = new SesionQuerys();
				try
				{
					response.setContentType("image/jpg");
				    response.getOutputStream().write(sq.getImagen(id));
				    response.getOutputStream().flush();
				    response.getOutputStream().close();
				} catch (Exception e)
				{
					System.out.println("No existe la imagen");
				}
				break;
			case "gi":
				id = request.getParameter("id");
				InputStream inputStream = null; // input stream of the upload file
		        // obtains the upload file part in this multipart request
		        Part filePart = request.getPart("photo");
		        if (filePart != null) {
		            // prints out some information for debugging
		            System.out.println(filePart.getName());
		            System.out.println(filePart.getSize());
		            System.out.println(filePart.getContentType());

		            //obtains input stream of the upload file
		            //the InputStream will point to a stream that contains
		            //the contents of the file
		            inputStream = filePart.getInputStream();
		        }
		        
		        sq = new SesionQuerys();
		        sq.actualizarImagen(id, inputStream);
				break;
			case "cs":
				HttpSession sesion=request.getSession(false);
				sesion.invalidate();
				rd=request.getRequestDispatcher("jsp/login/login.jsp");
				break;
			case "s":
				rd=request.getRequestDispatcher("jsp/principal/exit.jsp");
				sesion = request.getSession(false);
				sesion.invalidate();
				break;
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
