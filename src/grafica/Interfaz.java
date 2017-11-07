package grafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Interfaz extends JFrame{
	private Container cont;
	private PanelMapa panelMapa;
	private PanelMenu panelMenu;
	private PanelTienda panelTienda;
	
	public Interfaz() {
		super("Game");
	
		cont=getContentPane();		
		cont.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 746); // TODO: fix, 600 + 38 es por la tittle bar de windows
		

		panelMapa = new PanelMapa();
		panelMenu = new PanelMenu();
		panelTienda = new PanelTienda();
		
		cont.add(panelMenu, BorderLayout.NORTH);
		cont.add(panelMapa, BorderLayout.CENTER);
		cont.add(panelTienda, BorderLayout.SOUTH);
		setVisible(true);
		cont.setVisible(true);
		
		crearBarraMenu();
		
	}
	
	public PanelMapa getPanelMapa() {
		return panelMapa;
	}
	
	public PanelMenu getPanelMenu() {
		return panelMenu;
	}
	
	public PanelTienda getPanelTienda() {
		return panelTienda;
	}
	
	public void crearBarraMenu(){

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem puntaje = new JMenuItem("Puntaje");
		
		JMenuItem acercaDe = new JMenuItem("About");
		JMenuItem salir = new JMenuItem("Exit");

		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(acercaDe);
		menu.add(puntaje);
		menu.add(salir);
		
		
		acercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msj = "\n" + 
						"This game was developed by:\n - Teo Vogel\n"
						+ " - Franco Culaciati\n - Guido Pierdominici\n\n"
						+ "Students of Tecnología de Programación at\n"
						+ " Universidad Nacional del Sur 2017.";
				JOptionPane.showMessageDialog(null, msj, "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.WARNING_MESSAGE);
				if(opt == JOptionPane.OK_OPTION)
					System.exit(0);
			}
		});
		puntaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = "PUNTAJES HISTORICOS: \n";
				try {
					BufferedReader w = new BufferedReader(new FileReader("puntaje.txt"));
					ArrayList<String> rows = new ArrayList<String>();
					String s;
					while((s = w.readLine())!=null)
					    	rows.add(s);
					Collections.sort(rows);
					int i = 0;
					if(rows.size() == 0)
						texto += "Aun no hay puntajes almacenados.";
					while(i<rows.size() && i<10) {
						String puntaje = rows.get(rows.size()-(i+1));
						String pts = puntaje.substring(0, 2);
						String fecha = puntaje.substring(2);
						texto+=""+(i+1)+"- Pts: "+pts+"   |   Fecha: "+fecha+"\n";
						i++;
					}
					w.close();
				}catch(IOException ex) {
					//Si no existe el archivo puntajes aun...
					texto += "Aun no hay puntajes almacenados.";
				}
			
				JOptionPane.showMessageDialog(null, texto, "Puntajes", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		repaint();
	}
}