package com.ankit.student.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankit.student.flightcheckin.integration.ReservationRestClient;
import com.ankit.student.flightcheckin.integration.dto.Reservation;
import com.ankit.student.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInControllers {

	@Autowired
	ReservationRestClient reservationRestClient;
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin(){
		return "startCheckIn";
		
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId,ModelMap modelmap){
		Reservation reservation = reservationRestClient.findReservation(reservationId);
		modelmap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
		
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags")int noOfCheckInBags){
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNoOfBags(noOfCheckInBags);
		reservationRestClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
		
	}
}
