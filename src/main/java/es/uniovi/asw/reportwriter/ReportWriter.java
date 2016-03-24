/**
 * 
 */
package es.uniovi.asw.reportwriter;

import java.io.IOException;

import es.uniovi.asw.reportwriter.interfaces.WriteReport;
import es.uniovi.asw.reportwriter.ports.WreportP;

/**
 * @author ivan
 *
 */
public class ReportWriter implements WriteReport {
	
	private static ReportWriter instance;
	private WriteReport wreportP;

	private ReportWriter() throws IOException {
		wreportP = new WreportP();
	}
	
	public static ReportWriter getInstance() throws IOException {
		
		if (instance == null)
			instance = new ReportWriter();
		
		return instance;
	}

	@Override
	public void log(String msg) throws IOException {
		wreportP.log(msg);
	}

	@Override
	public void close() throws Exception {
		wreportP.close();
	}
	
}
