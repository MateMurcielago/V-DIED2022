package guia_3.ejercicio_4;

public class Coordenada {
	public double latitud;
	public double longitud;
	
	private static final double R_TIERRA = 6378.137;
	private static final double ALFA = (1/R_TIERRA) * (180/Math.PI);
	
	public Coordenada() {
		super();
		this.latitud = 0;
		this.longitud = 0;
	}
	
	public Coordenada(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public String toString() {
		return "(" + this.latitud + "," + this.longitud + ")";
	}
	
	public void sumar(int mtslt, int mtsln) {
		this.latitud += (mtslt * ALFA);
		this.longitud = this.longitud + (mtsln * ALFA) / Math.cos(this.latitud * Math.PI/180);
	}
}
