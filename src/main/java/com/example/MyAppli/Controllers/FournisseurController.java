package com.example.MyAppli.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.MyAppli.Entities.Fournisseur;
import com.example.MyAppli.Services.FournisseurService;

@RestController
@RequestMapping("/Fournisseurs")
public class FournisseurController {
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@GetMapping("/GetAllFournisseurs")
	public List <Fournisseur> FindAllFournisseurs(){
		return fournisseurService.GetAllFournisserus();
	}
	
	@GetMapping("GetFournisseurById/{id}")
	public Fournisseur GetDepById (@PathVariable("id") long id) {
		return fournisseurService.FindByIdFournisseur(id);
	}
	
	@PostMapping("/AddFournisseur")
	public Fournisseur AddFournisseur(@Validated @RequestBody Fournisseur fournisseur){
			fournisseurService.SaveFournisseur(fournisseur);
			return fournisseur;
				
	}	
	
	@DeleteMapping("/DeleteFournisseur/{id}")
    public String removeFournisseur (@PathVariable Long id) 
    { fournisseurService.DeleteFournisseurById(id);
	      return " le Fournisseur titulaire de l'id" +id+ "a été supprimé avec succés ";}
	
	@PutMapping("/modifierFournisseur/{id}")
	public ResponseEntity <?> updatefournisseur(@PathVariable long id,@RequestBody Fournisseur fournisseur)
	{
		Fournisseur fournisseurExist=fournisseurService.FindByIdFournisseur(id);
		System.out.println(fournisseurExist.getId_fournisseur());
		fournisseurExist.setNom_fournisseur(fournisseur.getNom_fournisseur());
		fournisseurExist.setAdresse_fournisseur(fournisseur.getAdresse_fournisseur());
		fournisseurExist.setEmail_fournisseur(fournisseur.getEmail_fournisseur());
		fournisseurExist.setTel_fournisseur(fournisseur.getTel_fournisseur());
		Fournisseur savedfournisseur =fournisseurService.SaveFournisseur(fournisseurExist);
		return ResponseEntity.ok().body(savedfournisseur);
	}
	
	
}
