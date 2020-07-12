package com.feg.betting.model;


import com.feg.betting.exception.IncorrectInputException;

public interface Outcome {
	final char DRAW = 'X';
	final char DRAW_0 = '0';
	final char DRAW_X = 'x';
	
	final char HOME_WIN = '1';
	final char AWAY_WIN = '2';
	
	/**
	 * Checks value of supplied outcome character. Throws an exception if it is disallowed value.
	 * @param outcome
	 * @return outcome value if it is corrected or transformed to 'X' for '0' or 'x'
	 * @throws IncorrectInputException
	 */
	public static char checkOutcome(Character outcome) throws IncorrectInputException {
		if (outcome == null)
			throw new IncorrectInputException("Outcome value cannot be empty.");
		char charValue = outcome.charValue();
		if (charValue == '1' || charValue == '2')
			return charValue;
		if (charValue == DRAW_0 || charValue == 'x' || charValue == 'X')
			return 'X';
		throw new IncorrectInputException("Outcome value " + outcome + " not supported.");
	}
	
	
}
