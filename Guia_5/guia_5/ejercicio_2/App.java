package guia_5.ejercicio_2;

import java.time.Instant;
import java.util.Date;

public class App {

	public static void main(String[] args) {
		Empresa e = new Empresa();
		Pais argentina = new Pais("Argentina");
		Provincia santa_fe = new Provincia("Santa Fe", argentina);
		Localidad rosario = new Localidad("Rosario", santa_fe);
		Provincia entre_rios = new Provincia("Entre Rios", argentina);
		Localidad tala = new Localidad("Rosario del Tala", entre_rios);
		Responsable r = new Responsable("Ezequiel Vianco", "Compras", tala);
		e.agregarResponsable(r);
		Proveedor p1 = new Proveedor("Martin Dominguez", rosario);
		e.agregarProveedor(p1);
		Proveedor p2 = new Proveedor("Leandro Amarillo", rosario);
		e.agregarProveedor(p2);
		Bien b = new Bien("a", "Un poco de... a", 19.99, r);
		e.agregarBien(b);
		Factura f1 = new Factura(r, p1, Date.from(Instant.now()));
		try{
			f1.agregarBien(b, 15);
		} catch (Exception ee) {
			System.out.println("Error: " + ee.getMessage());
		}
		e.agregarFactura(f1);
		e.facturar(f1);
		Factura f2 = new Factura(r, p2, Date.from(Instant.now()));
		try{
			f2.agregarBien(b, 19);
		} catch (Exception ee) {
			System.out.println("Error: " + ee.getMessage());
		}
		e.agregarFactura(f2);
		e.facturar(f2);
		System.out.println(e.listarFacturadasPorProveedor(p1).get(0));
		System.out.println(e.listarFacturadasPorProveedor(p2).get(0));
	}

}
