package es.uniovi.asw.reportwriter.ports;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WreportP {
	
	public static String addDateTime(String msg) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[")
			.append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()))
			.append("] ")
			.append(msg)
			.append("\n");
		
		return sb.toString();
	}

}
