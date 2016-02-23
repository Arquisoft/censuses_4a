import java.io.File;
import java.io.FileWriter;
import java.util.Random;


public class Generador {
	
	public static void main(String[] args) {
		Generador g = new Generador();
		System.out.println(g.generarContraseña());
		
		g.generarCarta("David Fdez Garrido", "11111111", "UOXXXXX@uniovi.es");
	}
	
	public String generarContraseña() {
		char[] caracteres = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		String pass = "";
		for(int i = 0; i < 4; i++) {
			pass += caracteres[new Random().nextInt(62)];
		}
		return pass;
	}
	
	public void generarCarta(String nombre, String nif, String email) {
		try{
			File carta = new File("Carta"+nif+".txt");
			FileWriter escribirCarta = new FileWriter(carta, true);
			
			escribirCarta.write("Don/Doña " + nombre + " ha sido añadido/a al censo. Sus datos son:\n" + 
			"Usuario:" + email + "\nPassword: " + generarContraseña());
			escribirCarta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
