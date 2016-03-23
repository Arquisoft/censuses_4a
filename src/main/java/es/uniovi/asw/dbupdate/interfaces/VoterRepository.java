package es.uniovi.asw.dbupdate.interfaces;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.dbupdate.model.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long>{
	
	Voter findByNif(String nif);

}
