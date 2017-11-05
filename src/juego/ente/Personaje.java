package juego.ente;
import juego.visitor.*;
import juego.ente.powerup.*;

public abstract class Personaje extends Ente{
	
	protected PowerUp estado;
	protected int ataque;
	protected int rango;
	protected int cadencia, cad;
	protected Visitor v;
	protected int vidaTotal;
	
	public Personaje(int vida, int ataque, int cadencia, int rango) {
		super(vida);
		estado= new PowerUp(this);
		this.ataque = ataque;
		this.cadencia = cadencia;
		cad = 0;
		this.rango = rango;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	public int getCadencia() {
		return cadencia;
	}
	
	public int getVidaTotal(){
		return vidaTotal;
	}
	
	public int getRango() {
		return rango;
	}
	
	public void setPowerUp(PowerUp p){
		estado= p;
	}
	
	public void setVida(int v){
		vida=v;
	}
	
	public void setAtaque(int a) {
		ataque=a;
	}
	
	public void setCadencia(int c){
		cadencia=c;
	} 
	
	public void setCad(int c) {
		cad = c;
	}
	
	public void atacar(){
		estado.actualizar();
	}
}
