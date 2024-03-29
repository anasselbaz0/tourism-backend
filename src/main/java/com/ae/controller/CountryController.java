package com.ae.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ae.business.CountryBusiness;
import com.ae.business.CountryBusinessImpl;
import com.ae.persistance.entity.Country;

@RestController
public class CountryController {

	CountryBusiness countryBusiness = new CountryBusinessImpl();
	
	
	@GetMapping("/countries")
	public List<Country> getAllcountries() {
		return countryBusiness.getAllCountries();
	}

	@PostMapping("/countries")
	public Country addcountry(Country country) {
		return countryBusiness.saveOrUpdateCountry(country);
	}
	
	@GetMapping("/countries/{countryId}")
	public Country getCountryById(@PathVariable("countryId") int id) {
		return countryBusiness.getCountryById(id);
	}
	
	@PutMapping("/countries/{countryId}")
	public Country updatecountry(@PathVariable("countryId") int id) {
		Country t = countryBusiness.getCountryById(id);
		return countryBusiness.saveOrUpdateCountry(t);
	}
	
	@DeleteMapping("/countries/{countryId}")
	public void deletecountry(@PathVariable("countryId") int id) {
		countryBusiness.deleteCountry(id);
	}
	
}
