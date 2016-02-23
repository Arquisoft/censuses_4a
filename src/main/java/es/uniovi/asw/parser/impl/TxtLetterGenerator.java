package es.uniovi.asw.parser.impl;

import java.io.File;
import java.io.FileWriter;

import es.uniovi.asw.model.Voter;

public class TxtLetterGenerator extends LetterGenerator {

	@Override
	public void generate(Voter voter) {

		try {
			File letter = new File("src/main/resources/letters/" + voter.getNif() + ".txt");
			FileWriter writeLetter = new FileWriter(letter, true);

			writeLetter.write("Don/Doña " + voter.getName() 
			+ " ha sido añadido/a al censo. Sus datos son:\n"
			+ "Usuario:" + voter.getEmail() + "\nPassword: " + voter.getPassword());
			
			writeLetter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
