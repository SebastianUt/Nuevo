package grafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import juego.ente.Ente;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.IconView;


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
		JMenuItem acercaDe = new JMenuItem("About");
		JMenuItem salir = new JMenuItem("Exit");

		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(acercaDe);
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
		
		repaint();
	}
}