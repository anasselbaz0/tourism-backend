package com.ae.persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import com.ae.AppConf;
import com.ae.Tools;
import com.ae.persistance.entity.City;
import com.ae.persistance.entity.Country;

public class CountryDAOImpl implements CountryDAO {

	@Override
	public List<Country> getAllCountries() {
		System.out.println(3);
		String queryS = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"PREFIX tont: <http://localhost:80/tourism-ontology/1.0#> \n" + 
				"CONSTRUCT {\n" + 
				"		?country tont:name ?name . \n" + 
				"		?country tont:hasCapital ?capital . \n" + 
				"		?country tont:security_classification ?sec . \n" + 
				"		?country tont:tourism_classification ?tour . \n" + 
				"		?country tont:area ?area . \n" + 
				"		?country tont:currency ?currency . \n" + 
				"		?country tont:flag ?flag . \n" + 
				"		?country tont:language ?language . \n" + 
				"		?country tont:population ?population . \n" + 
				"		?country tont:motto ?motto . \n" + 
				"		?country tont:religion ?religion . \n" + 
				"		?country tont:time_zone ?timeZone . \n" + 
				"}\n" + 
				"WHERE { \n" + 
				"		?country tont:name ?name . \n" + 
				"		?country tont:hasCapital ?capital . \n" + 
				"		?country tont:security_classification ?sec . \n" + 
				"		?country tont:tourism_classification ?tour . \n" + 
				"		?country tont:area ?area . \n" + 
				"		?country tont:currency ?currency . \n" + 
				"		?country tont:flag ?flag . \n" + 
				"		?country tont:language ?language . \n" + 
				"		?country tont:population ?population . \n" + 
				"		?country tont:motto ?motto . \n" + 
				"		?country tont:religion ?religion . \n" + 
				"		?country tont:time_zone ?timeZone . \n" + 
				"}";
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
			System.out.println("---->>  " + predicate.toString() + "  " + object.toString());	
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
			if(count == 11) {
				listCountries.add(new Country(name,capital,area,currency,flag,language,motto,population,religion,timeZone,sec,tou));
				count = 0;
			}
		}
		return listCountries;
	}
	
	 

	

}









