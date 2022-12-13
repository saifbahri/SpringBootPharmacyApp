package com.example.MyAppli.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyAppli.Entities.Categorie;
import com.example.MyAppli.Repository.categorieRepository;

@Service
public class CategorieService {

	
	

	@Autowired
	private categorieRepository  categorieRepository;	
	
	
	
	@Transactional
	public List <Categorie> GetAllCategories(){
		return categorieRepository.findAll();
	}
	
	
	public  Categorie FindByIdCategorie(long id) {
		return categorieRepository.findById(id).get();
	}
	
	public Categorie SaveCategorie( Categorie categorie)
	{
		return categorieRepository.save(categorie);
	}
	
	public void DeleteCategorieById (Long id) 
	 {Categorie categorie= categorieRepository.getOne(id);
	        categorieRepository.delete(categorie);}
}
