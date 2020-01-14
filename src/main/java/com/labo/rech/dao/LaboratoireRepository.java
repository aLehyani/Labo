package com.labo.rech.dao;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.labo.rech.entity.Laboratoire;

	@Repository
	public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {

}
