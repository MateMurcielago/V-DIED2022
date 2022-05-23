package guia_5.ejercicio_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class RegistroViajes {
	private List<Pasaje> viajes;
	
	public RegistroViajes() {
		super();
		this.viajes = new ArrayList<Pasaje>();
	}
	
	//public List<Pasaje> getViajes(){
	//	return this.viajes;
	//}
	
	public void agregarViaje(Pasaje p) throws Exception {
		if(this.viajes.stream().filter(v -> v.getCodigo() == p.getCodigo()).findFirst().isEmpty()) {
			this.viajes.add(p);
		} else {
			throw new PasajeExistenteException("El viaje ya se encuentra registrado");
		}
	}
	
	public List<Pasaje> listarPorPrecio() {
		return this.viajes.stream().sorted((v1, v2) -> v2.compareTo(v1)).collect(Collectors.toList());
	}
	
	public List<Pasaje> buscarOoD(String origen, String destino) {
		return this.viajes.stream().filter(v -> v.getOrigen().equals(origen) || v.getDestino().equals(destino)).collect(Collectors.toList());
	}
	
	//public List<Pasaje> buscarCyP(int codigo, Pasajero p) {
	//	return this.viajes.stream().filter(v -> v.getCodigo() == codigo && v.getPasajero().equals(p)).collect(Collectors.toList());
	//}
	
	public Optional<List<Pasaje>> buscarCyP(int codigo, Pasajero p){
		List<Pasaje> resultado = null;
		List<Pasaje> a = this.viajes.stream().filter(v -> v.getCodigo() == codigo && v.getPasajero().equals(p)).collect(Collectors.toList());
		if(a.isEmpty()) {
			return Optional.ofNullable(resultado);
		} else {
			return Optional.of(a);
		}
	}
	
	public OptionalDouble promedioPasajero(Pasajero p) {
		return this.viajes.stream().filter(v -> v.getPasajero().equals(p)).mapToDouble(v -> v.getMonto()).average();
	}
}
