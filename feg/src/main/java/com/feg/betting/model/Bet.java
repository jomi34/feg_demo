package com.feg.betting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.feg.betting.exception.IncorrectInputException;
import com.feg.betting.model.dto.BetCheckDTO;
import com.feg.betting.model.dto.BetPreviewDTO;
import static com.feg.betting.model.Outcome.*;

/**
 * Entity which represent a bet placed on a certain ticket
 * @author kalebmij
 *
 */
@Entity
@Table(name = "bets", schema = "public")
public class Bet {
	private static final char CHAR = '2';

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

	/**
	 * Id of bet in DB
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * Match bet is related on
	 * @return
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * Odd (coefficient)
	 * @return
	 */
	public float getOdd() {
		return odd;
	}

	/**
	 * Predicted outcome. It allows values 'X' or '0' for a draw, '1' for home win or '2' for away win.
	 * @return
	 */
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
	
	
	/**
	 * Converts object to BetDTO
	 * @return
	 */
	public BetPreviewDTO toBetDTO() {
		BetPreviewDTO betDTO = new BetPreviewDTO();
		betDTO.setAway(match.getAway());
		betDTO.setHome(match.getHome());
		betDTO.setKickoff(match.getKickoff());
		betDTO.setOdd(odd);
		betDTO.setOutcome(outcome);
		betDTO.setMatchId(match.getId());
		return betDTO;
	}
	
	public boolean isActive() {
		return match.getScore() == null;
	}
	
	/**
	 * Case if game was started and suspended or not played. Not implemented yet.
	 * @return
	 */
	public boolean isCanceled() {
		Score score = match.getScore();
		return score.getScoreHome() == null || score.getScoreAway() == null;
	}
	
	public boolean isPredicted() {
		if (isActive() || isCanceled())
			return false;
		Score score = match.getScore();
		int scoreHome = score.getScoreHome();
		int scoreAway = score.getScoreAway();
		switch (outcome) {
		case '0':
		case 'x':
		case 'X':
			return scoreHome == scoreAway;
		case '1':
			return scoreHome > scoreAway;
		case '2':
			return scoreHome < scoreAway;
		default:
			break;
		}
		return false;
	}

	public BetCheckDTO toBetCheckDTO() {
		BetCheckDTO betDTO = new BetCheckDTO();
		betDTO.setAway(match.getAway());
		betDTO.setHome(match.getHome());
		betDTO.setKickoff(match.getKickoff());
		betDTO.setOdd(odd);
		betDTO.setOutcome(outcome);
		betDTO.setMatchId(match.getId());
		
		Score score = match.getScore();
		int scoreHome = score.getScoreHome();
		betDTO.setScoreHome(scoreHome);
		int scoreAway = score.getScoreAway();
		betDTO.setScoreAway(scoreAway);
		final char winningOutcome;
		if (scoreHome == scoreAway)
			winningOutcome = 'X';
		else if (scoreHome > scoreAway)
			winningOutcome = '1';
		else
			winningOutcome = CHAR;
		betDTO.setWinningOutcome(winningOutcome);
		return betDTO;
	}
}
