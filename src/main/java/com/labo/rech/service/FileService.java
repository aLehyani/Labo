package com.labo.rech.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.labo.rech.dao.FileRepository;
import com.labo.rech.entity.File;

@Service
public class FileService {
	

	    @Autowired
	    private FileRepository fileRepository;

	    public File storeFile(MultipartFile file) {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            
	            File File = new File(fileName, file.getContentType(), file.getBytes());

	            return fileRepository.save(File);
	        } catch (IOException ex) {
	        	System.out.println("Oops ! Store file failed");
	        }
			return null;
	    }

	    public File getFile(String fileId) {
	        return fileRepository.getOne(fileId);
	              
	    }
	}

