package com.cts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.demo.model.Car;

public interface CarRepository extends JpaRepository<Car,Long>{

}
