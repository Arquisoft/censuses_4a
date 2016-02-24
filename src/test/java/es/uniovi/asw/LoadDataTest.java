package es.uniovi.asw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.parser.readerImpl.XLSXParser;
import es.uniovi.asw.voters.Voter;

public class LoadDataTest {
	
	private XLSXParser loader;
	private List<Voter> voters;
	
	@Before
	public void setUp() {
		
		 loader = new XLSXParser();
		 voters = loader.loadVoters("src/test/resources/test.xlsx");
	}

	@Test
	public void assertVoter1Data() {
		
		Voter voter = voters.get(2);
		assertEquals(voter.getName(), "Ana Torres Pardo");
		assertNotEquals(voter.getEmail(), "atpardo@gmail.com");
		assertEquals(voter.getEmail(), "anatp@gmail.com");
	}
	
	@Test
	public void assertVoter2Data() {
		
		Voter voter = voters.get(1);
		assertEquals(voter.getName(), "Luis López Fernando");
		
		assertNotEquals(voter.getEmail(), "llfernando@gmail.com");
		assertEquals(voter.getEmail(), "luislf@gmail.com");
	}
	
	@Test
	public void assertVoter3Data() {
		
		Voter voter = voters.get(0);
		assertEquals(voter.getName(), "Juan Torres Pardo");
		
		assertNotEquals(voter.getEmail(), "jtpardo@gmail.com");
		assertEquals(voter.getEmail(), "juantp@gmail.com");
	}

}
