package com.ae.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae.persistance.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
