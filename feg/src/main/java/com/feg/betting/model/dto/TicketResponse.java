package com.feg.betting.model.dto;

import java.util.List;

public class TicketResponse {
	private long ticketId;
	private float stake;
	private float overallOdd;
	List<BetDTO> bets;
	private float prize;
	private float bonus;
	private float multipliedOdd;
	public List<BetDTO> getBets() {
		return bets;
	}
	public float getOverallOdd() {
		return overallOdd;
	}
	public float getStake() {
		return stake;
	}
	public long getTicketId() {
		return ticketId;
	}
	public void setBets(List<BetDTO> bets) {
		this.bets = bets;
	}
	public void setOverallOdd(float overallOdd) {
		this.overallOdd = overallOdd;
	}
	public void setStake(float stake) {
		this.stake = stake;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public float getPrize() {
		return prize;
	}
	public void setPrize(float prize) {
		this.prize = prize;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public float getMultipliedOdd() {
		return multipliedOdd;
	}
	public void setMultipliedOdd(float multipliedOdd) {
		this.multipliedOdd = multipliedOdd;
	}
}
