package com.mmt.model.bean;



public class Flight {
	private String flightCompanyName;
	private String flightId;
	private String flightSource;
	private String flightDestination;
	private String flightDepartureTime;
	private String flightArrivalTime;
	private double flightTicketPrice;
	private int availableSeats;
	
	
	
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(String flightCompanyName, String flightId, String flightSource, String flightDestination,
			String flightDepartureTime, String flightArrivalTime, double flightTicketPrice, int availableSeats) {
		super();
		this.flightCompanyName = flightCompanyName;
		this.flightId = flightId;
		this.flightSource = flightSource;
		this.flightDestination = flightDestination;
		this.flightDepartureTime = flightDepartureTime;
		this.flightArrivalTime = flightArrivalTime;
		this.flightTicketPrice = flightTicketPrice;
		this.availableSeats = availableSeats;
	}
	public String getFlightCompanyName() {
		return flightCompanyName;
	}
	public void setFlightCompanyName(String flightCompanyName) {
		this.flightCompanyName = flightCompanyName;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightSource() {
		return flightSource;
	}
	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}
	public String getFlightDestination() {
		return flightDestination;
	}
	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}
	public String getFlightDepartureTime() {
		return flightDepartureTime;
	}
	public void setFlightDepartureTime(String flightDepartureTime) {
		this.flightDepartureTime = flightDepartureTime;
	}
	public String getFlightArrivalTime() {
		return flightArrivalTime;
	}
	public void setFlightArrivalTime(String flightArrivalTime) {
		this.flightArrivalTime = flightArrivalTime;
	}
	public double getFlightTicketPrice() {
		return flightTicketPrice;
	}
	public void setFlightTicketPrice(double flightTicketPrice) {
		this.flightTicketPrice = flightTicketPrice;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	@Override
	public String toString() {
		return "Flight [flightCompanyName=" + flightCompanyName + ", flightId=" + flightId + ", flightSource="
				+ flightSource + ", flightDestination=" + flightDestination + ", flightDepartureTime="
				+ flightDepartureTime + ", flightArrivalTime=" + flightArrivalTime + ", flightTicketPrice="
				+ flightTicketPrice + ", availableSeats=" + availableSeats + "]";
	}
	
	
	
	
}
