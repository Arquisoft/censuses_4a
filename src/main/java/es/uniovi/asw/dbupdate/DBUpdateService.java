/**
 * 
 */
package es.uniovi.asw.dbupdate;

import java.util.List;

import es.uniovi.asw.dbupdate.model.Voter;

/**
 * @author ivan
 *
 */
public interface DBUpdateService {
	
	void insertVoters(List<Voter> voters);

}
