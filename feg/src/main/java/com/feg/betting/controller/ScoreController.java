package com.feg.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feg.betting.exception.FegException;
import com.feg.betting.model.dto.ScoreRequest;
import com.feg.betting.service.ScoreService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:8080")
public class ScoreController {
	@Autowired
	ScoreService scoreService;

	@PostMapping("scores")
	public ResponseEntity<Object> addScore(@RequestBody ScoreRequest scoreRequest) throws FegException {

		return ResponseEntity.ok().body(scoreService.addScore(scoreRequest));
	}

}
