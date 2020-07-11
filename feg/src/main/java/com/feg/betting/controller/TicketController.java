package com.feg.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feg.betting.exception.FegException;
import com.feg.betting.model.dto.TicketRequest;
import com.feg.betting.service.TicketService;

@RestController
@RequestMapping("/api/v1/")
public class TicketController {
	
	@Autowired TicketService ticketService;
	
	@PostMapping("ticket")
	public ResponseEntity<Object> createTicket(@RequestBody TicketRequest ticketRequest) throws FegException{
		
		return ResponseEntity.ok().body(ticketService.createTicket(ticketRequest));
	}
}
