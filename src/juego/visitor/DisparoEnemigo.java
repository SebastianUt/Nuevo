package juego.visitor;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;
import juego.ente.Obstaculo;
import grafica.GraficoDisparo;

//Ataques que realizan los enemigos
public class DisparoEnemigo implements Visitor {
	protected Enemigo enemigo;
	protected int rango;
	protected Celda celda;
	
	public DisparoEnemigo(Enemigo e) {
		enemigo = e;
	}
	
	public void reset() {
		celda = enemigo.getCelda();
		rango = enemigo.getRango();
	}
	
	public void visit(Enemigo e) {
		Ente aux = buscarEnte();
		if (aux != null)
			aux.accept(this);
	}
	
	public void visit(Aliado a) {
		enemigo.setCad(0);
		a.quitarVida(enemigo.getAtaque());
		new GraficoDisparo(a.getGrafico(), enemigo.getGrafico(), "izq");
	}
	
	public void visit(Obstaculo o) {
		enemigo.setCad(0);
		o.quitarVida(enemigo.getAtaque());
		new GraficoDisparo(o.getGrafico(), enemigo.getGrafico(), "izq");
	}
	
	//Busca la primer celda (a la izquierda) que contenga un ente dentro del rango de ataque
	private Ente buscarEnte() {
		Ente e = null;
		do {
			rango--;
			celda = celda.getIzq();
			if (celda != null)
				e = celda.getEnte();
		} while (rango > 0 && celda != null && e == null);
		return e;
	}
}