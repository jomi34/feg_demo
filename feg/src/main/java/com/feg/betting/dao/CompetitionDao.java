package com.feg.betting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feg.betting.model.Competition;
import com.feg.betting.model.Sport;

@Repository
public interface CompetitionDao extends JpaRepository<Competition, Integer>{

	List<Competition> findBySport(Sport sport);

}
