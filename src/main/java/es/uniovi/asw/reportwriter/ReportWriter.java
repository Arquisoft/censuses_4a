/**
 * 
 */
package es.uniovi.asw.reportwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import es.uniovi.asw.reportwriter.interfaces.WriteReport;
import es.uniovi.asw.reportwriter.ports.WreportP;

/**
 * @author ivan
 *
 */
public class ReportWriter implements WriteReport {
	
	private static ReportWriter instance;
	private WreportP wreportP;
	
	private FileWriter fw;
	private PrintWriter pw;
	
	private String logFile = "log.txt";

	private ReportWriter() throws IOException {
		fw = new FileWriter(logFile);
        pw = new PrintWriter(fw);
		
		wreportP = new WreportP();
	}
	
	public static ReportWriter getInstance() throws IOException {
		
		if (instance == null)
			instance = new ReportWriter();
		
		return instance;
	}

	@Override
	public void log(String msg) throws IOException {
		String message = wreportP.addDateTime(msg);
		
		pw.println(message);
		
		fw.write(message);
		fw.flush();
	}

	@Override
	public void close() throws Exception {
		pw.close();
		fw.close();
	}
	
}
