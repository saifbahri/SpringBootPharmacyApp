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

import com.example.MyAppli.Entities.Laboratoire;
import com.example.MyAppli.Services.LaboratoireService;
@CrossOrigin("*")
@RestController
@RequestMapping("/Laboratoires")
public class LaboratoireController {

	
	@Autowired
	 private LaboratoireService laboratoireService;
	
	@GetMapping("/GetAllLaboratoires")
	   public List<Laboratoire>FindAll()
	       { return laboratoireService.GetAllLaboratoires(); }
	
	
	@GetMapping("/GetLaboratoireById/{id}")
       public Laboratoire GetLaboratoireById (@PathVariable Long id)
        { return laboratoireService.FindByIdLaboratoire(id); }
	
	
	
	@PostMapping("/AddLaboratoire")
    public Laboratoire AddLaboratoire (@Validated @RequestBody Laboratoire laboratoire)
           { laboratoireService.saveLaboratoire(laboratoire);
	           return laboratoire;}
	
	

	@DeleteMapping("/DeleteLaboratoire/{id}")
    public String removeLaboratoire (@PathVariable Long id) 
    { laboratoireService.DeleteLaboratoireById(id);
	      return " le laboratoire titulaire de l'ID " +id+ " a été supprimé avec succés";}
	
	
	//modifier un laboratoire 
	@PutMapping("/updateLaboratoire/{id}")
	  public ResponseEntity <?> updateLaboratoire(@PathVariable Long id, @RequestBody Laboratoire laboratoire){
		
		Laboratoire laboratoireExist=laboratoireService.FindByIdLaboratoire(id);
		System.out.println(laboratoireExist.getId_labo());
		
		laboratoireExist.setLib_labo(laboratoire.getLib_labo());
		
		
		Laboratoire savedlaboratoire=laboratoireService.saveLaboratoire(laboratoireExist);
		return ResponseEntity.ok().body(savedlaboratoire);
		}
	
}

