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
import com.labo.rech.dao.EtudiantRepository;
import com.labo.rech.dao.PublicationRepository;

import com.labo.rech.entity.Etudiant;
import com.labo.rech.entity.Etudiant;
import com.labo.rech.entity.Membre;
import com.labo.rech.entity.Publication;
import com.labo.rech.exception.RecordNotFoundException;


 
@Service
public class EtudiantService {
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	PublicationRepository publicationRepository;
	
	public List<Etudiant> getEtudiant(){
	    return etudiantRepository.findAll();
	}
	
	public Optional<Etudiant> getEtudiantById(Long id) {
		return etudiantRepository.findById(id);
	}
	 
	public Etudiant addEtudiant(Etudiant m) {
		return etudiantRepository.save(m);
	}
	 
	 
	public void updateEtudiant(Etudiant m) {
		etudiantRepository.save(m);
		System.out.println( "Etudiant updated");
	}
	 
	 
	public void deleteEtudiant(Long id) {
		etudiantRepository.deleteById(id);
	}
	
}
