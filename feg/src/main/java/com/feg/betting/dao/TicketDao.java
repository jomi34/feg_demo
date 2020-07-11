package com.feg.betting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feg.betting.model.Match;
import com.feg.betting.model.Ticket;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Long>{
	
}
