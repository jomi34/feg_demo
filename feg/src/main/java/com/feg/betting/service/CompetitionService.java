package com.feg.betting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feg.betting.dao.CompetitionDao;
import com.feg.betting.model.Competition;
import com.feg.betting.model.Sport;

@Service
public class CompetitionService {
	@Autowired CompetitionDao competitionDao;
	
	public List<Competition> getAllCompetitions(){
		return competitionDao.findAll();		
	}

	public List<Competition> getCompetitionsBySport(String sport) {
		if (sport == null)
			return new ArrayList<>();
		return competitionDao.findBySport(Sport.valueOf(sport.toUpperCase()));
	}

}
