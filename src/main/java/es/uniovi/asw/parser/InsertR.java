package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbUpdate.Insert;
import es.uniovi.asw.parser.generatorImpl.PasswordGenerator;
import es.uniovi.asw.voters.Voter;

public class InsertR implements Insert {

	@Override
	public void insert(List<Voter> voters) {
		
		Generator pGen = new PasswordGenerator();
		
		for (Voter voter : voters) {
			pGen.generate(voter);
		}
		
	}

}
