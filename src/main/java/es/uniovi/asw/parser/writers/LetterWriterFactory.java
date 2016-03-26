package es.uniovi.asw.parser.writers;

import es.uniovi.asw.util.ReadCensusException;

public class LetterWriterFactory {

	public static LetterWriter create(String format) throws ReadCensusException {

		LetterWriter writer = null;
		
		if (format.equals("pdf"))
			writer = new PDFWriter();
		
		else if (format.equals("word"))
			writer = new WordWriter();
		
		else if (format.equals("txt"))
			writer = new TXTWriter();

		else
			throw new ReadCensusException("[ERROR] El formato para generar las cartas (" + format + ") no está soportado");
		
		return writer;
	}
	
}
