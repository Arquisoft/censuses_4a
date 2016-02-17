package asw.censuses_4a.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import asw.censuses_4a.voters.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long>{
	
	List<Voter> findByNif(String nif);

}
