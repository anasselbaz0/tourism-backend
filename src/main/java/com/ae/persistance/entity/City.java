package com.ae.persistance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Integer population;
	private Integer security_classification;
	private Integer tourism_classification;
	private Integer zip_code;
	private String web_site;
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(String name, Integer population, Integer security_classification, Integer tourism_classification, Integer zip_code, String web_site) {
		super();
		this.name = name;
		this.population = population;
		this.security_classification = security_classification;
		this.tourism_classification = tourism_classification;
		this.zip_code = zip_code;
		this.web_site = web_site;
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

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Integer getSecurity_classification() {
		return security_classification;
	}

	public void setSecurity_classification(Integer security_classification) {
		this.security_classification = security_classification;
	}

	public Integer getTourism_classification() {
		return tourism_classification;
	}

	public void setTourism_classification(Integer tourism_classification) {
		this.tourism_classification = tourism_classification;
	}

	public Integer getZip_code() {
		return zip_code;
	}

	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}

	public String getWeb_site() {
		return web_site;
	}

	public void setWeb_site(String web_site) {
		this.web_site = web_site;
	}
	
	
	
	
}
