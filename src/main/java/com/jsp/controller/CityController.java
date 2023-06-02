package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.City;
import com.jsp.service.CityService;

@Controller
public class CityController {

	@Autowired
	CityService cityService;

	@RequestMapping("/saveCity")
	public ModelAndView clickMe() {

		ModelAndView modelAndView = new ModelAndView("createcity.jsp");
		modelAndView.addObject("city1", new City());
		return modelAndView;
	}

	@RequestMapping("/citySave")
	public ModelAndView saveCity(@ModelAttribute City city) {

		if (city != null) {
			cityService.saveCity(city);
		}
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		modelAndView.addObject("save", city.getName() + " Added Successfully");
		return modelAndView;
	}

	@RequestMapping("/viewAllCity")
	public ModelAndView getAllCity() {

		List<City> cities = cityService.getAllCities();
		ModelAndView modelAndView = new ModelAndView("viewAllCity.jsp");
		modelAndView.addObject("cities", cities);
		return modelAndView;

	}

	@RequestMapping("/delete")
	public ModelAndView deleteCity(@RequestParam(name = "id") int id) {
		cityService.deleteCity(id);
		ModelAndView modelAndView = new ModelAndView("deleteCity.jsp");
		modelAndView.addObject("deleted", "Student with " + id + " Deleted.");
		return modelAndView;
	}

	@RequestMapping("/update")
	public ModelAndView updateById(@RequestParam(name = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("updateCity.jsp");
		modelAndView.addObject("city2", new City());
		return modelAndView;
	}

	@RequestMapping("/cityUpdated")
	public ModelAndView updatedFinally(@ModelAttribute City city) {
		cityService.updateCity(city, city.getId());
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		modelAndView.addObject("updated", "student " + city.getId() + " updated");
		return modelAndView;
	}

}
