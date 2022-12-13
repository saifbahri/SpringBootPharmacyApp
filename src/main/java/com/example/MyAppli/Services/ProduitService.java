package com.example.MyAppli.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MyAppli.Entities.Produit;
import com.example.MyAppli.Repository.produitRepository;

@Service
public class ProduitService {

	@Autowired
	private produitRepository produitRepository;
	
//Lister les produits
	
	public List<Produit> GetAllProduits()
       {  return produitRepository.findAll(); }
	
//ConsulterFicheProduit
	public Produit FindByIdProduit(Long id) 
       {  return produitRepository.findById(id).get(); }
	
	
//Ajouter un produit
	public Produit saveProduit (Produit produit)
       { return produitRepository.save(produit); }
	
	
	public List<Produit>FindAllByDep(Long id){
		return produitRepository.FindprodBymarque(id);
	}
	
   }
