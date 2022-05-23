package guia_5.ejercicio_2;

public abstract class Ubicacion {
	private static int genID = 0;
	private int id;
	private String nombre;
	
	public Ubicacion(String nombre) {
		super();
		this.setNombre(nombre);
		this.genID++;
		this.id = this.genID;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean equals(Object otroObjeto) {
		if(this.getClass() == otroObjeto.getClass()) {
			if(this.getId() == ((Ubicacion) otroObjeto).getId()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
