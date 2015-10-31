package com.Romina.restjersey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/contactos")
@Produces(MediaType.APPLICATION_JSON)
public class Contactos {

	private static Map<Integer, Contacto> contactosGuardados = new HashMap<Integer, Contacto>();

	@POST
	public Response procesarDatos(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido,
			@FormParam("domicilio") String domicilio, @FormParam("telefono") String telefono) {

		Integer clave = contactosGuardados.size() + 1;
		Contacto nuevocontacto = new Contacto();
		nuevocontacto.setID(clave);
		nuevocontacto.setNombre(nombre);
		nuevocontacto.setApellido(apellido);
		nuevocontacto.setDomicilio(domicilio);
		nuevocontacto.setTelefono(telefono);

		contactosGuardados.put(clave, nuevocontacto);

		System.out.println(nuevocontacto);
		return Response.ok(nuevocontacto).build();
	}

	@GET
	@Path("{Id}")
	public Response getUno(@PathParam("Id") Integer id) {

		contactosGuardados.containsKey(id);
		Contacto BuscarContacto = contactosGuardados.get(id);

		return Response.ok(BuscarContacto).build();

	}

	@GET
	// agregar todos los parametros nombre, apellido, etc.
	public Response getFiltrados(@QueryParam("filtroNombre") String filtroNombre,
			@QueryParam("filtroApellido") String filtroApellido, @QueryParam("filtroInicial") String filtroInicial,
			@QueryParam("filtroDomicilio") String filtroDomicilio) {
		
		System.out.println(String.format("filtros: nombre [%s] apellido [%s] inicial [%s] domicilio [%s]", filtroNombre, filtroApellido, filtroInicial, filtroDomicilio));
		// contactosGuardados.values()
		Collection<Contacto> result = contactosGuardados.values();

		result = filtrarNombre(filtroNombre, result);
		//System.out.println(result.size());
		result = filtrarApellido(filtroApellido, result);
		//System.out.println(result.size());
		
		result = filtrarInicial(filtroInicial, result);
		//System.out.println(result.size());
		
		result = filtrarDomicilio(filtroDomicilio, result);
		//System.out.println(result.size());

		return Response.ok(result).build();
		//return Response.ok(contactosGuardados.values()).build(); 
	}

	// Por Nombre
	private Collection<Contacto> filtrarNombre(String nombreFiltrado, Collection<Contacto> result) {

		Collection<Contacto> filtrada = new ArrayList<Contacto>();

		if (nombreFiltrado == null || nombreFiltrado.isEmpty())
			return result;

		for (Contacto c : result) {
			if (c.getNombre().equalsIgnoreCase(nombreFiltrado)) {
				filtrada.add(c);
			}
		
		}
		return filtrada;
	}

	// Por Apellido
	private Collection<Contacto> filtrarApellido(String apellidoFiltrado, Collection<Contacto> result) {

		Collection<Contacto> filtrada = new ArrayList<Contacto>();

		if (apellidoFiltrado == null || apellidoFiltrado.isEmpty())
			return result;

		for (Contacto c : result) {
			if (c.getApellido().equalsIgnoreCase(apellidoFiltrado)) {
				filtrada.add(c);
			}

		}
		return filtrada;

	}

	// Por Inicial del Nombre
	private Collection<Contacto> filtrarInicial(String inicialFiltrado, Collection<Contacto> result) {

		Collection<Contacto> filtrada = new ArrayList<Contacto>();

		if (inicialFiltrado == null || inicialFiltrado.isEmpty())
			return result;

		for (Contacto c : result) {
			if (c.getNombre().startsWith(inicialFiltrado)) {
				filtrada.add(c);
			}
			
		}
		return filtrada;
	}

	// Por Domicilio
	private Collection<Contacto> filtrarDomicilio(String domicilioFiltrado, Collection<Contacto> result) {

		Collection<Contacto> filtrada = new ArrayList<Contacto>();

		if (domicilioFiltrado == null || domicilioFiltrado.isEmpty())
			return result;

		for (Contacto c : result) {
			if (c.getDomicilio() != null && c.getDomicilio().toLowerCase().contains(domicilioFiltrado.toLowerCase())) {
				filtrada.add(c);
			}
		}
		return filtrada;
	}
}