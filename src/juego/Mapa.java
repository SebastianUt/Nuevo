package juego;

import java.util.ArrayList;
import java.util.List;

import grafica.GraficoEnte;
import grafica.PanelMapa;
import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Obstaculo;
import juego.niveles.Nivel;

public class Mapa{

	
	private Celda[][] grilla;
	private List<Enemigo> enemigos;
	private List<Aliado> aliados;
	private PanelMapa panelMapa;
	
	public Mapa (PanelMapa p) {
		enemigos = new ArrayList<Enemigo>();
		aliados = new ArrayList<Aliado>();
		panelMapa = p;
		inicializarGrilla();
	}
	
	
	// Crea grilla y setea todas las celdas con anterior y siguiente
	protected void inicializarGrilla() {
		grilla = new Celda[6][10];
		for (int i = 0; i < 6; i++)
			for (int ii = 0; ii < 10; ii++)
				grilla[i][ii] = new Celda(i, ii);
		
		for (int i = 0; i < 6; i++)
			grilla[i][0].setDer(grilla[i][1]);
		
		for (int i = 0; i < 6; i++)
			grilla[i][9].setIzq(grilla[i][8]);
			
		for (int i = 0; i < 6; i++)
			for (int ii = 1; ii < 9; ii++) {
				grilla[i][ii].setDer(grilla[i][ii+1]);
				grilla[i][ii].setIzq(grilla[i][ii-1]);
			}
	}
	
	public List<Enemigo> getEnemigos () {
		return enemigos;
	}
	
	public void addEnemigo (Enemigo e, int fila, int columna) {
		enemigos.add(e);
		panelMapa.addEnte(e);
		e.init(grilla[fila][columna]);
	}
	
	@Deprecated
	public void addEnemigo (Enemigo e) {
		enemigos.add(e);
		panelMapa.addEnte(e);
	}

	public void addAliado (Aliado a, int fila, int columna) {
		aliados.add(a);
		panelMapa.addEnte(a);
		a.init(grilla[fila][columna]);
	}
	
	@Deprecated
	public void addAliado (Aliado a) {
		aliados.add(a);
		panelMapa.addEnte(a);
	}

	public void addObstaculo (Obstaculo o, int fila, int columna) {
		panelMapa.addEnte(o);
		o.init(grilla[fila][columna]);
	}
	
	@Deprecated
	public void addObstaculo (Obstaculo o) {
		panelMapa.addEnte(o);
	}
	
	public void mover() {
		List<Integer> enemigosMuertos = new ArrayList<Integer>();
		for (int i=0; i<enemigos.size(); i++) {
			Enemigo e = enemigos.get(i);
			if (e.getVida() <= 0) {
				//juego.sumarPuntos(e.getPuntos());
				enemigosMuertos.add(i);
			}
			e.mover();
		}
		/*for (Integer i : enemigosMuertos) {
			enemigos.remove((int) i);
			System.out.println("Removido");
		}*/
	}
	
	public void atacar () {
		List<Integer> aliadosMuertos = new ArrayList<Integer>();
		for (int i=0; i<aliados.size(); i++) {
			Aliado a = aliados.get(i);
			if (a.getVida() <= 0) 
				aliadosMuertos.add(i);
			else 
				a.atacar();
		}
		for (Integer i : aliadosMuertos) {
			GraficoEnte grafico = aliados.get((int) i).getGrafico();
			grafico.setVisible(false);
			grafico.morir();
			aliados.remove((int) i);
		}

		List<Integer> enemigosMuertos = new ArrayList<Integer>();
		for (int i=0; i<enemigos.size(); i++) {
			Enemigo e = enemigos.get(i);
			if (e.getVida() <= 0) 
				enemigosMuertos.add(i);
			else
				e.atacar();
		}
		for (Integer i : enemigosMuertos) {
			GraficoEnte grafico = enemigos.get((int) i).getGrafico();
			grafico.setVisible(false);
			grafico.morir();
			enemigos.remove((int) i);
		}
	}
	
	
	// TODO: elimnar esto, es solo para testear
	public Celda getCelda(int f, int c) {
		return grilla[f][c];
	}
	
}