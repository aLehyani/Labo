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

import com.labo.rech.dao.PublicationRepository;
import com.labo.rech.entity.EnseignantChercheur;
import com.labo.rech.entity.Etudiant;
import com.labo.rech.entity.Publication;
import com.labo.rech.exception.RecordNotFoundException;

@Service
public class PublicationService {

	@Autowired
	PublicationRepository publicationRepository;

	public List<Publication> getPublications() {
		return publicationRepository.findAll();
	}

	public Publication getPublicationById(Integer id) {
		return publicationRepository.getOne(id);
	}
	
	public Publication addPublication(Publication m) {
		return publicationRepository.save(m);
	}

	public void deletePublication(Integer id) {
		publicationRepository.deleteById(id);
	}

}
