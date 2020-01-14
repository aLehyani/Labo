package com.labo.rech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labo.rech.entity.File;

public interface FileRepository extends JpaRepository<File, String>  {

}
