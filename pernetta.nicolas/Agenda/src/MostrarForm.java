import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 
 * @author NicolasAriel
 *
 */

@Path("/mostrarForm")
public class MostrarForm {
		
	static Collection listaContacto = new ArrayList<Contacto>();
		
	@POST	
	
    public static String imprimeEnConsola(@FormParam("nombre") String nombre, 
    		@FormParam("apellido") String apellido,
    		@FormParam("telefono") String telefono, 
    		@FormParam("direccion") String direccion) {
    
		Contacto contacto1 = new Contacto();
		contacto1.setNombre(nombre);
		contacto1.setApellido(apellido);
		contacto1.setTelefono(telefono);
		contacto1.setDireccion(direccion);
		
		listaContacto.add(contacto1);
						
		System.out.println(listaContacto.size());
		
    	return String.valueOf(listaContacto.size());
    	
    }
}