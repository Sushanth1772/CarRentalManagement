package com.cts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.demo.exception.ResourceNotFoundException;
import com.cts.demo.model.Car;
import com.cts.demo.repository.CarRepository;
import com.cts.demo.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}

	@Override
	public Car saveCar(Car car) {
		// TODO Auto-generated method stub
		return carRepository.save(car);
	}

	@Override
	public void deleteCars(long id) {
		// TODO Auto-generated method stub
		carRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Car","Id",id));
		carRepository.deleteById(id);
		
	}

}
