package com.ankit.student.flightcheckin.integration;

import com.ankit.student.flightcheckin.integration.dto.Reservation;
import com.ankit.student.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);

}
