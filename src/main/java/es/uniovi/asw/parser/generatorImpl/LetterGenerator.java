package es.uniovi.asw.parser.generatorImpl;

import es.uniovi.asw.parser.Generator;
import es.uniovi.asw.voters.Voter;

public abstract class LetterGenerator implements Generator {

	@Override
	public abstract void generate(Voter voter);

}
