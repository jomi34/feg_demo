package com.feg.betting.model.dto;

import java.util.List;

/**
 * Preview class for paid ticket including all options, such as total odds and
 * bonuses
 * 
 * @author kalebmij
 *
 */
public class TicketPreviewResponse extends TicketDTO{
	
	List<BetPreviewDTO> bets;	

	public List<BetPreviewDTO> getBets() {
		return bets;
	}

	public void setBets(List<BetPreviewDTO> bets) {
		this.bets = bets;
	}

}
