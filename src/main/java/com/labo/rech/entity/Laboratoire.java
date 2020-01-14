package com.labo.rech.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Laboratoire implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String nom;
	private String Code;
	private String Etablissement;
	private String Universite;
	
	@OneToMany(mappedBy = "laboratoire" , fetch=FetchType.LAZY)
	private Collection<Membre> membres;}
