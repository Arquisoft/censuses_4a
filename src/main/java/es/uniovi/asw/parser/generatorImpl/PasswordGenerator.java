package es.uniovi.asw.parser.generatorImpl;

import java.util.Random;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.Generator;

/*
 * @author Ricardo Suárez Rodríguez
 */
public class PasswordGenerator implements Generator {

	@Override
	public void generate(Voter voter) {

		char[] caracteres = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };
		
		String pass = "";
		
		for (int i = 0; i < 4; i++) {
			pass += caracteres[new Random().nextInt(62)];
		}
		
		voter.setPassword(pass);
	}

}
