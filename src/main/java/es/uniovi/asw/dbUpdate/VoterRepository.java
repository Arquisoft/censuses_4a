package es.uniovi.asw.dbUpdate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long>{
	
	List<Voter> findByNif(String nif);

}
