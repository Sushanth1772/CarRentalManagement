package com.cts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.demo.dto.BookingDto;
import com.cts.demo.model.Booking;
import com.cts.demo.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<Booking> savebookings(@Valid @RequestBody BookingDto bookingDto) {
		Booking booking = mapToEntity(bookingDto);
		return new ResponseEntity<Booking>(bookingService.savebookings(booking),HttpStatus.CREATED);
	}
	
	@GetMapping("/rentals")
	public List<Booking> getAllbookings(){
		return bookingService.getAllbookings();
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Booking> updatebooking(@Valid @RequestBody BookingDto bookingDto,@PathVariable("id") long id){
		Booking booking = mapToEntity(bookingDto);
		return new ResponseEntity<Booking>(bookingService.UpdateBooking(booking, id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable("id") long id){
		bookingService.deleteBooking(id);
		return new ResponseEntity<String>("Booking Successfully deleted!",HttpStatus.OK);
	}
	
	private Booking mapToEntity(BookingDto bookingDto) {
		Booking booking = new Booking();
		booking.setStatus(bookingDto.getStatus());
        booking.setFromDate(bookingDto.getFromDate());
        booking.setToDate(bookingDto.getToDate());
        booking.setPrice(bookingDto.getPrice());
		return booking;
	}
}
