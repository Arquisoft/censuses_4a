package es.uniovi.asw.parser.ports;

import es.uniovi.asw.parser.parsers.CSVParser;
import es.uniovi.asw.parser.parsers.CensusParser;
import es.uniovi.asw.parser.parsers.TXTParser;
import es.uniovi.asw.parser.parsers.XLSXParser;
import es.uniovi.asw.util.ReadCensusException;

public class RCensus {

	public static CensusParser create(String fileName) throws ReadCensusException {

		CensusParser parser;
		
		if (fileName.endsWith(".xlsx"))
			parser = new XLSXParser(fileName);
		
		else if (fileName.endsWith(".csv"))
			parser = new CSVParser(fileName);
		
		else if (fileName.endsWith(".txt"))
			parser = new TXTParser(fileName);

		else
			throw new ReadCensusException("ERROR - El formato del archivo que contiene el censo (" + fileName + ") no está soportado");
		
		return parser;
	}
	
}
