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

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import juego.Idioma;


public class Interfaz extends JFrame{
	private Container cont;
	private PanelMapa panelMapa;
	private PanelMenu panelMenu;
	private PanelTienda panelTienda;
	private JMenu menu, menuIdioma;
	private JMenuItem acercaDe, salir, puntaje;
	private Idioma idioma;
	
	public Interfaz(Idioma idioma) {
		super("Game");
		
		this.idioma = idioma;
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
		menu = new JMenu("Menu");
		puntaje = new JMenuItem("Score");
		
		acercaDe = new JMenuItem("About");
		salir = new JMenuItem("Exit");

		menuIdioma = new JMenu("Language");
		JRadioButtonMenuItem english = new JRadioButtonMenuItem("English");
		JRadioButtonMenuItem spanish = new JRadioButtonMenuItem("Español");
		ButtonGroup group = new ButtonGroup();
		
		english.setSelected(true);
		
		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(puntaje);
		menu.add(menuIdioma);
		menuIdioma.add(english);
		menuIdioma.add(spanish);
		menu.addSeparator();
		menu.add(acercaDe);
		menu.addSeparator();
		menu.add(salir);
		
		group.add(english);
		group.add(spanish);
		
		
	
		acercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, idioma.getAbout(), acercaDe.getText(), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null, idioma.getExit(), salir.getText(), JOptionPane.WARNING_MESSAGE);
				if(opt == JOptionPane.OK_OPTION)
					System.exit(0);
			}
		});
		puntaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = "";
				try {
					BufferedReader w = new BufferedReader(new FileReader("puntaje.txt"));
					ArrayList<String> rows = new ArrayList<String>();
					String s;
					while((s = w.readLine())!=null)
					    	rows.add(s);
					Collections.sort(rows);
					int i = 0;
					if(rows.size() == 0)
						texto = idioma.getEmptyScore();
					while(i<rows.size() && i<10) {
						String puntaje = rows.get(rows.size()-(i+1));
						String pts = puntaje.substring(0, 2);
						String fecha = puntaje.substring(2);
						texto+=""+(i+1)+"- "+idioma.getPoints()+": "+pts+"   |  "+idioma.getDate()+"  "+fecha+"\n";
						i++;
					}
					w.close();
				}catch(IOException ex) {
					//Si no existe el archivo puntajes aun...
					texto = idioma.getEmptyScore();
				}
			
				JOptionPane.showMessageDialog(null, texto, puntaje.getText(), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		english.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setLang("EN");
			}
		});
		spanish.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setLang("ES");
			}
		});
		
		repaint();
	}
	
	private void setLang(String choise){
		switch(choise){
			case "EN":{
				idioma.setLang(choise);
				menu.setText("Menu");
				acercaDe.setText("About");
				salir.setText("Exit");
				puntaje.setText("Score");
				menuIdioma.setText("Language");
				break;
			}
			case "ES":{
				idioma.setLang(choise);
				menu.setText("Menú");
				acercaDe.setText("Acerca De");
				salir.setText("Salir");
				puntaje.setText("Puntaje");
				menuIdioma.setText("Idioma");
				break;
			}
		}
	}
	

	
}