package com.example.MyAppli.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyAppli.Entities.Categorie;
import com.example.MyAppli.Services.CategorieService;
@CrossOrigin("*")
@RestController
@RequestMapping("/Categories")
public class CategorieController {
	
	
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping("/GetAllCategories")
	public List <Categorie> FindAllCategories(){
		return categorieService.GetAllCategories();
	}
	
	@GetMapping("GetCategorieById/{id}")
	public Categorie GetDepById (@PathVariable("id") long id) {
		return categorieService.FindByIdCategorie(id);
	}
	
	@PostMapping("/AddCategorie")
	public Categorie AddCategorie(@Validated @RequestBody Categorie categorie){
			categorieService.SaveCategorie(categorie);
			return categorie;
				
	}	
	
	@DeleteMapping("/DeleteCategorie/{id}")
    public String removeCategorie (@PathVariable Long id) 
    { categorieService.DeleteCategorieById(id);
	      return " le Categorie titulaire de l'id" +id+ "a été supprimé avec succés ";}
	
	@PutMapping("/modifierCategorie/{id}")
	public ResponseEntity <?> updatecategorie(@PathVariable long id,@RequestBody Categorie categorie)
	{
		Categorie categorieExist=categorieService.FindByIdCategorie(id);
		System.out.println(categorieExist.getId_categorie());
		categorieExist.setLib_categorie(categorie.getLib_categorie());
		Categorie savedcategorie =categorieService.SaveCategorie(categorieExist);
		return ResponseEntity.ok().body(savedcategorie);
	}

}


