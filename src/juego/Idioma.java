package juego;

public class Idioma {
	private String idioma = "EN";
	
	public void setLang(String choise){
		switch(choise){
			case "EN":{
				idioma = "EN";
				break;
			}
			case "ES":{
				idioma = "ES";
				break;
			}
		}
	}
	
	public String getEmptyScore(){
		String msj = "";
		switch(idioma){
			case "EN":{
				msj = "There isn't any score yet.";
				break;
			}
			case "ES":{
				msj = "Aun no hay puntajes almacenados.";
				break;
			}
		}
		return msj;
	}
	
	public String getWin(){
		String msj = "";
		switch(idioma){
			case "EN":{
				msj = "You Win!";
				break;
			}
			case "ES":{
				msj = "Ganaste!";
				break;
			}
		}
		return msj;
	}
	
	public String getLose(){
		String msj = "";
		switch(idioma){
			case "EN":{
				msj = "You Lose!";
				break;
			}
			case "ES":{
				msj = "Perdiste!";
				break;
			}
		}
		return msj;
	}
	
	public String getPoints(){
		String msj = "";
		switch(idioma){
			case "EN":{
				msj = "Points";
				break;
			}
			case "ES":{
				msj = "Puntos";
				break;
			}
		}
		return msj;
	}
	
	public String getDate(){
		String msj = "";
		switch(idioma){
			case "EN":{
				msj = "Date";
				break;
			}
			case "ES":{
				msj = "Fecha";
				break;
			}
		}
		return msj;
	}
	
	public  String getExit(){
		String msj = "";
		switch(idioma){
			case "EN":{
				msj = "Do you really want to exit?";
				break;
			}
			case "ES":{
				msj = "¿Está seguro que desa salir del juego?";
				break;
			}
		}
		return msj;
	}
	
	public String getAbout(){
		String msj = "";
		switch(idioma){
			case "EN":{ 
				msj = "\n" + 
					"This game was developed by:\n - Teo Vogel\n"
					+ " - Franco Culaciati\n - Guido Pierdominici\n\n"
					+ "Students of Tecnología de Programación at\n"
					+ " Universidad Nacional del Sur 2017.";
				break;
			}
			case "ES":{ 
				msj = "\n" +
					"Este juego fue desarrollado por:\n - Teo Vogel\n"
					+ " - Franco Culaciati\n - Guido Pierdominici\n\n"
					+ "Alumnos de Tecnología de Programación de\n"
					+ " la Universidad Nacional del Sur año 2017.";
				break;
			}	
		}
		return msj;
	}
	
	public String getEnd(){
		String msj = "";
		switch(idioma){
			case "EN":{
				msj = "The End";
				break;
			}
			case "ES":{
				msj = "Fin del Juego";
				break;
			}
		}
		return msj;
	}
}
