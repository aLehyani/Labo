package com.labo.rech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labo.rech.entity.Outil;

@Repository
public interface OutilRepository extends JpaRepository<Outil, Long> {

}
