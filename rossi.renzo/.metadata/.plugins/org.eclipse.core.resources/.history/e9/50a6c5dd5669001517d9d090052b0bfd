package com.Renzo;

import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;


@Path("/contactos")
public class Contactos {

	@POST
	public String procesarDatos (@FormParam("Nombre") String nombre, @FormParam("Apellido") String apellido, @FormParam("Direccion") String direccion, @FormParam("Tel")  int telefono){
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("Direccion: " + direccion);
		System.out.println("Telefono: " + telefono);
	return "Hola Mundo " + nombre + apellido + direccion + telefono;		
	} 
	
	 @GET
		 public String datosProcesados(){
		 return "Datos Procesados";
	 }
	
}
