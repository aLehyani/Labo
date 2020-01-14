package com.labo.rech.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("et")

public class Etudiant  extends Membre{
	private Date dateInscription;
	private String Diplome;
	
	@ManyToOne(cascade=CascadeType.ALL )
	private EnseignantChercheur enseignant;
	
    @Temporal(TemporalType.TIMESTAMP)
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	
	public String getDiplome() {
		return Diplome;
	}
	
	public Etudiant() {
		super();
	}
	public Etudiant(Date dateInscription, String diplome, EnseignantChercheur enseignant) {
		super();
		this.dateInscription = dateInscription;
		Diplome = diplome;
		this.enseignant = enseignant;
	}
	public void setDiplome(String diplome) {
		Diplome = diplome;
	}
}
