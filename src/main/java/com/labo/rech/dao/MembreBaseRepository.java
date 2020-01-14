package com.labo.rech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.labo.rech.entity.Membre;

@NoRepositoryBean
public interface MembreBaseRepository<T extends Membre> 
extends JpaRepository<T, Long> {

  /**
   * Method findByEmail
   * 
   * @param email the user email.
   * @return the user having the passed email or null if no user is found.
   */
  //public T findByEmail(String email);
}
