package grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;
import juego.ente.Ente;

public class PanelMapa extends JLabel{
	
	public PanelMapa() {
		super();
		setBounds(0, 88, 1000, 638);
		setLayout(null);
		setIcon(new ImageIcon(Constantes.path + "fondo.png"));
		setVisible(true);
		addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				if (Juego.getJuego().getMercado().isPlaceHolderFull()) {
					int columna = e.getX()/100,
					    fila    = e.getY()/100;
					Juego.getJuego().getMercado().getPlaceHolderContent().ejecutar(fila, columna);
				}
            }
			
            @Override
            public void mouseReleased(MouseEvent e) {}
		});	
	}
	
	public void addEnte(Ente e) {
		JLabel grafico = e.getGrafico();
		add(grafico);
		grafico.repaint();
	}
		
}
