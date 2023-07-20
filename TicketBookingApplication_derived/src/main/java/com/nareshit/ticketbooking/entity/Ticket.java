package com.nareshit.ticketbooking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 
 * Every Java class is table 
 * Every Jaa Property is a column to the table
 * @Entity ==> Is going to create a table with tablename as java class name ==> Default table created with Ticket
 * @Table ==> Its optional which will customizes table name from Ticket to tbl_ticket
 * 
 */

@Entity
@Table(name = "tbl_ticket")
public class Ticket {
	
	/*
	 * 
	 * By default Every Property is Data base column
	 * Default Column name ==> Java Class Property Name
	 * @Column ==> Optional ==> Customizes the column name 
	 * 		   ==> instead of passengerName it will create passenger_name
	 * 
	 * 
	 * AUTO ==> JPA WILL CREATE A SEQUENCE TO THE DATABASE AND IT USES THIS SEQUENCE TO POPULATE THIS PRIMARY KEY
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	
	
	@Column(name = "passenger_name")
	private String passengerName;
	
	@Column(name="source_station")
	private String sourceStation;
	
	@Column(name="destination_station")
	private String destinationStation;
	
	@Column(name="travel_date")
	private Date travelDate;
	
	private String email;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ticket(String passengerName, String sourceStation, String destinationStation,
			String email) {
		super();
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travelDate = new Date();
		this.email = email;
	}
	
	
	public Ticket() {}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", destinationStation=" + destinationStation + ", travelDate=" + travelDate + ", email=" + email
				+ "]";
	}
	
	
	
	

}
