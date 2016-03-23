package es.uniovi.asw.parser;

import java.util.List;
import java.util.logging.Logger;

import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.interfaces.LetterWriter;
import es.uniovi.asw.parser.ports.InsertR;
import es.uniovi.asw.parser.ports.RCensus;
import es.uniovi.asw.parser.ports.WreportR;
import es.uniovi.asw.parser.writers.PDFWriter;
import es.uniovi.asw.parser.writers.TXTWriter;
import es.uniovi.asw.parser.writers.WordWriter;
import es.uniovi.asw.reportwriter.ReportWriter;
import es.uniovi.asw.reportwriter.ports.WreportP;
import es.uniovi.asw.util.PasswordGenerator;

public class Parser implements ParserService {

	
	private RCensus censusReader;
	private WreportR reportR;
	
	public Parser() {
		censusReader = new RCensus();
		this.reportR = new WreportR(new ReportWriter());
	}

	@Override
	public void readCensus(String fileName, String letterFormat) {
		List<Voter> voters = censusReader.read(fileName);
		
		if (voters == null) {
			return;
		}
		
		voters = generatePasswords(voters);
		
		new InsertR().insert(voters);
		writeLetters(voters, letterFormat);
	}
	
	private List<Voter> generatePasswords(List<Voter> voters) {
		
		for (Voter voter : voters) {
			voter.setPassword(PasswordGenerator.generate(8));
		}
		
		return voters;
	}

	private void writeLetters(List<Voter> voters, String format) {
		LetterWriter writer = null;
		
		if (format.equals("pdf"))
			writer = new PDFWriter();
		
		else if (format.equals("word"))
			writer = new WordWriter();
		
		else if (format.equals("txt"))
			writer = new TXTWriter();
		
		else {
			reportR.log("ERROR: el formato de las cartas no está soportado");
			return;
		}
			
		for (Voter voter : voters) {
			writer.write(voter);
		}
	}

}
