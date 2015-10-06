package guardaragenda;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.FormParam;

@Path("/contacto")
public class Guardaragenda {
	
	static Collection listaContacto = new ArrayList<Contacto>();

	@POST
	public String imprimirdatosformulario (@FormParam("Apellido") String surname, @FormParam("Nombre") String name, 
			                             @FormParam("Direccion") String address, 
			                             @FormParam("Telefono") String telephone ) {

		Contacto contacto = new Contacto(name,surname,address,telephone);
		
		listaContacto.add(contacto);
		
		return "Cantidad de contactos: " + String.valueOf(listaContacto.size());
	} 
}
