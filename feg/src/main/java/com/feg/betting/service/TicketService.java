package com.feg.betting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

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
import com.feg.betting.model.Ticket;
import com.feg.betting.model.dto.TicketRequest;
import com.feg.betting.model.dto.TicketResponse;

@Service
public class TicketService {
	@Autowired
	TicketDao ticketDao;
	@Autowired MatchDao matchDao;
	@Autowired BetDao betDao;

	public TicketResponse createTicket(TicketRequest ticketRequest) throws FegException {
		Map<Long, Character> bets = ticketRequest.getBets();
		Ticket ticket = new Ticket();
		List<Bet> betList = new ArrayList<>();
		Set<Entry<Long, Character>> entries = bets.entrySet();
		for (Entry<Long, Character> entry : entries) {
			Character outcome = entry.getValue();
			if (outcome == null || (outcome.charValue() != '0' && outcome.charValue() != '1' && outcome.charValue() != '2'
					&& outcome.charValue() != 'x' && outcome.charValue() != 'X'))
				throw new IncorrectInputException("Outcome value " + outcome + " not supported.");
			Long matchId = entry.getKey();
			Match match = validateMatchId(matchId);
			
			float odd = getOdd(match, outcome);
			
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
		return result.toTicketResponse();
	}

	private float getOdd(Match match, char outcome) throws FegException{
		Float result;
		switch (outcome) {
		case '0':case 'x':case 'X':
			result =match.getDraw();
			break;
		case '1':
			result = match.getWin();
			break;
		default:
			result = match.getLose();
			break;
		}
		if (result == null)
			throw new DataNotFoundException("No odd for predicted outcome!");
		if (result < 1.00)
			throw new IncorrectInputException("Provided odd should not be less than 1.00!");
		return result;
	}

	private Match validateMatchId(Long matchId) throws FegException {
		if (matchId == null)
			throw new IncorrectInputException("Match Id must not be NULL");
		
		Optional<Match> match = matchDao.findById(matchId);
		if (match.isPresent())
			return match.get();
		else
			throw new DataNotFoundException("Incorrect match ID: " + matchId);
	}

}
