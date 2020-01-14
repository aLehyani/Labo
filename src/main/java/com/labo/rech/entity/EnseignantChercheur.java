package com.labo.rech.entity;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ec")
public class EnseignantChercheur extends Membre {

private String Grade;
private String Etablissement;

@OneToMany(mappedBy="enseignant",fetch=FetchType.LAZY)
private  Collection <Etudiant> etudiants;

public String getGrade() {
	return Grade;
}
public void setGrade(String grade) {
	Grade = grade;
}
public String getEtablissement() {
	return Etablissement;
}
public void setEtablissement(String etablissement) {
	Etablissement = etablissement;
}

}
