package juego;

import juego.acciones.Accion;

public class Mercado {

	private Accion accionPlaceHolder;
	private int monedas;
	
	public void sumarMonedas (int m) {
		monedas += m;
	}

	public void addToPlaceHolder(Accion a) {
		accionPlaceHolder = a;
	}
	
	public boolean isPlaceHolderFull () {
		return accionPlaceHolder != null;
	}
	
	public Accion getPlaceHolderContent () {
		Accion a = accionPlaceHolder;
		accionPlaceHolder = null;
		return a;
	}
	
}
