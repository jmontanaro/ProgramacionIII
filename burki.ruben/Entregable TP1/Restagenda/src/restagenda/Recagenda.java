package restagenda;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;

@Path("/contacto")
public class Recagenda {

	@POST
	public String imprimirdatosformulario (@FormParam("Apellido") String surname, @FormParam("Nombre") String name, 
			                             @FormParam("Direccion") String address, 
			                             @FormParam("Telefono") String telephone ) {
		System.out.println( "Apellido: " + surname );
		System.out.println( "Nombre: " + name );
		System.out.println( "Direccion: " + address );
		System.out.println( "Telefono: " + telephone );
		return "Metodo ejecutado";
	} 
}
