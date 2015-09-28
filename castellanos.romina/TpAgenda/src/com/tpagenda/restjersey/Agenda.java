package com.tpagenda.restjersey;

 
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/agenda")
public class Agenda {
	
	@POST
	public String procesarDatos(
			@FormParam("nombre") String nombre,
			@FormParam("apellido") String apellido,
			@FormParam("domicilio") String domicilio,
			@FormParam("telefono") String telefono
			){
		System.out.println("Nombre:" + nombre);
		return "Hola Mundo " + nombre + apellido + domicilio + telefono;
	}
	
	@GET
	public String metodoprocesado(){
		return "Metodo Ejecutado";
	}
 
}