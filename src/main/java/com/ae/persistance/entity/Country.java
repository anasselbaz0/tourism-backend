package com.ae.persistance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
public class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private City capital;
	private Integer area;
	private String currency;
	private String flag;
	private String language;
	private String motto;
	private Integer population;
	private String religion;
	private String timeZone;
	private Integer securityClassification;
	private Integer tourismClassification;
	
	public Country() {
		super();
	}

	public Country(Integer id, String name, City capital, Integer area, String currency, String flag, String language,
			String motto, Integer population, String religion, String timeZone, Integer securityClassification,
			Integer tourismClassification) {
		super();
		this.id = id;
		this.name = name;
		this.capital = capital;
		this.area = area;
		this.currency = currency;
		this.flag = flag;
		this.language = language;
		this.motto = motto;
		this.population = population;
		this.religion = religion;
		this.timeZone = timeZone;
		this.securityClassification = securityClassification;
		this.tourismClassification = tourismClassification;
	}
	
	public Country(String name, City capital, Integer area, String currency, String flag, String language,
			String motto, Integer population, String religion, String timeZone, Integer securityClassification,
			Integer tourismClassification) {
		super();
		this.name = name;
		this.capital = capital;
		this.area = area;
		this.currency = currency;
		this.flag = flag;
		this.language = language;
		this.motto = motto;
		this.population = population;
		this.religion = religion;
		this.timeZone = timeZone;
		this.securityClassification = securityClassification;
		this.tourismClassification = tourismClassification;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Integer getSecurityClassification() {
		return securityClassification;
	}

	public void setSecurityClassification(Integer securityClassification) {
		this.securityClassification = securityClassification;
	}

	public Integer getTourismClassification() {
		return tourismClassification;
	}

	public void setTourismClassification(Integer tourismClassification) {
		this.tourismClassification = tourismClassification;
	}
	
	
	
}
