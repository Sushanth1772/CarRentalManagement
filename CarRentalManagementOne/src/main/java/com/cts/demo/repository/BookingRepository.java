package com.cts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.demo.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long>{
	
}
