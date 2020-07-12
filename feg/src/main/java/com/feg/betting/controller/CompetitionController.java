package com.feg.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feg.betting.service.CompetitionService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:8080")
public class CompetitionController {
		
	@Autowired CompetitionService competitionService;
	
	@GetMapping("competitions")
	public ResponseEntity<Object> getCompetitions(){
		return new ResponseEntity<>(competitionService.getAllCompetitions(), HttpStatus.OK);
	}
	
	@GetMapping("competitions/{sport}")
	public ResponseEntity<Object> getCompetitionsBySport(@PathVariable(value = "sport") String sport){
		return new ResponseEntity<>(competitionService.getCompetitionsBySport(sport), HttpStatus.OK);

	}

}
