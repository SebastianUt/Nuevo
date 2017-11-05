package grafica;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;
import juego.Juego;
import juego.Constantes;
public class GraficoDisparo extends Thread{
	protected int altoDisparo=5;
	
	public GraficoDisparo (JLabel a, JLabel b, String dir){
		Juego j=Juego.getJuego();
		JLabel panelMapa=j.getInterfaz().getPanelMapa();
		JLabel grafico;
		ImageIcon image;
		
		Point izq = new Point((int)a.getX()+ Constantes.width,(int)a.getY()+ Constantes.height/2-altoDisparo/2);	//a la derecha y a la mitad(+la mitad de la altura del disparo) del ente
		Point der = new Point((int)b.getX(), (int)b.getY()+ Constantes.height/2-altoDisparo/2 );				//a la izquierda y a la mitad(+la mitad de la altura del disparo) del ente

		image = new ImageIcon(Constantes.path+"dispIzq.png"); 
		/*if(dir=="der")
			image = new ImageIcon(Constantes.path+"dispDer.gif"); 
		else
			if(dir=="izq")
				image = new ImageIcon(Constantes.path+"dispIzq.gif"); 
			else
				return;
		*/
		Image imagen = image.getImage(); // transform it (int)( der.getX()-izq.getX() )
		Image newimg = imagen.getScaledInstance((int)( der.getX()-izq.getX() + 1 ), altoDisparo,  java.awt.Image.SCALE_DEFAULT); // scale it the smooth way
		image = new ImageIcon(newimg);
		grafico = new JLabel(image);
		grafico.setBounds((int)izq.getX(), (int)izq.getY(), (int)( der.getX()-izq.getX() ), altoDisparo+10);
		//(int)izq.getX() (int)izq.getY() (int)( der.getX()-izq.getX() )
		grafico.setVisible(true);
		panelMapa.add(grafico);
		grafico.repaint();
		try {
			sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grafico.setVisible(false);
		//grafico.repaint();
		
		panelMapa.remove(grafico);
	}
	
}
