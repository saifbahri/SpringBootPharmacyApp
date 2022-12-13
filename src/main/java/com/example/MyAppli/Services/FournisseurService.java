package com.example.MyAppli.Services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.MyAppli.Entities.Fournisseur;
import com.example.MyAppli.Repository.fournisseurRepository;

@Service
public class FournisseurService {

	
	@Autowired
	private fournisseurRepository  fournisseurRepository;	
	
	
	
	@Transactional
	public List <Fournisseur> GetAllFournisserus(){
		return fournisseurRepository.findAll();
	}
	
	
	public  Fournisseur FindByIdFournisseur(long id) {
		return fournisseurRepository.findById(id).get();
	}
	
	public Fournisseur SaveFournisseur( Fournisseur fournisseur)
	{
		return fournisseurRepository.save(fournisseur);
	}
	
	public void DeleteFournisseurById (Long id) 
	 {Fournisseur fournisseur= fournisseurRepository.getOne(id);
	        fournisseurRepository.delete(fournisseur);}
	
	
	
	
}
