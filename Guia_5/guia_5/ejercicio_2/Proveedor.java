package guia_5.ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona {
	private static int genID = 0;
	private int id;
	private List<Bien> bienes;
	
	public Proveedor(String nombre, Localidad localidad) {
		super(nombre, localidad);
		this.bienes = new ArrayList<Bien>();
		this.genID++;
		this.id = this.genID;
	}
	
	public int getId() {
		return id;
	}
	
	public void agregarBien(Bien bien) {
		this.bienes.add(bien);
	}
	
	public List<Bien> getBienes() {
		return this.bienes;
	}
}
