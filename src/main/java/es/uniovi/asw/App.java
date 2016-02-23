package es.uniovi.asw;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uniovi.asw.dbUpdate.VoterRepository;
import es.uniovi.asw.model.Voter;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws ParseException {
		
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner demo(VoterRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Voter("Jack Bauer","124", 1234, "a@gmail.com"));

			// fetch all voters
			log.info("Voters found with findAll():");
			log.info("-------------------------------");
			for (Voter voter : repository.findAll()) {
				log.info(voter.toString());
			}
			
			log.info("");
			
			// fetch customers by last name
						log.info("Customer found with findByLastName('Bauer'):");
						log.info("--------------------------------------------");
						for (Voter bauer : repository.findByNif("124")) {
							log.info(bauer.toString());
						}
			            log.info("");
		};
	}
}
