package com.ae.business;

import java.util.List;

import com.ae.persistance.entity.Country;

public interface CountryBusiness {

	public List<Country> getAllCountries();
	public Country saveOrUpdateCountry(Country country);
	public Country getCountryById(int id);
	public void deleteCountry(int id);
	
	
}
