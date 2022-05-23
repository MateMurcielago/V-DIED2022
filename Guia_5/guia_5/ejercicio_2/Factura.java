package guia_5.ejercicio_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
	private static int genID = 0;
	private int id;
	private double monto_total;
	private List<Lista<Bien, Integer>> bienes;
	private Responsable responsable;
	private Proveedor proveedor;
	private Date fecha;
	
	public Factura(Responsable responsable, Proveedor proveedor, Date fecha) {
		super();
		this.genID++;
		this.id = this.genID;
		this.bienes = new ArrayList<Lista<Bien, Integer>>();
		this.monto_total = 0.0;
		this.setResponsable(responsable);
		this.setProveedor(proveedor);
		this.setFecha(fecha);
	}

	public int getId() {
		return id;
	}

	public double getMonto_total() {
		return monto_total;
	}

	public void facturar() throws FacturaInvalidaException {
		int cant_total = 0;
		double cargo = 0.0;
		if(this.bienes.size() == 0) {
			throw new FacturaInvalidaException("Factura sin bienes.");
		} else {
			for(int i = 0; i < this.bienes.size(); i++) {
				this.monto_total += this.bienes.get(i).getObjeto().getPrecio() * this.bienes.get(i).getCantidad();
				cant_total += this.bienes.get(i).getCantidad();
			}
			if(cant_total > 10) {
				cargo -= (this.monto_total * 20) / 100;
			} else if(cant_total > 5) {
				cargo -= (this.monto_total * 10) / 100;
			}
			if(this.getResponsable().getLocalidad().equals(this.getProveedor().getLocalidad())) {
				cargo += (this.monto_total * 10) / 100;
			} else if(this.getResponsable().getLocalidad().getProvincia().equals(this.getProveedor().getLocalidad().getProvincia())) {
				cargo += (this.monto_total * 30) / 100;
			} else if(this.getResponsable().getLocalidad().getProvincia().getPais().equals(this.getProveedor().getLocalidad().getProvincia().getPais())) {
				cargo += (this.monto_total * 70) / 100;
			} else {
				throw new FacturaInvalidaException("Los proveedores no venden bienes a otros países.");
			}
			this.monto_total += cargo;
		}
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public List<Lista<Bien, Integer>> getBienes() {
		return this.bienes;
	}
	
	public void agregarBien(Bien bien, int cantidad) throws LimiteFacturaException {
		int cant = 0;
		if(bienes.size() == 0) {
			if(cantidad <= 20) {
				this.bienes.add(new Lista<Bien, Integer>(bien, cantidad));
			} else {
				throw new LimiteFacturaException("Las facturas no pueden permitirse más de 20 bienes.");
			}
		} else {
			for(int i = 0; i < this.bienes.size(); i++) {
				cant += bienes.get(i).getCantidad();
			}
			cant += cantidad;
			if(cant <= 20) {
				this.bienes.add(new Lista<Bien, Integer>(bien, cantidad));
			} else {
				throw new LimiteFacturaException("Las facturas no pueden permitirse más de 20 bienes.");
			}
		}
	}
	
	public int getCantidadTotal() {
		int cant = 0;
		for(int i = 0; i < this.bienes.size(); i++) {
			cant += this.bienes.get(i).getCantidad();
		}
		return cant;
	}
}
