package es.uniovi.asw.reportwriter.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import es.uniovi.asw.reportwriter.WriteReport;
import es.uniovi.asw.reportwriter.ports.WreportP;

/**
 * @author ivan
 */
public class WriteReportImpl implements WriteReport {
	
	private static final Logger logger = Logger.getLogger(WriteReportImpl.class.getName());
	private static WriteReportImpl instance;
	
	private FileWriter fw;
	private String logFile = "log.txt";

	private WriteReportImpl() throws IOException {
		fw = new FileWriter(logFile);
	}
	
	public static WriteReportImpl getInstance() throws IOException {
		
		if (instance == null)
			instance = new WriteReportImpl();
		
		return instance;
	}

	@Override
	public void log(String msg) throws IOException {
		String message = WreportP.addDateTime(msg);
		
		logger.info(msg);
		
		fw.write(message);
		fw.flush();
	}

	@Override
	public void close() throws IOException {
		fw.close();
	}
	
}
