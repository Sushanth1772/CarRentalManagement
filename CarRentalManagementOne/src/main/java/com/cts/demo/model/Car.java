package com.cts.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
@Table(name="cars")
public class Car {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String brand;
	private String color;
	private String type;
	private String transmission;
	private String description;
	private int price;
	private int year;
	
}
