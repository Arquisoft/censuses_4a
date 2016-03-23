package es.uniovi.asw.parser.interfaces;

import java.util.List;

import es.uniovi.asw.dbupdate.model.Voter;

public interface ReadCensus {
	
	public List<Voter> read(String fileName);
	
}
