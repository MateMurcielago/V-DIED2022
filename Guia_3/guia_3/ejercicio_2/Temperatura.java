package guia_3.ejercicio_2;

public class Temperatura {
	public Double grados;
	public Escala escala;
	
	public Temperatura() {
		super();
		this.grados = 0.0;
		this.escala = Escala.CELCIUS;
	}
	
	public Temperatura(Double grados, Escala escala) {
		super();
		this.grados = grados;
		this.escala = escala;
	}
	
	public String toString() {
		String string = this.grados.toString();
		if(this.escala == Escala.CELCIUS) {
			string += " C°";
		} else {
			string += " F°";
		}
		return string;
	}
	
	public Double asCelcius() {
		if(this.escala == Escala.FAHRENHEIT) {
			return ((this.grados - 32) * 5/9) ;
		} else {
			return this.grados;
		}
	}
	
	public Double asFahrenheit() {
		if(this.escala == Escala.CELCIUS) {
			return (this.grados * 9/5 + 32);
		} else {
			return this.grados;
		}
	}
	
	public void aumentar(Temperatura t) {
		if(t.grados > 0.0) {
			if(t.escala == this.escala) {
				this.grados += t.grados;
			} else {
				if(t.escala == Escala.CELCIUS) {
					this.grados += t.asFahrenheit();
				} else {
					this.grados += t.asCelcius();
				}
			}
		}
	}
	
	public void disminuir(Temperatura t) {
		if(t.grados > 0.0) {
			if(t.escala == this.escala) {
				this.grados -= t.grados;
			} else {
				if(t.escala == Escala.CELCIUS) {
					this.grados -= t.asFahrenheit();
				} else {
					this.grados -= t.asCelcius();
				}
			}
		}
	}
}
