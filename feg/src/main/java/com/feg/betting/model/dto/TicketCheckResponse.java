/**
 * 
 */
package com.feg.betting.model.dto;

import java.util.List;

/**
 * Transfer object used as response for checking ticket state (win, lose or
 * still active). It also prints information about all bets on ticket and their
 * state.
 * 
 * @author kalebmij
 *
 */

public class TicketCheckResponse extends TicketDTO {
	private List<BetPreviewDTO> activeBets;
	private List<BetCheckDTO> lostBets;
	private List<BetCheckDTO> predictedBets;
	private TicketState state;

	/**
	 * Gets list of all active bets. Active bet is related to game which has not
	 * finished or not started.
	 * 
	 * @return the activeBets
	 */
	public List<BetPreviewDTO> getActiveBets() {
		return activeBets;
	}

	/**
	 * Gets list of all lost bets. Lost bet is related to any game on ticket which
	 * was finished and predicted outcome was different as real outcome..
	 * 
	 * @return the lostBets
	 */
	public List<BetCheckDTO> getLostBets() {
		return lostBets;
	}

	/**
	 * Gets list of all predicted bets. Predicted bet is related to any game on
	 * ticket which was finished and predicted outcome was equal as real outcome..
	 * 
	 * @return the predictedBets
	 */
	public List<BetCheckDTO> getPredictedBets() {
		return predictedBets;
	}

	/**
	 * State of a ticket. If there is any lost bet on ticket, it implies the ticket
	 * is in LOST state as well. A ticket is winning if all games are finished and
	 * predicted. Otherwise, if there is any active game, then the ticket state is
	 * active too.
	 * 
	 * @return
	 */
	public TicketState getState() {
		return state;
	}

	/**
	 * @param activeBets the activeBets to set
	 */
	public void setActiveBets(List<BetPreviewDTO> activeBets) {
		this.activeBets = activeBets;
	}

	/**
	 * @param lostBets the lostBets to set
	 */
	public void setLostBets(List<BetCheckDTO> lostBets) {
		this.lostBets = lostBets;
	}

	/**
	 * @param predictedBets the predictedBets to set
	 */
	public void setPredictedBets(List<BetCheckDTO> predictedBets) {
		this.predictedBets = predictedBets;
	}

	public void setState(TicketState state) {
		this.state = state;
	}

}
