package com.labo.rech.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.labo.rech.entity.Membre;
import com.labo.rech.entity.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
 //public List<Publication> findBydate() ;
	//List<Publication> findByMembres_Id(Integer id);
	@Query("SELECT m.publications from Membre m WHERE id = :id ")
	List<Publication> findAllByMembreId(@Param("id")Integer id);

 }



