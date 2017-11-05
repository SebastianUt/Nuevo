package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;
import juego.ente.EstadoEnteMover;
import juego.ente.EstadoEnteParar;
import juego.Constantes;

public class GraficoEnemigo extends GraficoEnte {
	
	private float acumuladorPixeles;
	
	public GraficoEnemigo(Enemigo e, String name) {
		super(e, name);
	}
	
	
	public void mover() {
		Enemigo enemigo = (Enemigo) ente;
		
		Celda izq = enemigo.getCelda().getIzq();
		if (izq != null) {
			Ente enteIzq = izq.getEnte();
			if (enteIzq == null || enteIzq.getEstado().enMovimiento()) {
				int velocidad = enemigo.getVelocidad();
				
				float delta = 100f / velocidad;
				System.out.println(""+delta);
				int pixeles = (int) delta;
				acumuladorPixeles += delta - pixeles;
				
				pixeles += acumuladorPixeles;
				acumuladorPixeles -= (int) acumuladorPixeles;
				
				pos.setLocation(pos.x - pixeles, pos.y);
				ente.setEstado(new EstadoEnteMover()); // TODO: clase estática
				cambiarGrafico(ente.getEstado());
				return;
			} 
		}
		
		ente.setEstado(new EstadoEnteParar());	
		cambiarGrafico(ente.getEstado());

	}
	
}