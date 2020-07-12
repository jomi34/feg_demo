/**
 * 
 */
package com.feg.betting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.feg.betting.model.dto.ScoreResponse;

/**
 * Entity class which stores results of particular match to DB. If match was
 * suspended or cancelled, null values are written to both scoreHome and
 * scoreAway fields.
 * 
 * @author kalebmij
 *
 */
@Entity
@Table(name = "scores", schema = "public")
public class Score {
	@Id
	@Column(name="match_id")
	private long id;
	
	@OneToOne
	@MapsId
    @JoinColumn(name="match_id")
	private Match match;

	@Column(name = "score_home", nullable = true)
	private Integer scoreHome;

	@Column(name = "score_away", nullable = true)
	private Integer scoreAway;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the match
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * @return the scoreAway
	 */
	public Integer getScoreAway() {
		return scoreAway;
	}

	/**
	 * @return the scoreHome
	 */
	public Integer getScoreHome() {
		return scoreHome;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param match the match to set
	 */
	public void setMatch(Match match) {
		this.match = match;
	}

	/**
	 * @param scoreAway the scoreAway to set
	 */
	public void setScoreAway(Integer scoreAway) {
		this.scoreAway = scoreAway;
	}

	/**
	 * @param scoreHome the scoreHome to set
	 */
	public void setScoreHome(Integer scoreHome) {
		this.scoreHome = scoreHome;
	}
	
	public ScoreResponse toScoreResponse() {
		ScoreResponse scoreResponse = new ScoreResponse();
		scoreResponse.setMatchId(match.getId());
		scoreResponse.setHome(match.getHome());
		scoreResponse.setAway(match.getAway());
		if (scoreHome != null && scoreAway != null) {
			scoreResponse.setScoreHome(scoreHome);
			scoreResponse.setScoreAway(scoreAway);
			scoreResponse.setStatus("Finished");
		} else {
			scoreResponse.setStatus("Canceled/Suspended");
		}
			
		return scoreResponse;
	}

}
