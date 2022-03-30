package guia_3.ejercicio_1;

public class Recta {
	
	public Punto origen;
	public Punto fin;
	
	public Recta(Punto p1, Punto p2) {
		super();
		this.origen = p1;
		this.fin = p2;
	}
	
	public Recta() {
		super();
		this.origen = new Punto(0,0);
		this.fin = new Punto(1,1);
	}
	
	public float pendiente() {
		float m = ((fin.getY())-(origen.getY()))/((fin.getX())-(origen.getX()));
		return m;
	}
	
	public boolean paralelas(Object otraRecta) {
		if(otraRecta instanceof Recta) {
			if(this.pendiente() == ((Recta) otraRecta).pendiente()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean equals(Object otraRecta) {
		Recta aux;
		if(otraRecta instanceof Recta) {
			aux = new Recta(this.origen, ((Recta) otraRecta).fin);
			if(aux.pendiente() == this.pendiente() && aux.pendiente() == ((Recta) otraRecta).pendiente()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
