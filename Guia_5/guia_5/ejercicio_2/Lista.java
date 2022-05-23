package guia_5.ejercicio_2;

public class Lista<T, N> {
	private T objeto;
	private N cantidad;
	
	public Lista(T objeto, N cantidad) {
		super();
		this.setObjeto(objeto);
		this.setCantidad(cantidad);
	}

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	public N getCantidad() {
		return cantidad;
	}

	public void setCantidad(N cantidad) {
		this.cantidad = cantidad;
	}
}
