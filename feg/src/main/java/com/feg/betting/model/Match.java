package com.feg.betting.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.feg.betting.exception.DataNotFoundException;
import com.feg.betting.exception.FegException;
import com.feg.betting.exception.IncorrectInputException;

/**
 * Entity class representing DB table match. It stores information about opponents and odds before the game. Result of the match is stored to separate table Scores.
 * @author kalebmij
 *
 */
@Entity
@Table(name = "matches", schema = "public")
public class Match {
	public enum Status {
		NOT_STARTED, RUNNING, FINISHED, CANCELED, SUSPENDED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "match_id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "competition_id", nullable = false)
	private Competition competition;

	@Column(name = "kickoff", columnDefinition = "TIMESTAMP", nullable = false)
	private LocalDateTime kickoff;

	@Column(name = "home", nullable = false)
	private String home;

	@Column(name = "away", nullable = false)
	private String away;

	@Column(name = "win", nullable = true)
	private Float win;

	@Column(name = "draw", nullable = true)
	private Float draw;

	@Column(name = "lose", nullable = true)
	private Float lose;

	@OneToOne(mappedBy = "match")
	private Score score;

	public String getAway() {
		return away;
	}

	public Competition getCompetition() {
		return competition;
	}

	public Float getDraw() {
		return draw;
	}

	public String getHome() {
		return home;
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getKickoff() {
		return kickoff;
	}

	public Float getLose() {
		return lose;
	}

	/**
	 * @return the score
	 */
	public Score getScore() {
		return score;
	}

	public Status getStatus() {
		if (kickoff.compareTo(LocalDateTime.now()) > 0)
			return Status.NOT_STARTED;
		if (score == null)
			return Status.RUNNING;
		if (score.getScoreAway() == null || score.getScoreHome() == null)
			return Status.CANCELED;
		return Status.FINISHED;
	}

	public Float getWin() {
		return win;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public void setDraw(Float draw) {
		this.draw = draw;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setKickoff(LocalDateTime kickoff) {
		this.kickoff = kickoff;
	}

	public void setLose(Float lose) {
		this.lose = lose;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Score score) {
		this.score = score;
	}

	public void setWin(Float win) {
		this.win = win;
	}

	/**
	 * Gets odd for specified outcome type
	 * @param outcome
	 * @return
	 * @throws FegException
	 */
	public float getOdd(char outcome) throws FegException {
		Float result;
		switch (outcome) {
		case '0':
		case 'x':
		case 'X':
			result = getDraw();
			break;
		case '1':
			result = getWin();
			break;
		default:
			result = getLose();
			break;
		}
		if (result == null)
			throw new DataNotFoundException("No odd for predicted outcome!");
		if (result < 1.00)
			throw new IncorrectInputException("Provided odd should not be less than 1.00!");
		return result;
	}

}
