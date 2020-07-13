package com.feg.betting.model.dto;

public class OddResponse extends OddDTO{
	private long matchId;
	private String competition;
	private String sport;
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
	 * @return the competition
	 */
	public String getCompetition() {
		return competition;
	}
	/**
	 * @param competition the competition to set
	 */
	public void setCompetition(String competition) {
		this.competition = competition;
	}
	/**
	 * @return the sport
	 */
	public String getSport() {
		return sport;
	}
	/**
	 * @param sport the sport to set
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}
}
