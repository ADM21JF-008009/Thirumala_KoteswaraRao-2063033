package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	public static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		
		 testGetAllCountries();
		 testFindCountryByCode();
		 testAddCountry();
		 testUpdateCountry();
		 testDeleteCountry();
		 
		
		 LOGGER.info("Inside main");
	}

	private static void testGetAllCountries() throws CountryNotFoundException {

		LOGGER.info("Start");
		Country country;
		country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");

	}

	private static void testFindCountryByCode() throws CountryNotFoundException {
		
			Country country = countryService.findCountryByCode("GB");
			System.out.println(country.getName());
		
	}

	public static void testAddCountry() throws CountryNotFoundException {
		Country newCountry = new Country();
		newCountry.setCode("NM");
		newCountry.setName("Nik");
		countryService.addCountry(newCountry);
		System.out.println("Coūntry Added");
		testFindCountryByCode();

	}

	private static void testUpdateCountry() throws CountryNotFoundException {
		countryService.updateCountry("KM", "Megh");
	}

	private static void testDeleteCountry() {
		countryService.deleteCountry("TD");
		System.out.println("Country Deleted- TD");
	}

	
}
