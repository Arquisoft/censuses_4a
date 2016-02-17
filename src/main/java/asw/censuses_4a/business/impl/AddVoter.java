package asw.censuses_4a.business.impl;

import asw.censuses_4a.persistence.Jpa;
import asw.censuses_4a.voters.Voter;

public class AddVoter implements Command {
	
	private Voter voter;
	
	public AddVoter(Voter voter) {
		this.voter = voter;
	}

	public Object execute() {

		Jpa.getManager().persist(voter);
		return voter;
		
	}
	
	

}
