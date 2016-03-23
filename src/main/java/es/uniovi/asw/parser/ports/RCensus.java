package es.uniovi.asw.parser.ports;

import java.util.List;

import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.interfaces.ReadCensus;
import es.uniovi.asw.parser.parsers.CSVParser;
import es.uniovi.asw.parser.parsers.TXTParser;
import es.uniovi.asw.parser.parsers.XLSXParser;
import es.uniovi.asw.reportwriter.ReportWriter;

public class RCensus implements ReadCensus {

	private WreportR wreportR;
	
	public RCensus() {
		this.wreportR = new WreportR(new ReportWriter());
	}

	@Override
	public List<Voter> read(String fileName) {
		
		ReadCensus parser;
		List<Voter> voters = null;
		
		if (fileName.endsWith("xlsx")) {
			parser = new XLSXParser();
			voters = parser.read(fileName);
		}
		
		else if (fileName.endsWith("csv")) {
			parser = new CSVParser();
			voters = parser.read(fileName);
		}
		
		else if (fileName.endsWith("txt")) {
			parser = new TXTParser();
			voters = parser.read(fileName);

		} else {
			wreportR.log(
					"ERROR - El formato del archivo que contiene el censo (" + 
							fileName + ") no está soportado"
					);
		}
		
		return voters;
	}
	
}
