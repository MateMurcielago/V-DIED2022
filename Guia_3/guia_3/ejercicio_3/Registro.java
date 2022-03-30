package guia_3.ejercicio_3;

import guia_3.ejercicio_2.Escala;
import guia_3.ejercicio_2.Temperatura;

public class Registro {
	private String ciudad;
	private Temperatura[] historico;
	private int capacidadDisp;
	
	public Registro() {
		super();
		this.ciudad = "-";
		this.historico = new Temperatura[30];
		this.capacidadDisp = 30;
	}
	
	public Registro(String ciudad) {
		super();
		this.ciudad = ciudad;
		this.historico = new Temperatura[30];
		this.capacidadDisp = 30;
	}
	
	public String getCiudad() {
		return this.ciudad;
	}
	
	public void imprimir() {
		System.out.print("Temperaturas registradas en: " + this.ciudad + "\n");
		for(int i = 0; i < (30 - this.capacidadDisp); i++) {
			System.out.print((i + 1) + " " + this.historico[i] + "\n");
		}
	}
	
	public void agregar(Temperatura t) {
		if(this.capacidadDisp != 0) {
			this.historico[30 - this.capacidadDisp] = t;
			this.capacidadDisp--;
		}
	}
	
	public Double mediaAsCelcius() {
		Double media = 0.0;
		for(int i = 0; i < 30 - this.capacidadDisp; i++) {
			if(this.historico[i].escala == Escala.CELCIUS) {
				media += this.historico[i].grados;
			} else {
				media += this.historico[i].asCelcius();
			}
		}
		media = media / (30 - this.capacidadDisp);
		return media;
	}

	public Double mediaAsFahrenheit() {
		Double media = 0.0;
		for(int i = 0; i < 30 - this.capacidadDisp; i++) {
			if(this.historico[i].escala == Escala.FAHRENHEIT) {
				media += this.historico[i].grados;
			} else {
				media += this.historico[i].asFahrenheit();
			}
		}
		media = media / (30 - this.capacidadDisp);
		return media;
	}
}
