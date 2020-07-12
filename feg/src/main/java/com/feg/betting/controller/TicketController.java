package com.feg.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feg.betting.exception.FegException;
import com.feg.betting.model.dto.TicketCheckResponse;
import com.feg.betting.model.dto.TicketPreviewResponse;
import com.feg.betting.model.dto.TicketRequest;
import com.feg.betting.service.TicketService;

/**
 * Controller class for actions related to tickets
 * @author kalebmij
 *
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:8080")
public class TicketController {
	
	@Autowired TicketService ticketService;
	
	@PostMapping("tickets")
	public ResponseEntity<Object> createTicket(@RequestBody TicketRequest ticketRequest) throws FegException{
		TicketPreviewResponse ticketResponse = ticketService.createTicket(ticketRequest);
		return ResponseEntity.ok().body(ticketResponse);
	}
	
	@GetMapping("tickets/{ticketId}")
	public ResponseEntity<Object> checkTicket(@PathVariable(value = "ticketId") long ticketId) throws FegException{
		TicketCheckResponse ticketResponse = ticketService.checkTicket(ticketId);
		return ResponseEntity.ok().body(ticketResponse);

	} 
}
