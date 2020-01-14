package com.labo.rech.entity;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evenement implements Serializable{
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long Id;
	
    @Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
    private String Lieu;
	
	
	@ManyToMany(fetch=FetchType.LAZY) 
	  private Collection<Membre> membres;
	 
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLieu() {
		return Lieu;
	}
	public void setLieu(String lieu) {
		Lieu = lieu;
	}
	
}
