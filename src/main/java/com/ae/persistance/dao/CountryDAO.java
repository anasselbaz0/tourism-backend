package com.ae.persistance.dao;

import java.util.List;

import com.ae.persistance.entity.City;
import com.ae.persistance.entity.Country;

public interface CountryDAO {

	public List<Country> getAllCountries();
	public Country saveOrUpdateCountry(Country country);
	public Country getCountryById(int id);
	public void deleteCountry(int id);
	
}
