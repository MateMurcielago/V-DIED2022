package guia_5.ejercicio_1;

public class Pasajero {
	private String nombre;
	private String apellido;
	private String email;
	private int pasaporte;
	
	public Pasajero(String nombre, String apellido, String email, int pasaporte) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setPasaporte(pasaporte);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPasaporte(int pasaporte) {
		this.pasaporte = pasaporte;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getPasaporte() {
		return this.pasaporte;
	}
	
	public boolean equals(Object otroPasajero) {
		if(otroPasajero.getClass() == this.getClass()) {
			if(this.getEmail().equals(((Pasajero) otroPasajero).getEmail()) && this.getPasaporte() == ((Pasajero) otroPasajero).getPasaporte()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
