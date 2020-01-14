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
import com.labo.rech.service.EnseignantChercheurService;

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
public class EnsCherController {

	@Autowired
	private EnseignantChercheurService ensCherService;

	@GetMapping("/ens_cher")
	public List<EnseignantChercheur> getEnsCher() {
		return ensCherService.getEnsCher();
	}

	@GetMapping("/ens_cher/{id}")
	public ResponseEntity<Optional<EnseignantChercheur>> getEnsCherById(@PathVariable(value = "id") Long id) {
		Optional<EnseignantChercheur> EnseignantChercheur = ensCherService.getEnsCherById(id);
		return ResponseEntity.ok().body(EnseignantChercheur);
	}

	@PostMapping("/ens_cher")
	public Membre addEnsCher(@Valid @RequestBody EnseignantChercheur m) {
		return ensCherService.addEnsCher(m);
	}

	/*
	 * @PutMapping("/ens_cher/{id}") public ResponseEntity<Membre>
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
	
	@PutMapping("/ens_cher/{id}")
	public void updateMembre(@PathVariable(value = "id") Long id ,@Valid @RequestBody EnseignantChercheur e) throws RecordNotFoundException {
		e.setId(id);
		ensCherService.updateEnsCher(e);
	}

	@DeleteMapping("/ens_cher/{id}")
	public Map<String, Boolean> deleteMembre(@PathVariable(value = "id") Long MembreId)
			throws RecordNotFoundException {
		Optional<EnseignantChercheur> Membre = ensCherService.getEnsCherById(MembreId);

		ensCherService.deleteEnsCher(MembreId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}