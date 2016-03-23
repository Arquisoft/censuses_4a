package es.uniovi.asw.reportwriter.ports;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

import es.uniovi.asw.reportwriter.formatter.WreportPFormatter;
import es.uniovi.asw.reportwriter.interfaces.WriteReport;

public class WreportP implements WriteReport {
	
	private static final Logger logger = Logger.getLogger(WreportP.class.getName());
	private static FileHandler handler;
	
	String logFile = "log.txt";

	public WreportP() {
		initilize();
	}
	
	@Override
	public void log(String msg) {
		logger.info("PPP" + msg);
	}
	
	private void initilize() {
		
		try {
			
			if (handler == null) {
				handler = new FileHandler(logFile);
				handler.setFormatter(new WreportPFormatter());
			}
			
			logger.addHandler(handler);
		} 
		
		catch (Exception e) {
		
		}

	}

}
