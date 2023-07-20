package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.entity.Ticket;


@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer>{
	
	public Ticket findByPassengerName(String passengerName);
	//Developer will write Abstract method and framework will implement

	//public Ticket findByPassengerName(String passengerName);
	

}
