package guia_5.ejercicio_2;

public abstract class Persona implements CriterioBusqueda<Localidad> {
	private String nombre;
	private Localidad localidad;
	
	public Persona(String nombre, Localidad localidad) {
		super();
		this.setNombre(nombre);
		this.setLocalidad(localidad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public Boolean esDeLocalidad(Localidad l) {
		if(this.getLocalidad().getNombre().equals(l)) {
			return true;
		} else {
			return false;
		}
	}
}
