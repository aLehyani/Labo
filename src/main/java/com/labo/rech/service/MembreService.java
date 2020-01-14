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
import com.labo.rech.dao.PublicationRepository;

import com.labo.rech.entity.EnseignantChercheur;
import com.labo.rech.entity.Etudiant;
import com.labo.rech.entity.Membre;
import com.labo.rech.entity.Publication;
import com.labo.rech.exception.RecordNotFoundException;


 
@Service
public class MembreService {
     
	@Autowired
	MembreRepository membreRepository;
	
	@Autowired
	PublicationRepository publicationRepository;
	
	public List<Membre> getMembres(){
	    return membreRepository.findAll();
	}
	
	public Optional<Membre> getMembreById(Long id) {
		return membreRepository.findById(id);
	}
	
	public Membre addMembre(Membre m) {
		return membreRepository.save(m);
	}
	 
	public void updateMembre(Membre m) {
		membreRepository.save(m);
		System.out.println( "Member updated");
	}
	
	public List<Publication> getPublicationsByMemberId(Long id) {
		return membreRepository.getPublicationsByMembreId(id);
	}
	 
	public void deleteMembre(Long id) {
		membreRepository.deleteById(id);
	}
	
	public Membre login(String email, String password) {
		return membreRepository.login(email, password);
	}
	
}
