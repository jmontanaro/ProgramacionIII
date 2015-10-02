package com.Renzo;

import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;


@Path("/contactos")
public class Contactos {

	
	@POST
	public String procesarDatos (@FormParam("Nombre") String Nombre, 
								 @FormParam("Apellido") String Apellido, 
								 @FormParam("Direccion") String Direccion, 
								 @FormParam("Tel")  String Telefono){
		System.out.println("Nombre: " + Nombre);
		System.out.println("Apellido: " + Apellido);
		System.out.println("Direccion: " + Direccion);
		System.out.println("Telefono: " + Telefono);
	
	return "Nombre: " + Nombre + " Apellido: " + Apellido + " Direccion: " + Direccion + " Telefono: " + Telefono;		
	} 
	

	
}