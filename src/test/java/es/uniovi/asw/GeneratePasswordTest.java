package es.uniovi.asw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.parser.Generator;
import es.uniovi.asw.parser.generatorImpl.PasswordGenerator;
import es.uniovi.asw.parser.readerImpl.XLSXParser;
import es.uniovi.asw.voters.Voter;

public class GeneratePasswordTest {
	
	private XLSXParser loader;
	private List<Voter> voters;
	private Generator g;
	
	@Before
	public void setUp() {
		
		 g = new PasswordGenerator();
		 loader = new XLSXParser();
		 voters = loader.loadVoters("src/test/resources/test.xlsx");
	}

	@Test
	public void assertPasswordGenerated() {
		
		Voter voter = voters.get(2);
		g.generate(voter);
		assertNotEquals(null, voter.getPassword());
		System.out.println(voter.getPassword());
		
		
	}
	
	

}
