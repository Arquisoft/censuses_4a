package es.uniovi.asw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.parsers.XLSXParser;

public class LoadDataTest {
	
	private XLSXParser loader;
	private List<Voter> voters;
	
	@Before
	public void setUp() {
		 loader = new XLSXParser();
		 voters = loader.read("censo.xlsx");
	}

	@Test
	public void assertVoter1Data() {
		Voter voter = voters.get(0);
		assertEquals(voter.getName(), "Perico Delgado Gutiérrez");
		assertNotEquals(voter.getEmail(), "perico2@servidor.com");
		assertEquals(voter.getEmail(), "perico@servidor.com");
	}
	
	@Test
	public void assertVoter2Data() {
		Voter voter = voters.get(1);
		assertEquals(voter.getName(), "Juan Álvarez González");
		assertNotEquals(voter.getEmail(), "juan@servidor2.com");
		assertEquals(voter.getEmail(), "juan@servidor.com");
	}
	
	@Test
	public void assertVoter3Data() {
		Voter voter = voters.get(2);
		assertEquals(voter.getName(), "Manuel Fernández Álvarez");
		assertNotEquals(voter.getEmail(), "manuel@servidor.net");
		assertEquals(voter.getEmail(), "manuel@servidor.com");
	}

}
