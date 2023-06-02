package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.City;

@Component
public class CityDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	// Save City
	public City saveCity(City city) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		if (city != null) {
			entityTransaction.begin();
			entityManager.persist(city);
			entityTransaction.commit();
			return city;
		} else
			return null;
	}

	// Get All Records
	public List<City> getAllCities() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "select c from City c";
		Query query = entityManager.createQuery(sql);
		List<City> cities = query.getResultList();
		return cities;
	}

	// Get By Id Record
	public City getByIdCity(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager.find(City.class, id);
	}

	// Delete Record
	public void deleteCity(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		City city = entityManager.find(City.class, id);
		if (city != null) {
			entityTransaction.begin();
			entityManager.remove(city);
			entityTransaction.commit();
		}
	}

	// Update Record
	public City updateCity(City city) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		if (city != null) {
			entityTransaction.begin();
			entityManager.merge(city);
			entityTransaction.commit();
			return city;
		} else
			return null;

	}

}
