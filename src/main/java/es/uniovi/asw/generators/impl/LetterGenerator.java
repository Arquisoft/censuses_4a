package es.uniovi.asw.generators.impl;

import es.uniovi.asw.generators.Generator;
import es.uniovi.asw.model.Voter;

public abstract class LetterGenerator implements Generator {

	@Override
	public abstract void generate(Voter voter);

}
