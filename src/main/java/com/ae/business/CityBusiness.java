package com.ae.business;

import java.util.List;

import com.ae.persistance.entity.City;

public interface CityBusiness {

	public List<City> getAllCities();
	public City saveOrUpdateCity(City city);
	public City getCityById(int id);
	public void deleteCity(int id);
	
	
}
