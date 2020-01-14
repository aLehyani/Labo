package com.labo.rech.entity;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Role implements Serializable {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Role_Id")
	private Long id;	
	private String Role;

	
}
