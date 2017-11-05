package juego.ente.powerup;
import juego.ente.Personaje;

public class PowerUp {
	protected Personaje afectado;
	protected int duracion;
	protected int duracionMax;
	
	public PowerUp(Personaje p) {
		afectado=p;
		duracion=0;
	}
	
	protected PowerUp(Personaje p, int d) {
		afectado=p;
		duracionMax=d;
		duracion=d;
	}
	public void actualizar() {}
	
}
