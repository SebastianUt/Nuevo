package juego.ente.powerup;

import juego.ente.Personaje;

public class TiroRapido extends PowerUp{
	private int original;
	
		public TiroRapido(Personaje p){
			super(p,30);
		}
		
		public void actualizar(){
			int cadencia=afectado.getCadencia();
			if(duracion==duracionMax){
				original=cadencia;
				afectado.setCadencia(cadencia*3/4);
			}	
			if(duracion==0) {
				afectado.setCadencia(original);
				afectado.setPowerUp(new PowerUp(afectado));
			}
			else duracion--;
		}
			
}