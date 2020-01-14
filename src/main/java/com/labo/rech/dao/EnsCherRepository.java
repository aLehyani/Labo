package com.labo.rech.dao;

import javax.transaction.Transactional;

import com.labo.rech.entity.EnseignantChercheur;


@Transactional
public interface EnsCherRepository extends MembreBaseRepository<EnseignantChercheur> {
	
}

