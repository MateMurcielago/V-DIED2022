package guia_5.ejercicio_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	private List<Bien> bienes;
	private List<Factura> facturas;
	private List<Proveedor> proveedores;
	private List<Responsable> responsables;
	
	public Empresa() {
		this.bienes = new ArrayList<Bien>();
		this.facturas = new ArrayList<Factura>();
		this.proveedores = new ArrayList<Proveedor>();
		this.responsables = new ArrayList<Responsable>();
	}
	
	public void nuevoBien(String alias, String descripcion, double precio, Responsable responsable) {
		this.bienes.add(new Bien(alias, descripcion, precio, responsable));
	}
	
	public void agregarBien(Bien b) {
		this.bienes.add(b);
	}
	
	public void nuevaFactura(Responsable responsable, Proveedor proveedor, Date fecha) {
		this.facturas.add(new Factura(responsable, proveedor, fecha));
	}
	
	public void agregarFactura(Factura f) {
		this.facturas.add(f);
	}
	
	public void nuevoProveedor(String nombre, Localidad localidad) {
		this.proveedores.add(new Proveedor(nombre, localidad));
	}
	
	public void agregarProveedor(Proveedor p) {
		this.proveedores.add(p);
	}
	
	public void nuevoResponsable(String nombre, String oficina, Localidad localidad) {
		this.responsables.add(new Responsable(nombre, oficina, localidad));
	}
	
	public void agregarResponsable(Responsable r) {
		this.responsables.add(r);
	}
	
	public List<Bien> getBienes() {
		return this.bienes;
	}
	
	public List<Factura> getFacturas() {
		return this.facturas;
	}
	
	public List<Proveedor> getProveedores() {
		return this.proveedores;
	}
	
	public List<Responsable> getResponsables() {
		return this.responsables;
	}
	
	public void agregarBien(Factura f, Bien b, int cantidad) {
		try {
			f.agregarBien(b, cantidad);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void agregarBien(int id_factura, int id_bien, int cantidad) {
		try {
			this.facturas.stream().filter(f -> (f.getId() == id_factura)).findFirst().get().agregarBien(this.bienes.stream().filter(b -> b.getId() == id_bien).findFirst().get(), cantidad);
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void facturar(Factura f) {
		try {
			f.facturar();
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void facturar(int id) {
		try {
			this.facturas.stream().filter(f -> (f.getId() == id)).findFirst().get().facturar();
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public ArrayList<Factura> listarFacturaByProveedor(Proveedor p) {
		return (ArrayList<Factura>) this.facturas.stream().filter(f -> f.getProveedor().getId() == p.getId()).collect(Collectors.toList());
	}
	
	public ArrayList<Factura> listarFacturaByResponsable(Responsable r) {
		return (ArrayList<Factura>) this.facturas.stream().filter(f -> f.getResponsable().getId() == r.getId()).collect(Collectors.toList());
	}
	
	public ArrayList<String> listarNombresProveedores(Localidad l) {
		return (ArrayList<String>) this.proveedores.stream().filter(p -> p.esDeLocalidad(l)).sorted(Comparator.comparing(Proveedor::getNombre)).map(p -> p.getNombre()).collect(Collectors.toList());
	}
	
	public ArrayList<Bien> listarBienesByLocalidad(Localidad l) {
		return (ArrayList<Bien>) this.bienes.stream().filter(b -> b.getResponsable().esDeLocalidad(l)).collect(Collectors.toList());
	}
	
	public ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor) {
		return (ArrayList<Bien>) this.bienes.stream().filter(b -> (b.getPrecio() > precioMayor)).collect(Collectors.toList());
	}
	
	public ArrayList<Factura> listarFacturasByMontoMayor(Double montoMayor) {
		return (ArrayList<Factura>) this.facturas.stream().filter(f -> f.getMonto_total() > montoMayor).collect(Collectors.toList());
	}
	
	public ArrayList<String> listarFacturadasPorProveedor(Proveedor p) {
		return (ArrayList<String>) this.facturas.stream().filter(f -> f.getProveedor().equals(p)).map(f -> "En la fecha " + f.getFecha().getDate() + "/" + (f.getFecha().getMonth() + 1) + "/" + (f.getFecha().getYear() + 1900) + ", " + f.getProveedor().getNombre() + " facturó con un total de $" + f.getMonto_total() + " con " + f.getCantidadTotal() + " bienes").collect(Collectors.toList());
	}
}
