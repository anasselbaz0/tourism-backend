package com.ae.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae.persistance.entity.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
