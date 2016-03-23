package es.uniovi.asw.dbupdate.ports;

import es.uniovi.asw.reportwriter.ReportWriter;
import es.uniovi.asw.reportwriter.interfaces.WriteReport;
import es.uniovi.asw.reportwriter.ports.WreportP;

public class WreportR implements WriteReport {

	ReportWriter rw;
	
	public WreportR(ReportWriter rw) {
	 this.rw = rw; 	
	}
	
	@Override
	public void log(String text) {
		
		WreportP wreportP = rw.getLogger();
		
		if (text != null && !text.equals(""))
			wreportP.log(text);
		else
			wreportP.log("ERROR - El texto a escribir en el log esta vacio.");
	}
	
}
