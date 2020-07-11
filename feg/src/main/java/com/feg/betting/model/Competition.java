package com.feg.betting.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "competitions", schema = "public")
public class Competition {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="competition_id")
	private int id;
	
	@Column(name="competition_name")
	private String name;
	
	 @Convert(converter = SportAttributeConverter.class)
	private Sport sport;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}
