package com.cts.demo.service;

import java.util.List;

import com.cts.demo.model.Booking;

public interface BookingService {
	Booking savebookings(Booking booking);
	List<Booking> getAllbookings();
	Booking UpdateBooking(Booking booking,long id);
	void deleteBooking(long id);
}
