package guia_5.ejercicio_2;

public class Bien {
	private static int genID = 0;
	private int id;
	private String alias;
	private String descrpicion;
	private double precio;
	private Responsable responsable;
	
	public Bien(String alias, String descripcion, double precio, Responsable responsable) {
		this.setAlias(alias);
		this.setDescrpicion(descripcion);
		this.setPrecio(precio);
		this.setResponsable(responsable);
		this.genID++;
		this.id = this.genID;
	}

	public int getId() {
		return id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDescrpicion() {
		return descrpicion;
	}

	public void setDescrpicion(String descrpicion) {
		this.descrpicion = descrpicion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
}
