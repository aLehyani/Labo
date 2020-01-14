package com.labo.rech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labo.rech.entity.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {


 }
