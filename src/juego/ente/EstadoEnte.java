package juego.ente;

public abstract class EstadoEnte {
	
	protected int index;
	
	public boolean enMovimiento () {
		return false;
	}
	
	public int getIndex () {
		return index;
	}
	
}
