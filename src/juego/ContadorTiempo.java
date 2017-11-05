package juego;
public class ContadorTiempo extends Thread {

	private Juego juego;

	ContadorTiempo(Juego j) {
		juego = j;
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.getMapa().atacar();
			juego.getMapa().mover();
		}
	}
}