package com.labo.rech.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labo.rech.dao.MembreRepository;
import com.labo.rech.entity.Membre;
import com.labo.rech.exception.RecordNotFoundException;


 
@Service
public class LaboratoireService {
     
    @Autowired
    MembreRepository memrepository;
     
    public List<Membre> getAllEmployees()
    {
        List<Membre> membreList = memrepository.findAll();
         
        if(membreList.size() > 0) {
            return membreList;
        } else {
            return new ArrayList<Membre>();
        }
    }
     
   
    public Membre createOrUpdateEmployee(Membre mem) throws RecordNotFoundException
    {
        Optional<Membre> membre = memrepository.findById(mem.getId());
         
        if(membre.isPresent())
        {
           Membre newMembre = membre.get();
           newMembre.setNom(mem.getNom());
           newMembre.setPrenom(mem.getPrenom());
           newMembre.setEmail(mem.getEmail());

            newMembre = memrepository.save(newMembre);
             
            return newMembre;
        } else {
            mem = memrepository.save(mem);
             
            return mem;
        }
    }
     
    public void deleteMembreById(Long id) throws RecordNotFoundException
    {
        Optional<Membre> membre = memrepository.findById(id);
         
        if(membre.isPresent())
        {
            memrepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Member record exist for given id");
        }
    }
}
