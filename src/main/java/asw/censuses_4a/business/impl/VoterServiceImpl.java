package asw.censuses_4a.business.impl;

import asw.censuses_4a.business.VoterService;
import asw.censuses_4a.voters.Voter;
import asw.censuses_4a.business.impl.CommandExecutor;
import asw.censuses_4a.business.impl.AddVoter;

public class VoterServiceImpl implements VoterService{
	
	private CommandExecutor executor = new CommandExecutor();

	public void addVoter(Voter voter) {
		executor.execute(new AddVoter(voter));
		
	}

}
