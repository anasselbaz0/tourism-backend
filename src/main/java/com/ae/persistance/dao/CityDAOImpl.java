package com.ae.persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import com.ae.AppConf;
import com.ae.Tools;
import com.ae.persistance.entity.City;
import com.ae.persistance.repository.CityRepository;

public class CityDAOImpl implements CityDAO {

	CityRepository cityRepo; 
	
	@Override
	public List<City> getAllCities() {
		String queryS = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX tont: <http://localhost:80/tourism-ontology/1.0#> "
				//"SELECT ?name" +
				+ "CONSTRUCT {"
				+ "		?city tont:name ?name . "
				+ "		?city tont:population ?population . "
				+ "		?city tont:security_classification ?sec . "
				+ "		?city tont:tourism_classification ?tour . "
				+ "		?city tont:ZIP_code ?zip . "
				+ "		?city tont:web_site ?site . "
				+ "}"
				+ "WHERE { "
				+ "		?counrty tont:contains ?city . "
				+ "		?city tont:name ?name . "
				+ "		?city tont:population ?population . "
				+ "		?city tont:security_classification ?sec . "
				+ "		?city tont:tourism_classification ?tour . "
				+ "		?city tont:ZIP_code ?zip . "
				+ "		?city tont:web_site ?site . "
				+ "}";
		Model model = Tools.executeConstructQuery(queryS);
		//System.out.println());
		//ResultSet resultSet = Tools.executeSelectQuery(queryS);
		List<City> listCities = this.model2list(model);
//		for (City city : listCities) {
//			cityRepo.save(city);
//		}
		return listCities;
	}
	
	@Override
	public City saveOrUpdateCity(City scity) {
		City city = new City("a", 1,1,1,1,"d");
		Model model = Tools.getModel();
		Property p_name 		= model.getProperty(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_NAME);
		Property p_population 	= model.getProperty(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_POPULATION);
		Property p_sec 			= model.getProperty(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_SECURITY_C);
		Property p_tour 		= model.getProperty(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_TOURISM_C);
		Property p_zip 			= model.getProperty(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_ZIPCODE);
		Property p_site 		= model.getProperty(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_WEBSITE);
		String sURI = AppConf.URI_ONTOLOGY + city.getName(); 
		addStatement(sURI, p_name, city.getName());
		addStatement(sURI, p_population, String.valueOf(city.getPopulation()));
		addStatement(sURI, p_sec, String.valueOf(city.getSecurity_classification()));
		addStatement(sURI, p_tour, String.valueOf(city.getTourism_classification()));
		addStatement(sURI, p_zip, String.valueOf(city.getZip_code()));
		addStatement(sURI, p_site, city.getWeb_site());
		return city;
	}

	@Override
	public City getCityById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCity(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	private List<City> model2list(Model model) {
		StmtIterator result = model.listStatements();
		//StmtIterator result1 = resultSet.getResourceModel().listStatements();
		List<City> listCities = new ArrayList<>();
		String name = "";
		Integer population = 0;
		Integer sec = 0;
		Integer tou = 0;
		Integer zip = 0;
		String site = "";
		int count = 0;
		while (result.hasNext()) {
			Statement st = result.next();
			Node predicate = st.asTriple().getPredicate();
			//Node subject = st.asTriple().getSubject();
			Node object = st.asTriple().getObject();
			//System.out.println("---->>  " + predicate.toString() + "  " + object.toString());	
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_NAME)) 		{name=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_POPULATION)) {population=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_SECURITY_C)) {sec=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_TOURISM_C)) 	{tou=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_WEBSITE)) 	{site=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_ZIPCODE)) 	{zip=(Integer) object.getLiteralValue(); count++;}
			if(count == 6) { // the 6 args in City class are all not empty
				listCities.add(new City(name,population,sec,tou,zip,site));
				count = 0;
			}
		}
		return listCities;
	}
	
	 private void addStatement(String s, Property p, String o){
		 Model model = Tools.getModel();
		 Resource subject = model.createResource(s);
		 RDFNode object = model.createResource(o);
		 Statement stmt = model.createStatement(subject, p, object);
		 model.add(stmt);
	}

}
