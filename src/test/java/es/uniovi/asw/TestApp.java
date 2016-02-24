package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

import es.uniovi.asw.voters.Voter;

@SpringBootApplication

@ActiveProfiles("test")
public class TestApp {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TestApp.class);
		app.run(args);
	}

	@Test
	public void evalAdd() {
		Voter voter = new Voter("Ricardo", "1234", 12, "asf");
		assertEquals(voter.getName(), "Ricardo");
	}

}
