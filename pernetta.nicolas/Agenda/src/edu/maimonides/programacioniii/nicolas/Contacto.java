package edu.maimonides.programacioniii.nicolas;
/**
 * 
 * @author NicolasAriel
 *
 */

public class Contacto {

	private int id;
	private String nombre; 
	private String apellido;
	private String telefono;
	private String direccion;
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono ( String telefono ) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion ( String direccion ) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", telefono=" + telefono + ", direccion="
				+ direccion + "]";
	}
}