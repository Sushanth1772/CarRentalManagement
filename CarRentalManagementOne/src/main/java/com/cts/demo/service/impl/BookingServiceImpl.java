package com.cts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.demo.exception.ResourceNotFoundException;
import com.cts.demo.model.Booking;
import com.cts.demo.model.User;
import com.cts.demo.repository.BookingRepository;
import com.cts.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;
	@Override
	public Booking savebookings(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}
	@Override
	public List<Booking> getAllbookings() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}
	@Override
	public Booking UpdateBooking(Booking booking, long id) {
		// TODO Auto-generated method stub
		Booking  existingBooking = bookingRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Booking","Id",id));
		existingBooking.setStatus(booking.getStatus());
		existingBooking.setFromDate(booking.getFromDate());
		existingBooking.setToDate(booking.getToDate());
		existingBooking.setPrice(booking.getPrice());
		bookingRepository.save(existingBooking);
		return existingBooking;
	}

	@Override
	public void deleteBooking(long id) {
		// TODO Auto-generated method stub
		bookingRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Booking","Id",id));
		bookingRepository.deleteById(id);
	}

}
