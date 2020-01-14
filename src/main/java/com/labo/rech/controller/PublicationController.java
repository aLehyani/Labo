package com.labo.rech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.labo.rech.dao.EtudiantRepository;
import com.labo.rech.dao.PublicationRepository;
import com.labo.rech.entity.EnseignantChercheur;
import com.labo.rech.entity.Publication;
import com.labo.rech.service.MembreService;
import com.labo.rech.service.PublicationService;

import javax.validation.Valid;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.labo.rech.exception.RecordNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PublicationController {

	@Autowired
	private PublicationService publicationService;
	
	@Autowired
	private MembreService membreService;

	@GetMapping("/Publications")
	public List<Publication> getPublications(@RequestParam(required = false) Long memberId) {
		System.out.println(memberId);
		if(memberId != null) {
			System.out.println("toutou mouah" + memberId);
			return membreService.getPublicationsByMemberId(memberId);
		}
		return publicationService.getPublications();
	}

	@GetMapping("/Publications/{id}")
	public ResponseEntity<Publication> getPublicationById(@PathVariable(value = "id") Integer PublicationId) {
		Publication Publication = publicationService.getPublicationById(PublicationId);
		return ResponseEntity.ok().body(Publication);
	}

	@PostMapping("/Publication")
	public Publication addPublication(@Valid @RequestBody Publication Publication) {
		return publicationService.addPublication(Publication);
	}

	/*
	 * @PutMapping("/Publications/{id}") public ResponseEntity<Publication>
	 * updatePublication(@PathVariable(value = "id") Integer PublicationId,
	 * 
	 * @Valid @RequestBody Publication Publicationdetails) { Publication Publication =
	 * PublicationService.getPublicationById(PublicationId) .orElseThrow();
	 * 
	 * Publication.setNom(Publicationdetails.getNom());
	 * Publication.setPrenom(Publicationdetails.getPrenom());
	 * 
	 * final Publication updatedPublication = PublicationService.addPublication(Publication); return
	 * ResponseEntity.ok(updatedPublication); }
	 */
	/*
	 * @DeleteMapping("/Publications/{id}") public void deletePublicationById(Integer id)
	 * throws RecordNotFoundException { Optional<Publication> Publication =
	 * PublicationService.getPublicationById(id);
	 * 
	 * if(Publication.isPresent()) { PublicationService.deletePublication(id);; } else { throw new
	 * RecordNotFoundException("No Publication record exist for given id"); } }
	 */
	@PutMapping("/Publication/{id}")
	public ResponseEntity<Publication> updatePublication(@PathVariable(value = "id") Integer PublicationId,
			@Valid @RequestBody Publication PublicationDetails) throws RecordNotFoundException {
		Publication Publication = publicationService.getPublicationById(PublicationId);

		Publication.setType(PublicationDetails.getType());
		Publication.setLien(PublicationDetails.getLien());
		final Publication updatedPublication = publicationService.addPublication(Publication);
		return ResponseEntity.ok(updatedPublication);
	}

	@DeleteMapping("/Publication/{id}")
	public Map<String, Boolean> deletePublication(@PathVariable(value = "id") Integer PublicationId)
			throws RecordNotFoundException {
		Publication Publication = publicationService.getPublicationById(PublicationId);

		publicationService.deletePublication(PublicationId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}