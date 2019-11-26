package com.ae.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ae.business.CityBusiness;
import com.ae.business.CityBusinessImpl;
import com.ae.persistance.entity.City;

@RestController
public class CityController {

	CityBusiness cityBusiness = new CityBusinessImpl();
	
	
	@GetMapping("/cities")
	public List<City> getAllCities() {
		return cityBusiness.getAllCities();
	}

	
	@PostMapping("/cities")
	public City addCity(City City) {
		return cityBusiness.saveOrUpdateCity(City);
	}
	
	@GetMapping("/cities/{CityId}")
	public City getCityById(@PathVariable("cityId") int id) {
		return cityBusiness.getCityById(id);
	}
	
	@PutMapping("/cities/{CityId}")
	public City updateCity(@PathVariable("cityId") int id) {
		City t = cityBusiness.getCityById(id);
		return cityBusiness.saveOrUpdateCity(t);
	}
	
	@DeleteMapping("/cities/{CityId}")
	public void deleteCity(@PathVariable("cityId") int id) {
		cityBusiness.deleteCity(id);
	}
	
}
