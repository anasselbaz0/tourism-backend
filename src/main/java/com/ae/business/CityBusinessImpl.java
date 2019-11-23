package com.ae.business;

import java.util.List;

import com.ae.persistance.dao.CityDAO;
import com.ae.persistance.dao.CityDAOImpl;
import com.ae.persistance.entity.City;
import com.ae.persistance.repository.CityRepository;

public class CityBusinessImpl implements CityBusiness {

	CityDAO cityDAO = new CityDAOImpl();
	CityRepository cityRepository;

	@Override
	public List<City> getAllCities() {
		return cityDAO.getAllCities();
	}

	@Override
	public City saveOrUpdateCity(City city) {
		cityRepository.save(city);
		return cityDAO.saveOrUpdateCity(city);
	}

	@Override
	public City getCityById(int id) {
		return cityDAO.getCityById(id);
	}

	@Override
	public void deleteCity(int id) {
		cityRepository.deleteById(id);
		cityDAO.deleteCity(id);
	}

}
