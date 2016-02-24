package es.uniovi.asw.parser.readerImpl;

import es.uniovi.asw.dbUpdate.Insert;
import es.uniovi.asw.parser.InsertR;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.ReadCensus;

public class RCensus implements ReadCensus {

	@Override
	public void readCensus(String[] args) {
		
	
		if( args[1].equals("x") ){ 
			Parser parser = new XLSXParser();
			Insert insertR = new InsertR();
			insertR.insert(parser.loadVoters(args[0]));
		}
	}

}
