package es.uniovi.asw.reportwriter.ports;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.uniovi.asw.reportwriter.interfaces.WriteReport;

public class WreportP implements WriteReport {
	
	protected FileWriter fw;
	protected PrintWriter pw;
	
	String logFile = "log.txt";

	public WreportP() throws IOException {
		fw = new FileWriter(logFile);
        pw = new PrintWriter(fw);
	}
	
	@Override
	public void log(String msg) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[")
			.append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()))
			.append("] ")
			.append(msg)
			.append("\n");
		
		pw.println(sb.toString());
		
		fw.write(sb.toString());
		fw.flush();
	}
	
	@Override
	public void close() throws Exception {
		pw.close();
		fw.close();
	}

}
