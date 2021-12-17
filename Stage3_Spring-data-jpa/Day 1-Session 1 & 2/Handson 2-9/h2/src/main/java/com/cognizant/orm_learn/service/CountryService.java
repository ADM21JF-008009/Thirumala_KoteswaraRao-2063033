package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	
	@Autowired
	CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}
	
	@Transactional
	public Country  findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		try {
			if (!result.isPresent()) {
				throw new CountryNotFoundException("Country Not found");
			}
		} catch(CountryNotFoundException e){
			e.getMessage();
		}
		Country country = result.get();
		return country;
	}
	
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	
	@Transactional
	public void updateCountry(String countryCode, String countryName) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if(result.isPresent()) {
			Country country=result.get();
			country.setName(countryName);
			countryRepository.save(country);
		}else {
			throw new CountryNotFoundException("Country Not Found");
		}
		
	}
	
	@Transactional
	public void deleteCountry(String id) {
		countryRepository.deleteById(id);
	}
	
	


}
