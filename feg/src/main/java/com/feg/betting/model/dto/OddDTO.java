package com.feg.betting.model.dto;

import java.time.LocalDateTime;

public class OddDTO {
	private LocalDateTime kickoff;
	  private String home;

	 private String away;

	 private Float win;

	 private Float draw;

	 private Float lose;
	 

		public String getAway() {
			return away;
		}
		
		public Float getDraw() {
			return draw;
		}

		public String getHome() {
			return home;
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
		
		public void setDraw(Float draw) {
			this.draw = draw;
		}

		public void setHome(String home) {
			this.home = home;
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
