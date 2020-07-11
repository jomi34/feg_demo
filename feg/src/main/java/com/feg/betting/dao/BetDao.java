package com.feg.betting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feg.betting.model.Bet;
import com.feg.betting.model.Match;

@Repository
public interface BetDao extends JpaRepository<Bet, Long>{
	
}
