package es.uniovi.asw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.interfaces.ReadCensus;
import es.uniovi.asw.parser.parsers.XLSXParser;
import es.uniovi.asw.util.PasswordGenerator;

public class GeneratePasswordTest {
	
	private ReadCensus parser;
	private List<Voter> voters;
	
	@Before
	public void setUp() {
		 parser = new XLSXParser();
		 voters = parser.read("censo.xlsx");
	}

	@Test
	public void assertPasswordGenerated() {
		Voter voter = voters.get(2);
		String pass = PasswordGenerator.generate(8);
		
		voters.get(2).setPassword(pass);
		
		assertNotEquals(null, voter.getPassword());
		assertEquals(8, voters.get(2).getPassword().length());
		
		assertEquals(8, pass.length());
	}
	
	

}
