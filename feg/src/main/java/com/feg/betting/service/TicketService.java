package com.feg.betting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feg.betting.dao.BetDao;
import com.feg.betting.dao.MatchDao;
import com.feg.betting.dao.TicketDao;
import com.feg.betting.exception.DataNotFoundException;
import com.feg.betting.exception.FegException;
import com.feg.betting.exception.IncorrectInputException;
import com.feg.betting.model.Bet;
import com.feg.betting.model.Match;
import com.feg.betting.model.Outcome;
import com.feg.betting.model.Ticket;
import com.feg.betting.model.dto.TicketCheckResponse;
import com.feg.betting.model.dto.TicketCheckResponseBuilder;
import com.feg.betting.model.dto.TicketPreviewResponse;
import com.feg.betting.model.dto.TicketRequest;
import com.feg.betting.model.dto.TicketState;

import org.apache.logging.log4j.Logger;

/**
 * Service for handling all information about ticket, such as store to DB, or checking the state
 * @author kalebmij
 *
 */
@Service
public class TicketService {
	@Autowired
	TicketDao ticketDao;
	@Autowired
	MatchDao matchDao;
	@Autowired
	BetDao betDao;
	
    Logger logger = LogManager.getLogger(TicketService.class);

	/**
	 * @param ticketRequest comes in the JSON form with stake and pairs (matchId, outcome)
	 * @return
	 * @throws FegException
	 */
	public TicketPreviewResponse createTicket(TicketRequest ticketRequest) throws FegException {
		logger.info("Creating ticket for request " + ticketRequest);
		Map<Long, Character> bets = ticketRequest.getBets();
		Ticket ticket = new Ticket();
		List<Bet> betList = new ArrayList<>();
		Set<Entry<Long, Character>> entries = bets.entrySet();
		for (Entry<Long, Character> entry : entries) {
			char outcome = Outcome.checkOutcome(entry.getValue());

			Long matchId = entry.getKey();
			Match match = validateMatchId(matchId);

			float odd = match.getOdd(outcome);

			Bet bet = new Bet();
			bet.setMatch(match);
			bet.setOdd(odd);
			bet.setOutcome(outcome);
			bet.setTicket(ticket);
			betList.add(bet);
		}
		ticket.setBets(betList);
		ticket.setStake(ticketRequest.getStake());
		Ticket result = ticketDao.save(ticket);
		betDao.saveAll(betList);
		return result.toTicketPreviewResponse();
	}



	/**
	 * Check does matchId exist in DB table matches
	 * @param matchId
	 * @return
	 * @throws FegException
	 */
	private Match validateMatchId(Long matchId) throws FegException {
		if (matchId == null)
			throw new IncorrectInputException("Match Id must not be NULL");

		Optional<Match> match = matchDao.findById(matchId);
		if (match.isPresent())
			return match.get();
		else
			throw new DataNotFoundException("Incorrect match ID: " + matchId);
	}

	/**
	 * Checks state for specified ticket. If ticket is winning, stores prize value to DB, if it is lost, then stores zero.
	 * @param ticketId
	 * @return result in the form of JSON
	 * @throws DataNotFoundException
	 */
	public TicketCheckResponse checkTicket(long ticketId) throws DataNotFoundException {
		Optional<Ticket> ticketOptional = ticketDao.findById(ticketId);
		if (!ticketOptional.isPresent())
			throw new DataNotFoundException("No ticket for id: " + ticketId);
		Ticket ticket = ticketOptional.get();
		
		TicketPreviewResponse ticketPreviewResponse = ticket.toTicketPreviewResponse();
		TicketCheckResponseBuilder ticketCheckResponseBuilder = new TicketCheckResponseBuilder();
		ticketCheckResponseBuilder.buildProperties(ticketPreviewResponse);
		ticketCheckResponseBuilder.buildBets(ticket.getBets());
		
		TicketCheckResponse result = ticketCheckResponseBuilder.getResult();
		//finally store prize to DB
		if (TicketState.LOST == result.getState()) {
			ticket.setPrize(0f);
			ticketDao.save(ticket);
		}else if (TicketState.WINNING == result.getState()) {
			ticket.setPrize(result.getPrize());
			ticketDao.save(ticket);
		}
		return result;
	}

}
