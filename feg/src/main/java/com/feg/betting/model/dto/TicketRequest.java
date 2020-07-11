package com.feg.betting.model.dto;

import java.util.Map;

public class TicketRequest {
	private float stake;
	Map<Long, Character> bets;
	public Map<Long, Character> getBets() {
		return bets;
	}
	public float getStake() {
		return stake;
	}
	public void setBets(Map<Long, Character> bets) {
		this.bets = bets;
	}
	public void setStake(float stake) {
		this.stake = stake;
	}
}
