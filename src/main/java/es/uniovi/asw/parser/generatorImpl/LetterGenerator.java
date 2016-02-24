package es.uniovi.asw.parser.generatorImpl;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.Generator;

public abstract class LetterGenerator implements Generator {

	@Override
	public abstract void generate(Voter voter);

}
