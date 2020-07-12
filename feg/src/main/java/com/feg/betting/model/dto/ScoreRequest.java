/**
 * 
 */
package com.feg.betting.model.dto;

/**
 * Request for adding score of a match to DB. It handles with three simples values match ID, and both number of goals scored by both oponents.
 * @author kalebmij
 *
 */
public class ScoreRequest {
	long matchId;
	int scoreHome;
	int scoreAway;
	/**
	 * @return the matchId
	 */
	public long getMatchId() {
		return matchId;
	}
	/**
	 * @param matchId the matchId to set
	 */
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}
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

}
