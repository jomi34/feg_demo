package com.feg.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feg.betting.exception.FegException;
import com.feg.betting.model.dto.OddDTO;
import com.feg.betting.service.CompetitionService;
import com.feg.betting.service.OddService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:8080")
public class OddController {
		
	@Autowired OddService oddService;
	
	@GetMapping("odds")
	public ResponseEntity<Object> getOdds(){
		return new ResponseEntity<>(oddService.getAllOdds(), HttpStatus.OK);
	}
	
	@PostMapping("odds")
	public ResponseEntity<Object> createOdd(@RequestBody OddDTO odd) throws FegException{
		
		return ResponseEntity.ok().body(oddService.createOdd(odd));
	}

}
