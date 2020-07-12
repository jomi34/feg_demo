/**
 * 
 */
package com.feg.betting.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feg.betting.dao.MatchDao;
import com.feg.betting.dao.ScoreDao;
import com.feg.betting.exception.DataNotFoundException;
import com.feg.betting.exception.DuplicatedDataException;
import com.feg.betting.exception.FegException;
import com.feg.betting.model.Match;
import com.feg.betting.model.Score;
import com.feg.betting.model.dto.ScoreRequest;
import com.feg.betting.model.dto.ScoreResponse;

/**
 * @author kalebmij
 *
 */
@Service
public class ScoreService {
	@Autowired ScoreDao scoreDao;
	@Autowired MatchDao matchDao;
	
	public ScoreResponse addScore(ScoreRequest scoreRequest) throws FegException {
		if (scoreRequest == null)
			return null;
		Optional<Match> matchOptional = matchDao.findById(scoreRequest.getMatchId());
		if (!matchOptional.isPresent())
			throw new DataNotFoundException("Match for provided id " + scoreRequest.getMatchId() + " does not exist.");
		Match match = matchOptional.get();
		Optional<Score> scoreOptional = scoreDao.findById(scoreRequest.getMatchId());
		if (scoreOptional.isPresent())
			throw new DuplicatedDataException("Score for provided id " + scoreRequest.getMatchId() + " already exists.");
		Score score = new Score();
		
		score.setMatch(match);
		score.setScoreHome(scoreRequest.getScoreHome());
		score.setScoreAway(scoreRequest.getScoreAway());
		scoreDao.save(score);
		
		return score.toScoreResponse();
	}

}
