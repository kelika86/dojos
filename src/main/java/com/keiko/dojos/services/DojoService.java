package com.keiko.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keiko.dojos.models.Dojo;
import com.keiko.dojos.repositories.DojoRepo;

@Service
public class DojoService { //injections
	private final DojoRepo dr;
	
	public DojoService(DojoRepo dr) {
		this.dr=dr;
	}
	
	public Dojo createDojo(Dojo dojo) { //Dojo is the model
		return dr.save(dojo); //coming from crud repo
	}
	
	public Dojo findDojo(Long dojoId) {
		Optional <Dojo> optionalDojo=dr.findById(dojoId);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}

	public List<Dojo> findAllDojos() {
		return dr.findAll();
	}
}
