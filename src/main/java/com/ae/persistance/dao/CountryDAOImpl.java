package com.ae.persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.graph.Node;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import com.ae.AppConf;
import com.ae.Tools;
import com.ae.persistance.entity.City;
import com.ae.persistance.entity.Country;
import com.ae.persistance.repository.CityRepository;

public class CountryDAOImpl implements CountryDAO {

	@Override
	public List<Country> getAllCountries() {
		String queryS = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX tont: <http://localhost:80/tourism-ontology/1.0#> "
				+ "CONSTRUCT {"
				+ "		?country tont:name ?name . "
				+ "		?country tont:capital ?capital . "
				+ "		?country tont:security_classification ?sec . "
				+ "		?country tont:tourism_classification ?tour . "
				+ "		?country tont:area ?area . "
				+ "		?country tont:currency ?currency . "
				+ "		?country tont:flag ?flag . "
				+ "		?country tont:language ?language . "
				+ "		?country tont:population ?population . "
				+ "		?country tont:motto ?motto . "
				+ "		?country tont:religion ?religion . "
				+ "		?country tont:time_zone ?timeZone . "
				+ "}"
				+ "WHERE { "
				+ "		?country tont:name ?name . "
				+ "		?country tont:capital ?capital . "
				+ "		?country tont:security_classification ?sec . "
				+ "		?country tont:tourism_classification ?tour . "
				+ "		?country tont:area ?area . "
				+ "		?country tont:currency ?currency . "
				+ "		?country tont:flag ?flag . "
				+ "		?country tont:language ?language . "
				+ "		?country tont:population ?population . "
				+ "		?country tont:motto ?motto . "
				+ "		?country tont:religion ?religion . "
				+ "		?country tont:time_zone ?timeZone . "
				+ "}";
		Model model = Tools.executeConstructQuery(queryS);
		List<Country> listCountries = this.model2list(model);
//		for (City city : listCities) {
//			cityRepo.save(city);
//		}
		return listCountries;
	}

	@Override
	public Country saveOrUpdateCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country getCountryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCountry(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	private List<Country> model2list(Model model) {
		StmtIterator result = model.listStatements();
		List<Country> listCountries = new ArrayList<>();
		String name = "";
		Integer population = 0;
		Integer sec = 0;
		Integer tou = 0;
		String timeZone = "";
		City capital = null;
		Integer area = 0;
		String currency = "";
		String flag = "";
		String language = "";
		String motto = "";
		String religion = "";
		int count = 0;
		while (result.hasNext()) {
			Statement st = result.next();
			Node predicate = st.asTriple().getPredicate();
			Node object = st.asTriple().getObject();
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_NAME)) 		{name=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_POPULATION)) {population=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_SECURITY_C)) {sec=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_TOURISM_C)) 	{tou=(Integer) object.getLiteralValue(); count++;}
			// if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_HAS_CAPITAL)){tou=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_AREA)) 		{area=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_CURRENCY)) 	{currency=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_FLAG)) 		{flag=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_LANGUAGE)) 	{language=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_MOTTO)) 		{motto=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_RELIGION)) 	{religion=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_TIME_ZONE)) 	{timeZone=(String) object.getLiteralValue(); count++;}
			if(count == 12) {
				listCountries.add(new Country(name,capital,area,currency,flag,language,motto,population,religion,timeZone,sec,tou));
				count = 0;
			}
		}
		return listCountries;
	}
	
	 

	

}









