package es.uniovi.asw.parser.impl;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.Generator;

public abstract class LetterGenerator implements Generator {

	@Override
	public abstract void generate(Voter voter);

}
