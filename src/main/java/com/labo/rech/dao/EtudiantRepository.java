package com.labo.rech.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labo.rech.entity.Etudiant;

@Transactional
public interface EtudiantRepository extends MembreBaseRepository<Etudiant> { }

 
