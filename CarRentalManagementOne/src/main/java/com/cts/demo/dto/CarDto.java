package com.cts.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CarDto {
	private long id;
	
	@NotBlank(message="Brand is required")
	private String brand;
	
	@NotBlank(message="Color is required")
	private String color;
	
	@NotBlank(message="type is required")
	private String type;
	
	@NotBlank(message="Transmission is required")
	private String transmission;
	
	@NotBlank(message="description is required")
	private String description;
	
	@NotNull(message="price is required")
	@Positive(message="price must be positive")
	private int price;
	
	@NotNull(message="Year is required")
	private int year;
}
