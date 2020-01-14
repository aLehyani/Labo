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
import com.labo.rech.dao.MembreRepository;
import com.labo.rech.entity.EnseignantChercheur;
import com.labo.rech.entity.Membre;
import com.labo.rech.service.MembreService;

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
public class MembreController {

	@Autowired
	private MembreService membreService;

	@GetMapping("/Membres")
	public List<Membre> getMembres() {
		return membreService.getMembres();
	}

	@GetMapping("/Membres/{id}")
	public ResponseEntity<Optional<Membre>> getMembreById(@PathVariable(value = "id") Long MembreId) {
		Optional<Membre> Membre = membreService.getMembreById(MembreId);
		return ResponseEntity.ok().body(Membre);
	}

	@PostMapping("/Membre")
	public Membre addMembre(@Valid @RequestBody Membre Membre) {
		return membreService.addMembre(Membre);
	}
	
	@GetMapping("/login")
	public Membre Login(@Valid @ RequestBody String email, String password) {
		return membreService.login(email, password);
	}

	/*
	 * @PutMapping("/Membres/{id}") public ResponseEntity<Membre>
	 * updateMembre(@PathVariable(value = "id") Integer MembreId,
	 * 
	 * @Valid @RequestBody Membre Membredetails) { Membre Membre =
	 * membreService.getMembreById(MembreId) .orElseThrow();
	 * 
	 * Membre.setNom(Membredetails.getNom());
	 * Membre.setPrenom(Membredetails.getPrenom());
	 * 
	 * final Membre updatedMembre = membreService.addMembre(Membre); return
	 * ResponseEntity.ok(updatedMembre); }
	 */
	/*
	 * @DeleteMapping("/Membres/{id}") public void deleteMembreById(Integer id)
	 * throws RecordNotFoundException { Optional<Membre> Membre =
	 * membreService.getMembreById(id);
	 * 
	 * if(Membre.isPresent()) { membreService.deleteMembre(id);; } else { throw new
	 * RecordNotFoundException("No Membre record exist for given id"); } }
	 */
	@PutMapping("/Membre/{id}")
	public void updateMembre(@PathVariable(value = "id") Long id ,@Valid @RequestBody Membre membre) throws RecordNotFoundException {
		membre.setId(id);
		membreService.updateMembre(membre);
		
	}

	@DeleteMapping("/Membres/{id}")
	public Map<String, Boolean> deleteMembre(@PathVariable(value = "id") Long MembreId)
			throws RecordNotFoundException {
		Optional<Membre> Membre = membreService.getMembreById(MembreId);

		membreService.deleteMembre(MembreId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}