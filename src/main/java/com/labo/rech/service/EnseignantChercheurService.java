package com.labo.rech.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.labo.rech.dao.MembreRepository;
import com.labo.rech.dao.EnsCherRepository;
import com.labo.rech.dao.PublicationRepository;

import com.labo.rech.entity.EnseignantChercheur;
import com.labo.rech.entity.Etudiant;
import com.labo.rech.entity.Membre;
import com.labo.rech.entity.Publication;
import com.labo.rech.exception.RecordNotFoundException;


 
@Service
public class EnseignantChercheurService {
	
	@Autowired
	EnsCherRepository EnsCherRepository;
	
	@Autowired
	PublicationRepository publicationRepository;
	
	public List<EnseignantChercheur> getEnsCher(){
	    return EnsCherRepository.findAll();
	}
	
	public Optional<EnseignantChercheur> getEnsCherById(Long id) {
		return EnsCherRepository.findById(id);
	}
	 
	public EnseignantChercheur addEnsCher(EnseignantChercheur m) {
		return EnsCherRepository.save(m);
	}
	 
	 
	public void updateEnsCher(EnseignantChercheur m) {
		EnsCherRepository.save(m);
		System.out.println( "EnseignantChercheur updated");
	}
	 
	 
	public void deleteEnsCher(Long id) {
		EnsCherRepository.deleteById(id);
	}
	
}
