package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.entity.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/tickets") //http://localhost:8080/tickets
////http://localhost:8080/tickets ==> TicketController obj=ioc.getTicketController();
public class TicketController {
	
	/*
	 * 
	 * Introduction about Rest Services ==> Cross Language Communication 
	 * JSON Object is the preferred mode for data communication
	 * JSON ==> Javascript Object Notation
	 * products={
	 * 		"productName":"TV",
	 * 		"price":10000
	 * 		"qty":100
	 * 
	 * }
	 * 
	 * JAVA Created JAX RS Framework for implementing REST SERVICES
	 * Spring Boot has taken same framework and customized some of the APIs
	 * If we did not speicify any verb ==> Default Get
	 * 
	 * As part of JAX RS ==> @GET  	==> @GET   	+ @REQUESTMAPPING ==> @GETMAPPING
	 * 					 ==> @POST 	==> @POST  	+ @REQUESTMAPPING ==> @POSTMAPPING
	 *   				 ==> @PUT  	==> @PUT   	+ @REQUESTMAPPING ==> @PUTMAPPING
	 *   				 ==> @DELETE==> @DELETE	+ @REQUESTMAPPING ==> @DELETEMAPPING 
	 * 
	 * 
	 * Controller ==> Entry Point from all FE to access any type of data  or else to submit data 
	 * RestController ===> Thru REST Protocol 
	 */
	
	
	//Retrieve All Tickets
	
	
	@Autowired
	private TicketService ticketService;
	
	
	/*
	 * 
	 * http://localhost:8080 ===> Bootstrap Class
	 * http://localhost:8080/tickets ==> TicketController Layer ==> obj will initialized
	 * //http://localhost:8080/tickets/all ==> All Ticket Method
	 * obj.getAllTickets();
	 */
	
	@GetMapping(value="/all") //http://localhost:8080/tickets/all
	public Iterable<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	
	//Creating the Ticket
	@PostMapping(value="/create") //http://localhost:8080/tickets/create
	public Ticket createTicket(@RequestBody Ticket ticketObj) {
		return ticketService.createTicket(ticketObj);
	}
	
	/*
	 * 
	//Retrieving the Ticket
	//http://localhost:8080/tickets/1  ==> 1st Ticket
	//http://localhost:8080/tickets/10 ==> 10th Ticket
	//http://localhost:8080/tickets/100  ==>100th Ticket
	//@PathVariableb ==> Going to scan the URL and reads the variable
	//Dynamic Variable in the Path ==> { }
	@GetMapping(value="/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.retrieveTicket(ticketId);
	}
	
	*/
	//http://localhost:8080/tickets/Ramu
	//http://localhost:8080/tickets/Sandhya
	@GetMapping(value="/{passengerName}")
	/*public Ticket getTicket(@PathVariable("passengerName") String passengerName) {
		return ticketService.findByPassengerName(passengerName);
	}
	*/
	//Update Ticket
	//http-://localhost:8080/tickets/1/a@b.com
	@PutMapping(value="/{ticketId}/{newEmail}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId,
			@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}
	
	
	//http://localhost:8080/tickets/1
	@DeleteMapping(value="/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}

}
