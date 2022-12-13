package com.example.MyAppli.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyAppli.Entities.Produit;
import com.example.MyAppli.Services.ProduitService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Produits")

public class ProduitController {

	@Autowired
	private ProduitService produitService;
	
	@GetMapping("/GetAllProduits")
	   public List<Produit>FindAllProduit()
	       { return produitService.GetAllProduits(); }
	
	@GetMapping("/GetProduitById/{id}")
    public Produit GetProduitById (@PathVariable Long id)
           { return produitService.FindByIdProduit(id); }
	
	@PostMapping("/AddProduit")
    public Produit AddProduit (@Validated @RequestBody Produit produit)
           { produitService.saveProduit(produit);
	           return produit;}
	
	
	@PutMapping("/updateProduit/{id}")
	  public ResponseEntity <?> updateProduit(@PathVariable Long id, @RequestBody Produit produit){
		
		Produit produitExist=produitService.FindByIdProduit(id);
		System.out.println(produitExist.getId_prd());
		
		produitExist.setLib_prd(produit.getLib_prd());
		produitExist.setDescription_prd(produit.getDescription_prd());
		produitExist.setPrix_prd(produit.getPrix_livr());
		produitExist.setPrix_livr(produit.getPrix_livr());
		produitExist.setDateAjout_prd(produit.getDateAjout_prd());

		
		Produit savedProduit=produitService.saveProduit(produitExist);
		return ResponseEntity.ok().body(savedProduit);
		}
	
	@GetMapping("GetprodBydep/{id}")
	public List <Produit> getEnsByDep(@PathVariable Long id){
		return produitService.FindAllByDep(id);
	}
	
	
	
	
}
