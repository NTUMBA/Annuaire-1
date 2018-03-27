package com.formation.annuaire1.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.annuaire1.Repositories.CarnetRepository;

@Service
public class CarnetService {
	@Autowired
	CarnetRepository carnetRepository;// Equivaut a taper private CarnetRepository carnetRepository = new CarnetRepository();
	
	
	public void getAll(){
		carnetRepository.findAll();// Trouve une liste de carnet 
	}
}
