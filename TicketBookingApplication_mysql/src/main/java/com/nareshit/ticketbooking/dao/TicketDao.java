package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.entity.Ticket;

/*
 * 
 * If we want to work with Ticket Table we will use TicketDao
 * @Repository ==> This will scan datasource and connects to the database
 * 
 * 
 * FOR EVERY TABLE COMMON OPERATIONS ==> CRUD OPERATIONS
 * 
 * 
 * C ==> CREATING THEDATA ==> INSERT STATEMENT
 * 
 * R ==> READING THE DATA ==> SELECT STATEMENT
 * 
 * U ==> UPDATE THE DATA ==> UPDATE STATEMENT
 * 
 * D ==> DELETE TEH DATA ==> DELETE STATEMENT
 * 
 * 
 * SPRING BOOT CREATED CRUDREPOSITORY ==> DEVELOPER NO NEED TO WRITE CODE FOR CRUD OPERATIONS
 * 
 *             TWO INPUTS ==> 1) ENTITY CLASS NAME(TABLE)
 *                        ==> 2) DATA TYPE OF PRIMARY KEY IN ENTITY CLASS
 * 
 */
@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer>{
	
	
	
	
	//All CRUD REPOSITIORY APIS ARE AVAIABLE IN TICKETDAO
	
	/*
	 *  * C ==> CREATING THEDATA ==> INSERT STATEMENT  		  => SAVE API ==> TICKETDAO.SAVE()
	 * 
	 * R ==> READING THE DATA ==> SELECT STATEMENT    		  ==> FINDALL ==> TICKETDAO.FINDALL()
	 * 						  ==> SELECT SPRICIFIC RECORD	  ==> FINDBYID ==> TICKETDAO.FINDBYID()
	 * 
	 * U ==> UPDATE THE DATA ==> UPDATE STATEMENT			  ==> SAVE API ==> TICKETDAO.SAVE()
	 * 
	 * D ==> DELETE THE DATA ==> DELETE STATEMENT			  ==> DELETE API ==> TICKETDAO.DELETEBYID()
	 *   
	 * 
	 * 
	 * 
	 */

}
