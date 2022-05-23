package guia_5.ejercicio_1;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Pasaje implements Comparable<Pasaje>{
	private int codigo;
	private int nro_vuelo;
	private String origen;
	private String destino;
	private Instant partida;
	private Instant arribo;
	private int asiento;
	private Pasajero pasajero;
	private double monto;
	private Servicio servicio;
	private String aerolinea;
	private Instant cancelacion;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getNro_vuelo() {
		return nro_vuelo;
	}
	
	public void setNro_vuelo(int nro_vuelo) {
		this.nro_vuelo = nro_vuelo;
	}
	
	public String getOrigen() {
		return origen;
	}
	
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public String getPartida(String formato) {
		return DateTimeFormatter.ofPattern(formato).format(this.partida);
	}
	
	private Instant getPartida() {
		return this.partida;
	}
	
	public void setPartida(Instant partida) {
		this.partida = partida;
		this.cancelacion = this.partida.minus(24, ChronoUnit.HOURS);
	}
	
	public String getArribo(String formato) {
		return DateTimeFormatter.ofPattern(formato).format(this.arribo);
	}
	
	public Instant getArribo() {
		return this.arribo;
	}
	
	public void setArribo(Instant arribo) {
		this.arribo = arribo;
	}
	
	public int getAsiento() {
		return asiento;
	}
	
	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}
	
	public Pasajero getPasajero() {
		return pasajero;
	}
	
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	public Servicio getServicio() {
		return servicio;
	}
	
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public String getAerolinea() {
		return aerolinea;
	}
	
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	public String getCancelacion(String formato) {
		return DateTimeFormatter.ofPattern(formato).format(this.cancelacion);
	}
	
	public boolean equals(Object otroPasaje) {
		if(this.getClass() == otroPasaje.getClass()) {
			if(this.getCodigo() == ((Pasaje) otroPasaje).getCodigo() && this.getOrigen().equals(((Pasaje) otroPasaje).getOrigen()) && this.getDestino().equals(((Pasaje) otroPasaje).getDestino())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Duration duracion() {
		return Duration.between(this.getArribo(), this.getPartida());
	}
	
	@Override
	public int compareTo(Pasaje o) {
		return (int) (this.getPartida().getEpochSecond() - o.getPartida().getEpochSecond());
	}
}
