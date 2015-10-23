package agendatp3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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


@Path("/contacto")
@Produces({MediaType.APPLICATION_JSON})
public class Agendatp3 {
	//static List<Contacto> listaContacto = new ArrayList<Contacto>();
	static int id;
	static Map<Integer,Contacto> mapContacto = new HashMap<Integer, Contacto>();
	@POST
	  public Response imprimirdatosformulario (@FormParam("Apellido") String surname, @FormParam("Nombre") String name, 
			                             @FormParam("Direccion") String address, 
			                             @FormParam("Telefono") String telephone ) {
		id = id + 1;
		Contacto contacto = new Contacto(id,name,surname,address,telephone);
		
		mapContacto.put(id, contacto);
		
		return Response.ok().entity(contacto).build();

	}
	
	@GET 
	
	//public Response recuperartodo() {
		
	//	return Response.ok().entity(mapContacto.values()).build();
	//}
	
	public Response filtrar(@QueryParam("nombre") String name, @QueryParam("apellido") String surname,
							@QueryParam("inicialnombre") String initname, @QueryParam("calledireccion") String streetadress){
	
		List<Contacto> listaresultado = new ArrayList<Contacto> (mapContacto.values());
		
		listaresultado = filtrarNombre(name,listaresultado);
		
		listaresultado = filtrarApellido(surname,listaresultado);
		
		listaresultado = filtrarInicialNombre(initname,listaresultado);
		
		listaresultado = filtrarCalleDireccion(streetadress,listaresultado);
		
			return Response.ok().entity(listaresultado).build();
		}
	
	private List<Contacto> filtrarNombre(String name, List<Contacto> listaresultado) {
		
		if((name == null) || (name.isEmpty())) {
			
			return listaresultado;
		}
		
		List<Contacto> filtrado = new ArrayList<Contacto>();
		
		Iterator<Contacto> it = listaresultado.iterator();
				
		while (it.hasNext()) {
			
			Contacto prueba = (Contacto)it.next();
			
			if(prueba.getNombre().equals(name)) {
				
				
				filtrado.add(prueba);
				
			}
		}
		
		return filtrado;
		
	}
	
	private List<Contacto> filtrarApellido(String surname, List<Contacto> listaresultado) {
		
		if((surname == null) || (surname.isEmpty())) {
			
			return listaresultado;
		}
		
		List<Contacto> filtrado = new ArrayList<Contacto>();
		
		Iterator<Contacto> it = listaresultado.iterator();
		
		while (it.hasNext()) {
			
			Contacto prueba = (Contacto)it.next();
			
			if(prueba.getApellido().equals(surname)) {
				
				filtrado.add(prueba);
			}
		}
		
		return filtrado;
		
	}
	
	private List<Contacto> filtrarInicialNombre(String initname, List<Contacto> listaresultado) {
		
		if((initname == null) || (initname.isEmpty())) {
			
			return listaresultado;
		}
		
		List<Contacto> filtrado = new ArrayList<Contacto>();
		
		Iterator<Contacto> it = listaresultado.iterator();
		
		while (it.hasNext()) {
			
			Contacto prueba = (Contacto)it.next();
			
			if(prueba.getNombre().startsWith(initname)) {
				
				filtrado.add(prueba);
			}
		}
		
		return filtrado;
		
	}
private List<Contacto> filtrarCalleDireccion(String streetadress, List<Contacto> listaresultado) {
		
		if((streetadress == null) || (streetadress.isEmpty())) {
			
			return listaresultado;
		}
		
		List<Contacto> filtrado = new ArrayList<Contacto>();
		
		Iterator<Contacto> it = listaresultado.iterator();
		
		while (it.hasNext()) {
			
			Contacto prueba = (Contacto)it.next();
			
			if(prueba.getDireccion().contains(streetadress)) {
				
				filtrado.add(prueba);
			}
		}
		
		return filtrado;
		
	}
	@Path("/{id}")
	@GET
	public Response recuperarporid (@PathParam("id") Integer id) {
		
		if(mapContacto.containsKey(id)){
			Contacto contacto = mapContacto.get(id);
			return Response.ok().entity(contacto).build();}
		else {
			return Response.status(404).build();}
	}
	
	
}
