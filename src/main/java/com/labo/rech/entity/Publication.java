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
	public class Publication implements Serializable{
	 
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)

		private Integer Id;
		private String type;
		private String lien;
		
	    @Temporal(TemporalType.TIMESTAMP)
		private Date date;
		private String Sourcepdf;
		
		@ManyToMany(fetch=FetchType.EAGER) 
		 private Collection<Membre> membres;
		
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getLien() {
			return lien;
		}
		public void setLien(String lien) {
			this.lien = lien;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getSourcepdf() {
			return Sourcepdf;
		}
		public void setSourcepdf(String sourcepdf) {
			Sourcepdf = sourcepdf;
		}
	
	}
	

