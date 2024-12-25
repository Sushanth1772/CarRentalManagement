package com.cts.demo.service;

import java.util.List;

import com.cts.demo.model.Car;


public interface CarService {
	Car saveCar(Car car);
	List<Car> getAllCars();
	void deleteCars(long id);
}
