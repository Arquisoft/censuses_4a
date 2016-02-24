package es.uniovi.asw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uniovi.asw.dbUpdate.VoterRepository;
import es.uniovi.asw.parser.ReadCensus;
import es.uniovi.asw.parser.readerImpl.RCensus;

/**
 * Main application
 * 
 * @author David Fdez Garrido
 *
 */
@SpringBootApplication
public class LoadUsers {

	public static void main(String[] args) throws Exception {

		ReadCensus rCensus = new RCensus();

		rCensus.readCensus(args);

	}
	
//	public static void main(String[] args) {
//		SpringApplication.run(LoadUsers.class);
//	}
//	@Bean
//	public CommandLineRunner demo(VoterRepository repository) {
//		return (args) -> {
//			ReadCensus rCensus = new RCensus();
//
//			rCensus.readCensus(args);
//			
//		};
//	}
}
