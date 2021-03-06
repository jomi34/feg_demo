package com.feg.betting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feg.betting.dao.CompetitionDao;
import com.feg.betting.dao.MatchDao;
import com.feg.betting.exception.DataNotFoundException;
import com.feg.betting.exception.FegException;
import com.feg.betting.model.Competition;
import com.feg.betting.model.Match;
import com.feg.betting.model.dto.OddRequest;
import com.feg.betting.model.dto.OddResponse;

@Service
public class OddService {
	@Autowired MatchDao matchDao;
	@Autowired CompetitionDao competitionDao;
	
	public List<OddResponse> getAllOdds(){
		return matchDao.findAll().stream().map(Match::toOddResponse).collect(Collectors.toList());	
	}

	public Match createOdd(OddRequest odd) throws FegException{
		Match match = new Match();
		Integer competitionId = odd.getCompetitionId();
		
		if (competitionId != null) {
			Optional<Competition> competition = competitionDao.findById(competitionId);
			if (competition.isPresent())
				match.setCompetition(competition.get());
			else
				throw new DataNotFoundException("Incorrect competition ID: " + competitionId);
		}
		
		match.setKickoff(odd.getKickoff());
		match.setHome(odd.getHome());
		match.setAway(odd.getAway());
		match.setWin(odd.getWin());
		match.setDraw(odd.getDraw());
		match.setLose(odd.getLose());

		return matchDao.save(match);
	}

}
