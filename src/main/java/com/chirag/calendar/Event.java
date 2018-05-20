package com.chirag.calendar;

public class Event {
	int day;
	int month;
	int year;
	String timeSlot;
	String appointmentTitle;
	String appointmentDetails;
	
	public Event(int day,int month,int year, String timeSlot, String appointmentTitle, String appointmentDetails){
		this.day = day;
		this.month = month;
		this.year = year;
		this.timeSlot = timeSlot;
		this.appointmentTitle = appointmentTitle;
		this.appointmentDetails = appointmentDetails;
	}

	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getAppointmentHeader() {
		return appointmentTitle;
	}

	public void setAppointmentTitle(String appointmentTitle) {
		this.appointmentTitle = appointmentTitle;
	}

	public String getAppointmentDetails() {
		return appointmentDetails;
	}

	public void setAppointmentDetails(String appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
	}
}
