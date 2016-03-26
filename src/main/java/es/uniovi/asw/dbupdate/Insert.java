package es.uniovi.asw.dbupdate;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.util.ReadCensusException;

public interface Insert extends CrudRepository<Voter, Long>{
	
	Voter findByNif(String nif);
	
	void insert(Voter voter) throws ReadCensusException;
	
}
