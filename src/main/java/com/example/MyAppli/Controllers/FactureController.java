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

import com.example.MyAppli.Entities.Facture;
import com.example.MyAppli.Services.FactureService;


@RestController
@RequestMapping("/Factures")
public class FactureController {

	
@Autowired
	private FactureService factureService;
	
	
	@GetMapping("/GetAllFactures")
	public List <Facture> FindAllFactures(){
		return factureService.GetAllFactures();
	}
	
	@GetMapping("GetFactureById/{id}")
	public Facture GetDepById (@PathVariable("id") long id) {
		return factureService.FindByIdFacture(id);
	}
	
	@PostMapping("/AddFacture")
	public Facture AddFacture(@Validated @RequestBody Facture facture){
			factureService.SaveFacture(facture);
			return facture;
				
	}	
	
	@DeleteMapping("/DeleteFacture/{id}")
    public String removeFacture (@PathVariable Long id) 
    { factureService.DeleteFactureById(id);
	      return " le Facture titulaire de l'id" +id+ "a été supprimé avec succés ";}
	
	@PutMapping("/modifierFacture/{id}")
	public ResponseEntity <?> updatefacture(@PathVariable long id,@RequestBody Facture facture)
	{
		Facture factureExist=factureService.FindByIdFacture(id);

		factureExist.setDate_facture(facture.getDate_facture());
		factureExist.setTot_HT(facture.getTot_HT());
		factureExist.setTot_TTC(facture.getTot_TTC());
		factureExist.setTot_TVA(facture.getTot_TVA());
		Facture savedfacture =factureService.SaveFacture(factureExist);
		return ResponseEntity.ok().body(savedfacture);
	}

}
