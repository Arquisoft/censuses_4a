package es.uniovi.asw.dbupdate;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.util.ReadCensusException;

public interface Insert {

	void insert(Voter voter) throws ReadCensusException;
	
}
