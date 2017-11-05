package juego.ente;

import grafica.GraficoEnte;
import juego.visitor.Visitor;

/*
 * TODO: algunos obstaculos tienen que ser comprables
 */

public class Obstaculo extends Ente {
	
	public Obstaculo(int vida) {
		super(vida);
		grafica = new GraficoEnte(this, "a2");
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
