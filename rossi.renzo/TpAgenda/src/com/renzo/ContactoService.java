package com.renzo;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
 

@Path("/contactos")
public class ContactoService {

	private static Collection contactosGuardados = new ArrayList<Contacto> () ;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response procesarDatos (@FormParam("Nombre") String nombre, 
								 @FormParam("Apellido") String apellido, 
								 @FormParam("Direccion") String direccion, 
								 @FormParam("Tel")  String telefono){
				
		Contacto nuevoContacto = new Contacto();
		nuevoContacto.setID(contactosGuardados.size() + 1);
		nuevoContacto.setNombre(nombre);
		nuevoContacto.setApellido(apellido);
		nuevoContacto.setDireccion(direccion);
		nuevoContacto.setTelefono(telefono);
		
		contactosGuardados.add(nuevoContacto);

		System.out.println(nuevoContacto);
		System.out.println ("Cantidad de contactos: " + contactosGuardados.size()) ;
		
	
	
		return Response.ok(nuevoContacto).build();		
	} 
	

	
}
