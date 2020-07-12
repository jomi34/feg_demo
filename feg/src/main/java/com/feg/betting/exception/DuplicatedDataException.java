/**
 * 
 */
package com.feg.betting.exception;

/**
 * Exception thrown for actions during adding already existing data.
 * @author kalebmij
 *
 */
public class DuplicatedDataException extends FegException{
	public DuplicatedDataException(String message) {
		super(message);
	}

}
