package com.ae;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class Tools {

	public static ResultSet executeSelectQuery(String queryS) {
		Model model = getModel();
		Query query = QueryFactory.create(queryS);
		QueryExecution qexe = QueryExecutionFactory.create(query, model);
		ResultSet result = qexe.execSelect();
		return result;	
	}
	
	public static Model executeConstructQuery(String queryS) {
		Model model = getModel();
		Query query = QueryFactory.create(queryS);
		QueryExecution qexe = QueryExecutionFactory.create(query, model);
		Model constructModel = qexe.execConstruct();
		return constructModel;	
	}
	
	public static Model getModel() {
		FileManager.get().addLocatorClassLoader(TourismServerApplication.class.getClassLoader());
		Model model = FileManager.get().loadModel(AppConf.PATH_ONTOLOGY);
		return model;
	}
	

	
}
