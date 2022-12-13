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


import com.example.MyAppli.Entities.Pharmacien;

import com.example.MyAppli.Services.PharmacienService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Pharmaciens")
public class PharmacienController {
	
	
	@Autowired
	private PharmacienService pharmacienService;
	
	@GetMapping("/GetAllPharmaciens")
	public List <Pharmacien> FindAllPharmaciens(){
		return pharmacienService.GetAllPharmaciens();
	}
	
	@GetMapping("GetPharmacienById/{id}")
	public Pharmacien GetDepById (@PathVariable("id") long id) {
		return pharmacienService.FindByIdPharmacien(id);
	}
	
	
	@GetMapping("GetPharmacienByemail/{email_util}")
	public Pharmacien GetPharmacienByEmail (@PathVariable("email_util") String email_util) {
		return pharmacienService.FindBymailPharmacien(email_util);
	}
	
	
	@PostMapping("/AddPharmacien")
	public Pharmacien AddPharmacien(@Validated @RequestBody Pharmacien pharmacien){
			pharmacienService.SavePharmacien(pharmacien);
			return pharmacien;
				
	}	
	
	@DeleteMapping("/DeletePharmacien/{id}")
    public String removePharmacien (@PathVariable Long id) 
    { pharmacienService.DeletePharmacienById(id);
	      return " le Pharmacien titulaire de l'id" +id+ "a été supprimé avec succés ";}
	
	
	@PostMapping("/Login")
	public ResponseEntity <?> loginpharmacien(@RequestBody Pharmacien pharmacienData)
	{
		
		Pharmacien phar=pharmacienService.FindBymailPharmacien(pharmacienData.getEmail_util());
		if (phar.getPassword().equals(pharmacienData.getPassword()))
			
			 return ResponseEntity.ok(phar);
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
		  
	}

	
	@PutMapping("/modifierPharmacien/{id}")
	public ResponseEntity <?> updatepharmacien(@PathVariable long id,@RequestBody Pharmacien pharmacien)
	{
		Pharmacien pharmacienExist=pharmacienService.FindByIdPharmacien(id);
		System.out.println(pharmacienExist.getId_util());
		pharmacienExist.setNom_util(pharmacien.getNom_util());
		pharmacienExist.setPrenom_util(pharmacien.getPrenom_util());
		
	    pharmacienExist.setAdresse_util(pharmacien.getAdresse_util());
	    pharmacienExist.setEmail_util(pharmacien.getEmail_util());
	    pharmacienExist.setCodePostal_util(pharmacien.getCodePostal_util());
	    pharmacienExist.setDateNaissance_util(pharmacien.getDateNaissance_util());
	    
		Pharmacien savedpharmacien =pharmacienService.SavePharmacien(pharmacienExist);
		return ResponseEntity.ok().body(savedpharmacien);
	}

	
	
}
