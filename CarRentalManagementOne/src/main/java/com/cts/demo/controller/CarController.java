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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.demo.dto.CarDto;
import com.cts.demo.model.Car;
import com.cts.demo.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Car> saveCar(@Valid @RequestBody CarDto carDto){
		Car car = mapToEntity(carDto);
		return new ResponseEntity<Car>(carService.saveCar(car),HttpStatus.CREATED);
	}
	
	@GetMapping("/allcars")
	public List<Car> getAllCars(){
		return carService.getAllCars();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCars(@PathVariable("id") long id){
		carService.deleteCars(id);
		return new ResponseEntity<String>("Car successfully deleted!",HttpStatus.OK);
	}
	
	private Car mapToEntity(CarDto carDto) {
		Car car = new Car();
	    car.setBrand(carDto.getBrand());
	    car.setColor(carDto.getColor());
	    car.setType(carDto.getType());
	    car.setTransmission(carDto.getTransmission());
	    car.setDescription(carDto.getDescription());
	    car.setPrice(carDto.getPrice());
	    car.setYear(carDto.getYear());
		return car;
	}

}
