package juego.ente;

public class Celda {
	
	public final int fila, columna;
	
	private EfectoCelda efecto;
	private Ente ente;
	private Celda izq, der;
	
	public Celda (int f, int c) {
		fila = f;
		columna = c;
	}
	
	public Celda getIzq() {
		return izq;
	}
	
	public Celda getDer() {
		return der;
	}
	
	public void setIzq(Celda c) {
		izq = c;
	}
	
	public void setDer(Celda c) {
		der = c;
	}
	
	public Ente getEnte() {
		return ente;
	}
	
	public void setEnte(Ente e) {
		ente = e;
	}
	
	public EfectoCelda getEfecto() {
		return efecto;
	}
	
	public void setEfecto(EfectoCelda efecto) {
		this.efecto = efecto;
	}

}
