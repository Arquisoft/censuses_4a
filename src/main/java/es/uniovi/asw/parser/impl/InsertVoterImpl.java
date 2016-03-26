package es.uniovi.asw.parser.impl;

import java.util.Map;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.ports.InsertR;
import es.uniovi.asw.util.ReadCensusException;
import es.uniovi.asw.util.ServicesFactory;

/**
 * @author ivan
 */
public class InsertVoterImpl {

	public void insert(Map<String, Object> voterData) throws ReadCensusException {	
		
		Voter voter = InsertR.verify(voterData);
		ServicesFactory.getDBUpdateService().insert(voter);
		
	}

}
