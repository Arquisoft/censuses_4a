/**
 * 
 */
package es.uniovi.asw.reportwriter;

import es.uniovi.asw.reportwriter.ports.WreportP;

/**
 * @author ivan
 *
 */
public class ReportWriter {
	
	WreportP wReportP;
	
	public ReportWriter() {
	 wReportP = new WreportP();
	}
	
	public WreportP getLogger() {
		return wReportP;
	}

}
