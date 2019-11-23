package com.ae;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConf implements WebMvcConfigurer {

//	Environment
	public static String PATH_ONTOLOGY = "./static/ontology/ont.owl";
	public static String URI_ONTOLOGY = "http://localhost:80/tourism-ontology/1.0#";
	
//	Properties
	public static String PROPRETY_NAME = "name";
	public static String PROPRETY_POPULATION = "population";
	public static String PROPRETY_SECURITY_C = "security_classification";
	public static String PROPRETY_TOURISM_C = "tourism_classification";
	public static String PROPRETY_ZIPCODE = "ZIP_code";
	public static String PROPRETY_WEBSITE = "web_site";
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET");
    }
}
