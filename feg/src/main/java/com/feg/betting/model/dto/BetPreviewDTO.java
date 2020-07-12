package com.feg.betting.model.dto;

import java.time.LocalDateTime;

public class BetPreviewDTO {
	private LocalDateTime kickoff;
	private String home;
	private String away;
	private char outcome;
	private float odd;
	private long matchId;

	public String getAway() {
		return away;
	}

	public String getHome() {
		return home;
	}

	public LocalDateTime getKickoff() {
		return kickoff;
	}

	public float getOdd() {
		return odd;
	}

	public char getOutcome() {
		return outcome;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public void setKickoff(LocalDateTime kickoff) {
		this.kickoff = kickoff;
	}

	public void setOdd(float odd) {
		this.odd = odd;
	}

	public void setOutcome(char outcome) {
		this.outcome = outcome;
	}

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}
}
