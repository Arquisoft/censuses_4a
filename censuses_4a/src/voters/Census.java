package voters;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Census {
	
	@OneToMany (mappedBy = "census")
	private Set<Voter> voters = new HashSet<>();

}
