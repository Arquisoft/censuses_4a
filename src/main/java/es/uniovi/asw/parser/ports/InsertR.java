package es.uniovi.asw.parser.ports;

import java.util.List;

import es.uniovi.asw.dbupdate.interfaces.Insert;
import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.util.ServicesFactory;

public class InsertR implements Insert {

	@Override
	public void insert(List<Voter> voters) {
		
		// Verificar que cada votante tiene todos los campos
		// y que DNI e email lo son realmente mediante mascaras
		
		ServicesFactory.getDBUpdateService().insertVoters(voters);
		
	}

}
