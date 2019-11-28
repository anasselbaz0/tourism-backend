package com.ae.business;

import java.util.List;

import com.ae.persistance.dao.CountryDAO;
import com.ae.persistance.dao.CountryDAOImpl;
import com.ae.persistance.entity.Country;
import com.ae.persistance.repository.CountryRepository;

public class CountryBusinessImpl implements CountryBusiness {

	CountryDAO countryDAO = new CountryDAOImpl();
	CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountries() {
		return countryDAO.getAllCountries();
	}

	@Override
	public Country saveOrUpdateCountry(Country country) {
		//CountryRepository.save(Country);
		return countryDAO.saveOrUpdateCountry(country);
	}

	@Override
	public Country getCountryById(int id) {
		return countryDAO.getCountryById(id);
	}

	@Override
	public void deleteCountry(int id) {
		countryRepository.deleteById(id);
		countryDAO.deleteCountry(id);
	}

}
