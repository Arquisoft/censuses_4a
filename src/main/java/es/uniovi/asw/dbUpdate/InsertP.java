package es.uniovi.asw.dbUpdate;

import java.text.ParseException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;

import es.uniovi.asw.parser.generatorImpl.LetterGenerator;
import es.uniovi.asw.parser.generatorImpl.PdfLetterGenerator;
import es.uniovi.asw.parser.generatorImpl.TxtLetterGenerator;
import es.uniovi.asw.voters.Voter;

@SpringBootApplication
@EntityScan("es.uniovi.asw.voters")
public class InsertP implements Insert {

	private List<Voter> voters;
	private LetterGenerator letterGenerator;

	@Override
	public void insert(List<Voter> voters) {

		this.voters = voters;

	}

	private void generateLetters(List<Voter> voters, String letterFormat) {

		insert(voters);

		if (letterFormat.equals("txt")) {
			letterGenerator = new TxtLetterGenerator();
		} else {
			letterGenerator = new PdfLetterGenerator();
		}

	}

	public static void main(String[] args) throws ParseException {

		SpringApplication.run(InsertP.class, args);
	}

	@Bean
	public CommandLineRunner demo(VoterRepository repository) {
		return (args) -> {
			generateLetters(voters, args[2]);

			for (Voter voter : voters) {
				if (repository.findByNif(voter.getNif()) == null) {

					repository.save(voter);
					letterGenerator.generate(voter);
				}
			}
		};
	}

}
