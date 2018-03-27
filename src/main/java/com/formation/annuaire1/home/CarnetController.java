package com.formation.annuaire1.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.annuaire1.Services.CarnetService;
import com.formation.annuaire1.canet.Carnet;

@RestController
public class CarnetController {

	// On fait appel au service
	@Autowired
	private CarnetService carnetService;

	// public CarnetController()
	@RequestMapping("/carnets")
	public List<Carnet> getAllCarnet() {

		return carnetService.getAllCarnet();
	}
}