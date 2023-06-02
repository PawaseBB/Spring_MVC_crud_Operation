package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.CityDao;
import com.jsp.dto.City;

@Component
public class CityService {

	@Autowired
	CityDao cityDao;

	// Save City
	public City saveCity(City city) {
		return cityDao.saveCity(city);
	}

	// Get All Cities
	public List<City> getAllCities() {
		return cityDao.getAllCities();
	}

	// Delete City
	public void deleteCity(int id) {
		cityDao.deleteCity(id);
	}

	// Update City
	public City updateCity(City city, int id) {
		City city2 = cityDao.getByIdCity(id);

		if (city.getFood() != null) {
			city2.setFood(city.getFood());
		}
		if (city.getName() != null) {
			city2.setName(city.getName());
		}

		if (city2 != null) {
			return cityDao.updateCity(city2);
		} else
			return null;
	}

}
