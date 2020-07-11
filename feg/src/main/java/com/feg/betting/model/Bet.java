package com.feg.betting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.feg.betting.model.dto.BetDTO;

@Entity
@Table(name = "bets", schema = "public")
public class Bet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bet_id", nullable=false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="ticket_id", nullable=false)
	private Ticket ticket;
	
	 @ManyToOne
	 @JoinColumn(name="match_id", nullable=false)
	 private Match match;
	 
	 @Column(name="outcome", nullable=false)
	 private char outcome;
	 
	 @Column(name="odd", nullable=false)
	 private float odd;

	public long getId() {
		return id;
	}

	public Match getMatch() {
		return match;
	}

	public float getOdd() {
		return odd;
	}

	public char getOutcome() {
		return outcome;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public void setOdd(float odd) {
		this.odd = odd;
	}

	public void setOutcome(char outcome) {
		this.outcome = outcome;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public BetDTO toBetDTO() {
		BetDTO betDTO = new BetDTO();
		betDTO.setAway(match.getAway());
		betDTO.setHome(match.getHome());
		betDTO.setKickoff(match.getKickoff());
		betDTO.setOdd(odd);
		betDTO.setOutcome(outcome);
		betDTO.setMatchId(match.getId());
		return betDTO;
	}
}
