/**
 * 
 */
package com.feg.betting.model.dto;

/**
 * Data object which stores all information about bet including checking result after match was over.
 * @author kalebmij
 *
 */
public class BetCheckDTO extends BetPreviewDTO{
	
	private int scoreHome;
	private int scoreAway;
	private char winningOutcome;
	
	
	/**
	 * @return the scoreHome
	 */
	public int getScoreHome() {
		return scoreHome;
	}
	/**
	 * @param scoreHome the scoreHome to set
	 */
	public void setScoreHome(int scoreHome) {
		this.scoreHome = scoreHome;
	}
	/**
	 * @return the scoreAway
	 */
	public int getScoreAway() {
		return scoreAway;
	}
	/**
	 * @param scoreAway the scoreAway to set
	 */
	public void setScoreAway(int scoreAway) {
		this.scoreAway = scoreAway;
	}
	/**
	 * @return the winningOutcome
	 */
	public char getWinningOutcome() {
		return winningOutcome;
	}
	/**
	 * @param winningOutcome the winningOutcome to set
	 */
	public void setWinningOutcome(char winningOutcome) {
		this.winningOutcome = winningOutcome;
	}
}
