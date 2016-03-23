package es.uniovi.asw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uniovi.asw.dbupdate.DBUpdate;
import es.uniovi.asw.dbupdate.interfaces.VoterRepository;
import es.uniovi.asw.util.Console;

/**
 * Main application
 * 
 * @author Iván
 *
 */
@SpringBootApplication
public class LoadVoters {

	public static void main(String... args) {
		SpringApplication.run(LoadVoters.class, args);
	}
	
	@Bean
	public CommandLineRunner console(VoterRepository voterRepository) {
		return (args) -> {
			DBUpdate.setVoterRepository(voterRepository);
			Console.start(args);
		};
	
	}

}
