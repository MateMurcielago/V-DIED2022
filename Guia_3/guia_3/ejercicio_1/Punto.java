package guia_3.ejercicio_1;

public class Punto {
	
	private float x;
	private float y;
	
	public Punto(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setX(float nuevoValor) {
		this.x = nuevoValor;
	}
	
	public void setY(float nuevoValor) {
		this.y = nuevoValor;
	}
	
	public boolean equals(Object otroPunto) {
		if(otroPunto instanceof Punto) {
			if(((Punto) otroPunto).getX() == this.getX() && ((Punto) otroPunto).getY() == this.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
