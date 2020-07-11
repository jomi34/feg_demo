package com.feg.betting.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matches", schema = "public")
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="match_id")
	private long id;
	
	 @ManyToOne
	 @JoinColumn(name="competition_id", nullable=false)
	 private Competition competition;
	 
	 @Column(name = "kickoff", columnDefinition = "TIMESTAMP", nullable=false)
	 private LocalDateTime kickoff;
	 
	 @Column(name="home", nullable=false)
	 private String home;

	@Column(name="away", nullable=false)
	 private String away;

	@Column(name="win", nullable=true)
	 private Float win;

	@Column(name="draw", nullable=true)
	 private Float draw;

	@Column(name="lose", nullable=true)
	 private Float lose;

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
	 
	 public void setWin(Float win) {
		this.win = win;
	}

}
