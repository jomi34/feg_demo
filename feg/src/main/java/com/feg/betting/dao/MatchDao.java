package com.feg.betting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feg.betting.model.Match;

@Repository
public interface MatchDao extends JpaRepository<Match, Long>{
	
}
