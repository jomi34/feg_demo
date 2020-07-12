/**
 * 
 */
package com.feg.betting.model.dto;

/**
 * @author kalebmij
 *
 */
public class ScoreResponse {
	private long matchId;
	private String home;
	private String away;
	private int scoreHome;
	private int scoreAway;
	private String status;
	
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
	 * @return the home
	 */
	public String getHome() {
		return home;
	}
	/**
	 * @param home the home to set
	 */
	public void setHome(String home) {
		this.home = home;
	}
	/**
	 * @return the away
	 */
	public String getAway() {
		return away;
	}
	/**
	 * @param away the away to set
	 */
	public void setAway(String away) {
		this.away = away;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
