package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.model.Voter;

public interface Parser {
	
	public List<Voter> loadVoters(String fileName);

}
