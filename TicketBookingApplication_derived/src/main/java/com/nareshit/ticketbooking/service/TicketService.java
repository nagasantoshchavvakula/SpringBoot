package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.entity.Ticket;

@Service
/*
 * 
 * All the business Logic will be over here
 * 
 * It will automatically takes care of transaction management and we can connect to any other frameworks like KAFKA,JAX WS, RABBITMQ,JMS
 */
public class TicketService {
	
	
	//Need to call TicketDao and perform all the CRUD OPERATIONS
	
	//TicketDao obj=new TicketDao()
	//obj.API....
	
	
	@Autowired
	private TicketDao ticketDao;  //ticketDao will be (creation/manage state/destruction) by the framework
	
	
	
	//Create Ticket
	
	public Ticket createTicket(Ticket inputObj) {
		return ticketDao.save(inputObj);
		//save ==> insert into tbl_ticket values (.....);
		
		/*
		 * 
		 * Save method is for both insert and update based on the inputdata
		 * if inputObj does not have any ticketId ===> if inputObj.getTicketId == null ==> Insert
		 * if inputObj  have any ticketId ===> if inputObj.getTicketId != null==> But this value not there in DB ==> Insert
		 * if inputObj  have any ticketId ===> if inputObj.getTicketId != null==> But this value  there in DB ==> update
		 * 
		 * 
		 */
	}
	
	
	
	//Retrive All Tickets
	
	public Iterable<Ticket>  getAllTickets(){
		return ticketDao.findAll();
		//findAll ==> select * from tbl_ticket
		// Database will give Resultset and this resultset converted into Iterable<Ticket>
	}
	
	
	//Retrieve Single Ticket
	
	public Ticket retrieveTicket(Integer ticketId) {
		return ticketDao.findById(ticketId).
											orElse(new Ticket());
				
				//findById ==> select * from tbl_ticket where ticket_id=ticketId
				//Resultset converted into Ticket Object also taken care by the framework
				//orElse will be executed only when the data is not there
				//
	}
	
	
	
	//Update Ticket
	
	public Ticket updateTicket(Integer ticketId,String newEmail) {
		Ticket dbTicketObj=retrieveTicket(ticketId);
		dbTicketObj.setEmail(newEmail);
		return ticketDao.save(dbTicketObj);
		//Here save Method ==> dbTicketObj.getTicket() is available ==> It exists in DB ==> save ==>update Query
		
		
	}
	//Delete Ticket
	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
		//deleteById==> delete from tbl_ticket where ticket_id=ticketId
	}


	public Ticket findByPassengerName(String passengerName) {
		
		return ticketDao.findByPassengerName(passengerName);
	}

}
