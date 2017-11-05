package juego.visitor;

import juego.ente.Aliado;
import juego.ente.Enemigo;
import juego.ente.Obstaculo;

public interface Visitor {
	public void visit(Aliado a);
	public void visit(Enemigo e);
	public void visit(Obstaculo o);
	public void reset();
}
