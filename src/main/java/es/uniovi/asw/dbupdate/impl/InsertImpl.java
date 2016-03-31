package es.uniovi.asw.dbupdate.impl;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.ports.InsertP;
import es.uniovi.asw.dbupdate.repositories.VoterRepository;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.util.ReadCensusException;

/**
 * @author ivan
 */
public class InsertImpl implements Insert {

	private static VoterRepository voterRepository;
	
	public static void setVoterRepository(VoterRepository vr) {
		voterRepository = vr;
	}

	public void insert(Voter voter) throws ReadCensusException {
		if (InsertP.verify(voter))
			if (voterRepository.findByNif(voter.getNif()) == null) {
				voterRepository.save(voter);
			} else {
				throw new ReadCensusException("[ERROR] [InsertDB] El votante " + voter.getNif() + " ya existe");
			}
	}

}
