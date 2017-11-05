	package grafica;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;
import juego.ente.EstadoEnte;
import juego.ente.EstadoEnteParar;
import juego.ente.Obstaculo;
import juego.Constantes;
import juego.Juego;

public class GraficoEnte extends JLabel{

	protected Ente ente;
	protected String name;
	protected Icon image[];
	protected String[] sufijosArchivos = {"_parar", "_morir", "_atacar", "_mover", "_frente"};
	
	protected JLabel barraVida;
	
	protected Point pos;
	
	public GraficoEnte(Ente e, String n) {
		name = n;
		ente = e;

		image = new Icon[5];
		image[0] = new ImageIcon(Constantes.path + name + sufijosArchivos[0] + ".gif"); //_parar
		image[1] = new ImageIcon(Constantes.path + name + sufijosArchivos[1] + ".gif"); //_morir
		image[2] = new ImageIcon(Constantes.path + name + sufijosArchivos[2] + ".gif"); //_atacar
		image[3] = new ImageIcon(Constantes.path + name + sufijosArchivos[3] + ".gif"); //_mover
		image[4] = new ImageIcon(Constantes.path + name + sufijosArchivos[4] + ".gif"); //_frente
	}
	
	/*public GraficoEnte(Aliado a, String name) {
		this.name = name;
		ente = a;
		image = new Icon[4];
		image[0] = new ImageIcon(Constantes.path + name + sufijosArchivos[0] + ".gif");
		image[1] = new ImageIcon(Constantes.path + name + sufijosArchivos[1] + ".gif");
		image[2] = new ImageIcon(Constantes.path + name + sufijosArchivos[2] + ".gif");
		image[3] = new ImageIcon(Constantes.path + name + sufijosArchivos[3] + ".gif");
	}
	
	public GraficoEnte(Obstaculo o, String name) {
		this.name = name;
		ente = o;
		image = new Icon[2];
		image[0] = new ImageIcon(Constantes.path + name + sufijosArchivos[0] + ".gif");
		image[1] = new ImageIcon(Constantes.path + name + sufijosArchivos[1] + ".gif");
	}*/
	
	public void initGrafico (Celda c) {
		pos = new Point(calcularX(c), calcularY(c));
		setIcon(image[0]);
		setBounds(pos.x, pos.y, Constantes.width, Constantes.height);
		
		barraVida = new JLabel();
		barraVida.setBackground(Color.GREEN);
		barraVida.setOpaque(true);
		
		actualizarVida();
	    this.getParent().add(barraVida);
		
		/*
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				getParent().remove(getThis());
			}
			
		});*/
	}
	
	public Point getPos() {
		return pos;
	}
	
	@Deprecated
	protected void cambiarGrafico(int dir) {
		setIcon(image[dir]);
		setBounds(pos.x, pos.y, Constantes.width, Constantes.height);
	}
	
	protected void cambiarGrafico(EstadoEnte estado) {
		setIcon(image[estado.getIndex()]);
		setBounds(pos.x, pos.y, Constantes.width, Constantes.height);
		actualizarVida();
	}
	
	public void actualizarVida () {		
		int max = ente.getMaxVida();
		int vida = ente.getVida();
		
		int barraLenght = Constantes.barraVidaWidth*vida/max;
		
		int barraWidthOffset = (Constantes.width - barraLenght)/2;
		int barraHeightOffset = Constantes.height - Constantes.barraVidaHeight/2;
		
		barraVida.setBounds(pos.x + barraWidthOffset, pos.y + barraHeightOffset, barraLenght, Constantes.barraVidaHeight);
	}
	
	
	private int calcularX (Celda c) {
		return c.columna * 100;
	}
	
	private int calcularY (Celda c) {
		return c.fila * 100;
	}
	
	public void centrar () {
		Celda celda = ente.getCelda();
		pos.setLocation(celda.columna*Constantes.width, 
						celda.fila*Constantes.height);
		setBounds(pos.x, pos.y, Constantes.width, Constantes.height);		
	}
	
	public void morir () {
		barraVida.setVisible(false);
		this.getParent().remove(barraVida);
		this.setVisible(false);
		this.getParent().remove(this);
	}
	
	//TODO esto es horrible
	private GraficoEnte getThis() { return this; }
	
}