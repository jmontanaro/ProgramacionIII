package com.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarFormServlet
 */
@WebServlet("/MostrarFormServlet")
/**
 * 
 * @author NicolasAriel
 *
 */
public class MostrarFormServlet extends HttpServlet {
		
	/* Agrego esta linea porque me la pide la clase */
	private static final long serialVersionUID = 1L;
    
    public MostrarFormServlet() {
        super();
    }
    
    /**
     * Aca vamos a declarar las clases doGet y doPost del Servlet
     */
    
    /**
     * Dejamos en blanco la clase doGet ya que por el momento no vamos a estar haciendo uso de ella
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    }

    /**
     * Declaramos la clase doPost para la cual vamos a ejecutar todo metodo que provenga bajo ese valor
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         PrintWriter out = response.getWriter();

         /**
          * Armo el archivo CSS tomando las variables del formulario
          */
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<style>");
         out.println("body { background-color: #d0e4fe;}");
         out.println("h1 {color: orange;text-align: center;}");
         out.println("p {font-family: Arial, sans-serif;font-size: 20px;font-weight: normal;font-weight: bold;}");
         out.println("t {font-family: Arial, sans-serif;font-size: 14px;font-weight: normal;color:#99cc00;}");
         out.println("</style>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Metodo Ejecutado</h1>");
         out.println("<p>Datos recibidos:</p>");
        
         out.println("<t>Nombre:</t>");
         String nom=request.getParameter("nombre");
         out.println(nom);
         out.println("<br>");
         out.println("<t>Apellido:</t>");         
         String ape=request.getParameter("apellido");
         out.println(ape);
         out.println("<br>");
         out.println("<t>Telefono:</t>");
         String tel=request.getParameter("telefono");
         out.println(tel);
         out.println("<br>");
         out.println("<t>Direccion:</t>");
         String dir=request.getParameter("direccion");
         out.println(dir);
                 
         out.println("</body>");
         out.println("</html>");           
    }
}