package com.cts.demo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingDto {

	@NotBlank(message="Status is required")
	private String status;
	@NotNull(message="fromDate is required")
	private LocalDate fromDate;
	@NotNull(message="toDate is required")
	private LocalDate toDate;
	
	@NotNull(message="price is required")
	private int price;
}
