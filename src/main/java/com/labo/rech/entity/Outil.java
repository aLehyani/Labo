package com.labo.rech.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Outil implements Serializable{
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long Id;
	
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
	private String Source;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private Set <Membre> membres;
	
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
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
}

