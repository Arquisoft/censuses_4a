package es.uniovi.asw.dbupdate.ports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.dbupdate.interfaces.Insert;
import es.uniovi.asw.dbupdate.interfaces.VoterRepository;
import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.ports.WreportR;
import es.uniovi.asw.reportwriter.ReportWriter;

public class InsertP implements Insert {
	
	@Autowired
	private VoterRepository voterRepository;
	private WreportR report;

	public InsertP(VoterRepository voterRepository) {
		this.voterRepository = voterRepository;
		
		report = new WreportR(new ReportWriter());
	}

	@Override
	public void insert(List<Voter> voters) {
		
		for (Voter voter : voters) {
			if (voterRepository.findByNif(voter.getNif()) == null) {
				voterRepository.save(voter);
			} else {
				report.log("ERROR - El usuario con DNI " + voter.getNif() + " ya existe.");
			}
		}

	}

}
