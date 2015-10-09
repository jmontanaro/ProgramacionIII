package com.Romina.restjersey;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/contactos")
public class Contactos {

	private static Collection contactosGuardados = new ArrayList<Contacto>();

	@POST
	public String procesarDatos(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido,
			@FormParam("domicilio") String domicilio, @FormParam("telefono") String telefono) {

		Contacto nuevocontacto = new Contacto();
		nuevocontacto.setNombre(nombre);
		nuevocontacto.setApellido(apellido);
		nuevocontacto.setDomicilio(domicilio);
		nuevocontacto.setTelefono(telefono);

		contactosGuardados.add(nuevocontacto);

		System.out.println(nuevocontacto);
		return "Nombre: " + nombre + " Apellido: " + apellido + " Domicilio: " + domicilio + " Telefono: " + telefono + " - guardados: " + contactosGuardados.size();

	}

	@GET
	public String metodoprocesado() {
		return "Metodo Ejecutado";
	}

}