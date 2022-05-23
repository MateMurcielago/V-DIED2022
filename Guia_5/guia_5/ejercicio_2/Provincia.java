package guia_5.ejercicio_2;

public class Provincia extends Ubicacion {
	private Pais pais;
	
	public Provincia(String nombre, Pais pais) {
		super(nombre);
		this.setPais(pais);
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
