package com.feg.betting.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.feg.betting.model.Bet;

/**
 * Class used for building CheckResponseBuilder object.
 * @author kalebmij
 *
 */
public class TicketCheckResponseBuilder {
	Logger logger = LogManager.getLogger(TicketCheckResponseBuilder.class);
	TicketCheckResponse ticketCheckResponse = new TicketCheckResponse();

	/**
	 * Builds basic properties for response, copying from another preview response.
	 * 
	 * @param ticketDTO
	 */
	public void buildProperties(TicketDTO ticketDTO) {
		logger.info("Building props");
		ticketCheckResponse.setBonus(ticketDTO.getBonus());
		ticketCheckResponse.setMultipliedOdd(ticketDTO.getMultipliedOdd());
		ticketCheckResponse.setOverallOdd(ticketDTO.getOverallOdd());
		ticketCheckResponse.setPrize(ticketDTO.getPrize());
		ticketCheckResponse.setStake(ticketDTO.getStake());
		ticketCheckResponse.setTicketId(ticketDTO.getTicketId());
	}

	/**
	 * Builds bets part for response dividing it up to active, winning and losing
	 * bets
	 * 
	 * @param bets
	 */
	public void buildBets(List<Bet> bets) {
		if (bets == null)
			return;
		List<BetPreviewDTO> activeBets = new ArrayList<>();
		List<BetCheckDTO> lostBets = new ArrayList<>();
		List<BetCheckDTO> predictedBets = new ArrayList<>();
		for (Bet bet : bets) {		
			if (bet.isActive()) {
				activeBets.add(bet.toBetDTO());
			}  else if (bet.isPredicted()) {
				predictedBets.add(bet.toBetCheckDTO());
			} else {
				lostBets.add(bet.toBetCheckDTO());
			}
		}
		ticketCheckResponse.setActiveBets(activeBets);
		ticketCheckResponse.setLostBets(lostBets);
		ticketCheckResponse.setPredictedBets(predictedBets);
		
		if (CollectionUtils.isNotEmpty(lostBets)) {
			this.ticketCheckResponse.setPrize(0);
			ticketCheckResponse.setState(TicketState.LOST);
		}
		else if (CollectionUtils.isNotEmpty(activeBets)) {
			ticketCheckResponse.setState(TicketState.ACTIVE);
		}
		else{
			ticketCheckResponse.setState(TicketState.WINNING);
		}
	}
	
	public TicketCheckResponse getResult() {
		return ticketCheckResponse;
	}

}
