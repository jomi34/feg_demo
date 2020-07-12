/**
 * 
 */
package com.feg.betting.model.dto;

/**
 * @author kalebmij
 *
 */
public class TicketDTO {
	private long ticketId;
	private float stake;
	private float overallOdd;
	private float prize;
	private float bonus;
	private float multipliedOdd;
	/**
	 * @return the bonus
	 */
	public float getBonus() {
		return bonus;
	}
	/**
	 * @return the multipliedOdd
	 */
	public float getMultipliedOdd() {
		return multipliedOdd;
	}
	/**
	 * @return the overallOdd
	 */
	public float getOverallOdd() {
		return overallOdd;
	}
	/**
	 * @return the prize
	 */
	public float getPrize() {
		return prize;
	}
	/**
	 * @return the stake
	 */
	public float getStake() {
		return stake;
	}
	/**
	 * @return the ticketId
	 */
	public long getTicketId() {
		return ticketId;
	}
	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	/**
	 * @param multipliedOdd the multipliedOdd to set
	 */
	public void setMultipliedOdd(float multipliedOdd) {
		this.multipliedOdd = multipliedOdd;
	}
	/**
	 * @param overallOdd the overallOdd to set
	 */
	public void setOverallOdd(float overallOdd) {
		this.overallOdd = overallOdd;
	}
	/**
	 * @param prize the prize to set
	 */
	public void setPrize(float prize) {
		this.prize = prize;
	}
	/**
	 * @param stake the stake to set
	 */
	public void setStake(float stake) {
		this.stake = stake;
	}
	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

}
