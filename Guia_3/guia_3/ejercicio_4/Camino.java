package guia_3.ejercicio_4;

import java.util.ArrayList;
import java.util.List;

public class Camino {
	public List<Coordenada> caminos;
	
	public Camino() {
		super();
		this.caminos = new ArrayList();
	}
	
	public void agregar(Coordenada x) {
		this.caminos.add(x);
	}
	
	public void agregar(double lat, double lng) {
		this.caminos.add(new Coordenada(lat,lng));
	}
	
	public void agregar(int mtsLt, int mtsLn) {
		Coordenada nuevaCoordenada;
		if(caminos.isEmpty()) {
			nuevaCoordenada = new Coordenada();
		} else {
			double ulat = this.caminos.get(this.caminos.size() -1).latitud;
			double ulon = this.caminos.get(this.caminos.size() -1).longitud;
			nuevaCoordenada = new Coordenada(ulat, ulon);
		}
		nuevaCoordenada.sumar(mtsLt, mtsLn);
		this.agregar(nuevaCoordenada);
	}
}
