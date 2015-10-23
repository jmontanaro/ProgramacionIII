package edu.maimonides.programacioniii.nicolas;
import java.util.ArrayList;
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
import javax.ws.rs.core.Response.Status;

/**
 * 
 * @author NicolasAriel
 *
 */

@Path("/contacto")
@Produces(MediaType.APPLICATION_JSON)
public class MostrarForm {
	
	static Map<Integer, Contacto> mapContacto = new HashMap<Integer, Contacto>();
		
	private static Integer ID_GENERATOR=0;
	
	@POST
	//Clase de envio de datos de nuevo contacto
	public Response postcontacto(@FormParam("nombre") String nombre, 
    		@FormParam("apellido") String apellido,
    		@FormParam("telefono") String telefono, 
    		@FormParam("direccion") String direccion) {
		
		if(mapContacto.isEmpty()){
			System.out.println("Ingrese datos a cargar");
			return Response.noContent().build();
		}
			
		Integer idn = ++ID_GENERATOR;
		
		Contacto nuevocontacto = new Contacto();
		nuevocontacto.setId(idn);
		nuevocontacto.setNombre(nombre);
		nuevocontacto.setApellido(apellido);
		nuevocontacto.setTelefono(telefono);
		nuevocontacto.setDireccion(direccion);
		
		mapContacto.put(idn, nuevocontacto);

		//System.out.println(nuevocontacto);
		
		return Response.ok(nuevocontacto).build();
    }
	
	@GET
	@Path("/{id}")
	//Clase de busqueda por ID en barra de direcciones
	public Response getporid(@PathParam("id") Integer id){
		
		if(!mapContacto.containsKey(id)){
			System.out.println("ID Inexistente");
			return Response.status(Status.NOT_FOUND).build();
		}
		
		Contacto listabusqueda = mapContacto.get(id);
		
		//System.out.println(listabusqueda);
		
		return Response.ok(listabusqueda).build();
	}

	@GET
	//Clase de filtro para retornar la busqueda realizada
	public Response filtro(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido,
			@QueryParam("inicial") String inicial, @QueryParam("direccion") String direccion) {
	
			
	//	List<Contacto> resultado = (List<Contacto>) mapContacto.values();
		List<Contacto> resultado = new ArrayList<Contacto>(mapContacto.values());
		
		if(resultado.isEmpty()){
			System.out.println("Base de Datos Vacia - Ingrese Datos");
			return Response.noContent().build();
		}
		
		resultado = filtrarNombre(nombre, resultado);
		resultado = filtrarApellido(apellido, resultado);
		resultado = filtrarInicial(inicial, resultado);
		resultado = filtrarDireccion(direccion, resultado);
		
		//System.out.println(resultado);
		
		return Response.ok(resultado).build();
	}
	
	//Filtro lista por nombre
	private List<Contacto> filtrarNombre(String nombre, List<Contacto> lista){
		List<Contacto> filtrada = new ArrayList<Contacto>();
		
		if(nombre ==null || nombre.isEmpty()){
			return lista;
		}
		for( Contacto c : lista ){
			if(c.getNombre().equals(nombre)){
				filtrada.add(c);
			}
		}
		return filtrada;
	}
	
	//Filtro lista por apellido
	private List<Contacto> filtrarApellido(String apellido, List<Contacto> lista){
		List<Contacto> filtrada = new ArrayList<Contacto>();
		
		if(apellido ==null || apellido.isEmpty()){
			return lista;
		}
		if(!lista.contains(apellido)){
			System.out.println("Apellido Inexistente");
		}
		for( Contacto c : lista ){
			if(c.getApellido().equals(apellido)){
				filtrada.add(c);
			}
		}
		return filtrada;
	}
	
	//Filtro lista por inicial en nombre
	private List<Contacto> filtrarInicial(String inicial, List<Contacto> lista){
		List<Contacto> filtrada = new ArrayList<Contacto>();
		
		if(inicial ==null || inicial.isEmpty()){
			return lista;
		}
		for( Contacto c : lista ){
			if(c.getNombre().startsWith(inicial)){
				filtrada.add(c);
			}
		}
		return filtrada;
	}
	
	//Filtro lista por direccion
	private List<Contacto> filtrarDireccion(String direccion, List<Contacto> lista){
		List<Contacto> filtrada = new ArrayList<Contacto>();
		if(direccion ==null || direccion.isEmpty()){
			return lista;
		}
		for( Contacto c : lista ){
			if(c.getDireccion().toLowerCase().contains(direccion.toLowerCase())){
				filtrada.add(c);
			}
		}
		return filtrada;
	}
}