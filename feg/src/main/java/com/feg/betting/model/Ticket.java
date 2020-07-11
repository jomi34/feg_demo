package com.feg.betting.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.SetUtils;

import com.feg.betting.model.dto.BetDTO;
import com.feg.betting.model.dto.TicketResponse;

@Entity
@Table(name = "tickets", schema = "public")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private long id;
	
	@Column(name = "payment_time", columnDefinition = "TIMESTAMP", nullable=false)
	private LocalDateTime paymentTime = LocalDateTime.now();

	@Column(name="stake", nullable=false)
	private float stake;
	
	@OneToMany(mappedBy="ticket")
    private List<Bet> bets;

	public List<Bet> getBets() {
		return bets;
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public float getStake() {
		return stake;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}
	
	public void setStake(float stake) {
		this.stake = stake;
	}
	
	public TicketResponse toTicketResponse() {
		TicketResponse response = new TicketResponse();
		response.setTicketId(id);
		response.setStake(stake);
		List<BetDTO> betsDTO = new ArrayList<BetDTO>();
		
		float multipliedOdd = 1.00f;
		
		Map<Sport, Integer> sportsFrequency = new HashMap<Sport, Integer>();
		
		if (bets != null) {
			for (Bet bet : bets) {
				betsDTO.add(bet.toBetDTO());
				multipliedOdd *= bet.getOdd();
				Match match = bet.getMatch();
				Sport sport = match.getCompetition().getSport();
				Integer frequency = sportsFrequency.get(sport);
				if (frequency == null) {
					sportsFrequency.put(sport, 1);
				}
				else{
					sportsFrequency.put(sport, frequency + 1);
				}
			} 
		}
		response.setMultipliedOdd(multipliedOdd);
		float bonus = 0;
		//popular sports are sports presented by more than 2 bets on ticket
		List<Integer> popularSports = sportsFrequency.values().stream().filter(c -> c >= 3).collect(Collectors.toList());
		
		if (multipliedOdd > 5 && CollectionUtils.isNotEmpty(popularSports)) {
			bonus += 5 * popularSports.size();
		}
		Set<Sport> allSportsOnTicket = sportsFrequency.keySet();
		if (multipliedOdd > 10 && allSportsOnTicket.size() == 1 && bets != null && bets.size() >= 3) {
			bonus += 10;
		}
		float overallOdd = multipliedOdd + bonus;
		response.setBets(betsDTO);
		response.setBonus(bonus);
		response.setOverallOdd(overallOdd);
		response.setPrize(overallOdd * stake); 
		return response;
	}
}
