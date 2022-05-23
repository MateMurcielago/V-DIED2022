package guia_5.ejercicio_2;

public class Responsable extends Persona {
	private static int genID = 0;
	private int id;
	private String oficina;
	
	public Responsable(String nombre, String oficina, Localidad localidad) {
		super(nombre, localidad);
		this.setOficina(oficina);
		this.genID++;
		this.id = this.genID;
	}
	
	public int getId() {
		return id;
	}
	
	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
}
