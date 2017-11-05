package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;
import juego.acciones.AccionSpawnearAliado;

public class PanelTienda extends JLabel{
	
	public PanelTienda() {
		super();
		setBounds(0, 726, 1000, 50);
		setLayout(null);
		setIcon(new ImageIcon(Constantes.path + "fff.png"));
		setVisible(true);
		
		JButton buttonS = new JButton("Support");
		buttonS.setBounds(0, 0, 100, 50);
		add(buttonS);
		buttonS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionSpawnearAliado(Constantes.aliados[0]));
			}			
		});
		JButton buttonC = new JButton("Commando");
		buttonC.setBounds(100, 0, 100, 50);
		add(buttonC);
		buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionSpawnearAliado(Constantes.aliados[1]));
			}			
		});
		JButton buttonSh = new JButton("Sharpshooter");
		buttonSh.setBounds(200, 0, 100, 50);
		add(buttonSh);
		buttonSh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionSpawnearAliado(Constantes.aliados[2]));
			}			
		});
	}
		
}