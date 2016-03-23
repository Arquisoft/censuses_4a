/**
 * 
 */
package es.uniovi.asw.dbupdate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.dbupdate.interfaces.VoterRepository;
import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.dbupdate.ports.InsertP;

/**
 * @author ivan
 *
 */
public class DBUpdate implements DBUpdateService {

	@Autowired
	private static VoterRepository voterRepository;
	
	public static void setVoterRepository(VoterRepository vr) {
		voterRepository = vr;
	}
	
	public void insertVoters(List<Voter> voters) {
		new InsertP(voterRepository).insert(voters);
	}

}
