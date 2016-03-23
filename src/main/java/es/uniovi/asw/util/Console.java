/**
 * 
 */
package es.uniovi.asw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.uniovi.asw.parser.ports.WreportR;
import es.uniovi.asw.reportwriter.ReportWriter;

/**
 * @author ivan
 *
 */
public class Console {

	private static WreportR reportR;
	
	/**
	 * @param args
	 */
	public static void start(String[] args) {
		
		int opcion;
		reportR = new WreportR(new ReportWriter());
		
		while ((opcion = menu()) != 2) {
			if (opcion == 1) {
				String fileName = readFileName();
				String format = readFormat();
				ServicesFactory.getParserService().readCensus(fileName, format);
			}
		}
		
	}
	
	public static int menu() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = 0;

        System.out.println("\n Censo Electoral");
        System.out.println(" -------------------------------");
        System.out.println(" 1 - Leer censo y generar cartas");
        System.out.println(" -------------------------------");
        System.out.println(" 2 - Salir");

        try{
            option = Integer.parseInt(br.readLine());
        }
        
        catch(NumberFormatException nfe){
            System.out.println("Debes seleccionar un numero entre 1 y 2");
        }
        
        catch (IOException e) {
        	reportR.log(
					"ERROR - El usuario ha realizado una accion inesperada en la consola"
				);
		}
        
        return option;    
    }
	
	public static String readFileName() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        System.out.print("Nombre del archivo que contiene el censo: ");
        String fileName = "";
        
		try {
			fileName = br.readLine();
		}
		
		catch (IOException e) {
			reportR.log(
					"ERROR - El usuario ha introducido una opcion incorrecta en la consola"
				);
		}
        
        return fileName;    
    }
	
	public static String readFormat() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = 0;

		System.out.println("\n Formato de las cartas");
        System.out.println(" ----------------------------");
        System.out.println(" 1 - En formato PDF");
        System.out.println(" 2 - En formato Word");
        System.out.println(" 3 - En Texto Plano");
        System.out.println(" ----------------------------");

        try{
            option = Integer.parseInt(br.readLine());
        }
        
        catch(NumberFormatException e){
            System.out.println("Debes seleccionar un numero entre 1 y 3");
        }
        
        catch (IOException e) {
        	reportR.log(
					"ERROR - El usuario ha realizado una accion inesperada en la consola"
				);
		}
        
        switch(option) {
        	case 1:
        		return "pdf";
        	case 2:
        		return "word";
        	default:
        		return "txt";
        }
    }

}
