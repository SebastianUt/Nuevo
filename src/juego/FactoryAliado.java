package juego;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Aliado;

public class FactoryAliado {
	// TODO: cambiarle el nomre a los constructores por Tanque, Melee, etc.
	// public Enemigo (int vida, int ataque, int cadencia, int rango, int velocidad)
	// public Enemigo (int vida, Celda celda, int ataque, int cadencia, int rango, int velocidad)
	
	// VIDA: 100 | ATAQUE: 20 | CADENCIA: 20 | RANGO: 2 | PRECIO: 0 
	public static Aliado crearSupport () {
		return new Aliado(100, 20, 20, 2, 0, "a1");
	}
	
	// VIDA: 80 | ATAQUE: 30 | CADENCIA: 35 | RANGO: 2 | PRECIO: 0
	public static Aliado crearCommando () {
		return new Aliado(80, 30, 35, 2, 0, "a2");
	}
	
	// VIDA: 100 | ATAQUE: 15 | CADENCIA: 25 | RANGO: 8 | PRECIO: 0
	public static Aliado crearSharpshooter () {
		return new Aliado(100, 15, 25, 8, 0, "a3");
	}
	
	public static Aliado crearAliado (String tipo) {
		Aliado aliado;
		switch(tipo) {
			case("e1"): aliado = crearSupport(); break;
			case("e2"): aliado = crearCommando(); break;
			case("e3"): aliado = crearSharpshooter(); break;
			default: aliado = null;
		}
		return aliado;
	}

}