package com.formation.annuaire1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.annuaire1.Repositories.CarnetRepository;
import com.formation.annuaire1.canet.Carnet;

@Service
public class CarnetService {
	@Autowired
	CarnetRepository carnetRepository;// Equivaut a taper private CarnetRepository carnetRepository = new CarnetRepository();
	
	
	public List<Carnet> getAllCarnet(){
		
		return carnetRepository.findAll();// Trouve une liste de carnet 
	}
}
