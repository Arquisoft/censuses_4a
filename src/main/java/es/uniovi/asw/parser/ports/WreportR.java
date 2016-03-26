package es.uniovi.asw.parser.ports;

public class WreportR {
	
	public static boolean verify(String text) {
		if (text != null && !text.equals(""))
			return true;
		else
			return false;
	}
	
}
