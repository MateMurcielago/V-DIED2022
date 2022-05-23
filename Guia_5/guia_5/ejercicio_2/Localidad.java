package guia_5.ejercicio_2;

public class Localidad extends Ubicacion {
	private Provincia provincia;
	
	public Localidad(String nombre, Provincia provincia) {
		super(nombre);
		this.setProvincia(provincia);
	}
	
	public Provincia getProvincia() {
		return provincia;
	}
	
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
}
