package juego;

import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

import grafica.Interfaz;
import juego.niveles.Nivel;
import juego.niveles.Nivel1;

public class Juego {

	private final static Juego juego = new Juego();
	public static Juego getJuego() { return juego; }
	
	private Mapa mapa;
	private Interfaz interfaz;
	private ContadorTiempo tiempo;
	private int minimoPuntaje;
	
	private Mercado mercado;
	private int puntos;
	
	private int dificultad = 4;
	private List<Nivel> niveles = new ArrayList<Nivel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {}
	
	private Juego(){
		mercado = new Mercado();
		interfaz= new Interfaz();
		mapa = new Mapa(interfaz.getPanelMapa());
		int i = 0;		
		minimoPuntaje = -1;
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
		
		niveles.add(new Nivel1(mapa, 1));
		niveles.add(new Nivel1(mapa, 1));
		siguienteNivel();
		
	}
	
	public Mercado getMercado () {
		return mercado;
	}
	
	public Mapa getMapa () {
		return mapa;
	}

	/* 
	 * SISTEMA DE PUNTOS
	 */
	
	public int getPuntos() {
		return puntos;
	}
	
	public Interfaz getInterfaz(){return interfaz;}
	
	public void sumarPuntos (int p) {
		puntos += p;
	}
	
	public void siguienteNivel () {
		if (niveles.size() > 0) {
			niveles.remove(0).init();
		} else {
			ganar();
		}
	}
	
	public void perder () {
		int rnd = (int) (Math.random() *90+10);
		if(rnd > minimoPuntaje)
			almacenarPuntaje(rnd);
		JOptionPane.showMessageDialog(null, "Ganaste!");
		interfaz.dispatchEvent(new WindowEvent(interfaz, WindowEvent.WINDOW_CLOSING));
	}
	
	public void ganar () {
		int rnd = (int) (Math.random() * 100);
		if(rnd > minimoPuntaje)
			almacenarPuntaje(rnd);
		JOptionPane.showMessageDialog(null, "Perdiste!");
		interfaz.dispatchEvent(new WindowEvent(interfaz, WindowEvent.WINDOW_CLOSING));
	}
	
	//TODO esto es horrible
	public Juego getThis() { return this; }
	
	private void almacenarPuntaje(int p){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		//Creo el string para almacenar en el archivo
		String temp = p+" " + cal.getTime().toString() + "\n";
		String str = temp.replaceAll("\n", System.lineSeparator());
		try {
			//Abro o creo el archivo
			Path filePath = Paths.get("puntaje.txt");
			if (!Files.exists(filePath)) {
			    Files.createFile(filePath);
			}
			//Escribo en el archivo abierto
			Files.write(filePath, str.getBytes(), StandardOpenOption.APPEND);
				
		}catch(IOException e) {
			e.printStackTrace();
		}
}
}
