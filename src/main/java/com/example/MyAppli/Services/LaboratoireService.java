package com.example.MyAppli.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MyAppli.Entities.Laboratoire;
import com.example.MyAppli.Repository.laboratoireRepository;

@Service
public class LaboratoireService {
	
	@Autowired
	  private laboratoireRepository laboratoireRepository;
	
	//Lister les laboratoires
	@Transactional
	    public List<Laboratoire> GetAllLaboratoires()
           {  return laboratoireRepository.findAll(); }
	
	
	   public Laboratoire FindByIdLaboratoire(Long id) 
           {  return laboratoireRepository.findById(id).get(); }
	
	
	//Ajouter un laboratoire
		public Laboratoire saveLaboratoire (Laboratoire laboratoire)
	       { return laboratoireRepository.save(laboratoire); }
		
	//Supprimer laboratoire
		public void DeleteLaboratoireById (Long id) 
		 {Laboratoire laboratoire= laboratoireRepository.getOne(id);
		        laboratoireRepository.delete(laboratoire);}
	
	
	
	
	
	

}
