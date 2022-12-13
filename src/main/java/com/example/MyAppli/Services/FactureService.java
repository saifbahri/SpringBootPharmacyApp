package com.example.MyAppli.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyAppli.Entities.Facture;
import com.example.MyAppli.Repository.factureRepository;

@Service
public class FactureService {


	@Autowired
	private factureRepository  factureRepository;	
	
	
	
	@Transactional
	public List <Facture> GetAllFactures(){
		return factureRepository.findAll();
	}
	
	
	public  Facture FindByIdFacture(long id) {
		return factureRepository.findById(id).get();
	}
	
	public Facture SaveFacture( Facture facture)
	{
		return factureRepository.save(facture);
	}
	
	public void DeleteFactureById (Long id) 
	 {Facture facture= factureRepository.getOne(id);
	        factureRepository.delete(facture);}
}
