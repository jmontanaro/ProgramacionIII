package com.renzo;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
 

@Path("/contactos")
@Produces(MediaType.APPLICATION_JSON)

public class ContactoService {

	private static Map<Integer , Contacto> contactosGuardados = new HashMap<Integer , Contacto> () ;
	
	@POST
	
	public Response procesarDatos (@FormParam("Nombre") String nombre, 
								 @FormParam("Apellido") String apellido, 
								 @FormParam("Direccion") String direccion, 
								 @FormParam("Tel")  String telefono){
				
		Integer nuevoId = (contactosGuardados.size() + 1);
		
		Contacto nuevoContacto = new Contacto();
		nuevoContacto.setID(nuevoId);
		nuevoContacto.setNombre(nombre);
		nuevoContacto.setApellido(apellido);
		nuevoContacto.setDireccion(direccion);
		nuevoContacto.setTelefono(telefono);
		
		contactosGuardados.put(nuevoId , nuevoContacto);

		System.out.println(nuevoContacto);
		System.out.println ("Cantidad de contactos: " + contactosGuardados.size()) ;
		
		
		return Response.ok(nuevoContacto).build();		
	}
	
	@Path("/{ID}")
	@GET
	public Response getUno (@PathParam("ID") Integer id) {
		boolean buscaNobusca = contactosGuardados.containsKey(id);
		if (buscaNobusca){
			Contacto contactoBuscado = contactosGuardados.get(id);
			return Response.ok(contactoBuscado).build() ;
		}
		 
		return Response.status(Status.NOT_FOUND).build();
		}
	
//	@GET
//	public Response getTodo (){
//		contactosGuardados.values();
//		
//		return Response.ok(contactosGuardados).build();
//	}
//	
	
	@GET
	public Response filtro(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido,
			@QueryParam("inicial") String inicial, @QueryParam("direccion") String direccion) {
	
			
		List<Contacto> listFilter= new ArrayList <Contacto> (contactosGuardados.values() );
		
		if(listFilter.isEmpty()){
			System.out.println("No hay datos ingresados");
			return Response.noContent().build();
		}
		
		listFilter = filtrarNombre(nombre, listFilter);
		listFilter = filtrarApellido(apellido, listFilter);
		listFilter = filtrarInicial(inicial, listFilter);
		listFilter = filtrarDireccion(direccion, listFilter);
		
		return Response.ok(listFilter).build();
	}
	
	//Filtro Nombre
	private List<Contacto> filtrarNombre(String nombre, List<Contacto> lista){
		
		List<Contacto> filtrada = new ArrayList<Contacto>();
		
		if(nombre == null || nombre.isEmpty()){
			return lista;
		}
		for( Contacto c : lista ){
			if(c.getNombre().equalsIgnoreCase(nombre)){
				filtrada.add(c);
			}
		}
		return filtrada;
	}
	
	//Filtro Apellido
	private List<Contacto> filtrarApellido(String apellido, List<Contacto> lista){
		List<Contacto> filtrada = new ArrayList<Contacto>();
		
		if(apellido ==null || apellido.isEmpty()){
			return lista;
		}
		
		for( Contacto c : lista ){
			if(c.getApellido().equalsIgnoreCase(apellido)){
				filtrada.add(c);
			}
		}
		return filtrada;
	}
	
	//Filtro Inicial Nombre
	private List<Contacto> filtrarInicial(String inicial, List<Contacto> lista){
		List<Contacto> filtrada = new ArrayList<Contacto>();
		
		if(inicial ==null || inicial.isEmpty()){
			return lista;
		}
		for( Contacto c : lista ){
			if(c.getNombre().toLowerCase().startsWith(inicial.toLowerCase())){
				filtrada.add(c);
			}
		}
		return filtrada;
	}
	
	//Filtro Direccion
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
