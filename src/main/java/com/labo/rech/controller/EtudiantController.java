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
import com.labo.rech.entity.Etudiant;
import com.labo.rech.entity.Membre;
import com.labo.rech.service.EtudiantService;

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
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;

	@GetMapping("/etudiant")
	public List<Etudiant> getEtudiant() {
		return etudiantService.getEtudiant();
	}

	@GetMapping("/etudiant/{id}")
	public ResponseEntity<Optional<Etudiant>> getEtudiantById(@PathVariable(value = "id") Long id) {
		Optional<Etudiant> Etudiant = etudiantService.getEtudiantById(id);
		return ResponseEntity.ok().body(Etudiant);
	}

	@PostMapping("/etudiant")
	public Membre addEtudiant(@Valid @RequestBody Etudiant m) {
		return etudiantService.addEtudiant(m);
	}

	/*
	 * @PutMapping("/etudiant/{id}") public ResponseEntity<Membre>
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
	
	@PutMapping("/etudiant/{id}")
	public void updateMembre(@PathVariable(value = "id") Long id ,@Valid @RequestBody Etudiant e) throws RecordNotFoundException {
		e.setId(id);
		etudiantService.updateEtudiant(e);
	}

	@DeleteMapping("/etudiant/{id}")
	public Map<String, Boolean> deleteMembre(@PathVariable(value = "id") Long MembreId)
			throws RecordNotFoundException {
		Optional<Etudiant> Membre = etudiantService.getEtudiantById(MembreId);

		etudiantService.deleteEtudiant(MembreId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}