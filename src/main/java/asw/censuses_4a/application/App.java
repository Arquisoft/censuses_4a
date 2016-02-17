package asw.censuses_4a.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import asw.censuses_4a.persistence.VoterRepository;
import asw.censuses_4a.voters.Voter;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner demo(VoterRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Voter("Jack Bauer", 1234));

			// fetch all voters
			log.info("Voters found with findAll():");
			log.info("-------------------------------");
			for (Voter voter : repository.findAll()) {
				log.info(voter.toString());
			}
		};
	}
}
