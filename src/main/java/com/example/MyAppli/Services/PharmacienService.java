package com.example.MyAppli.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyAppli.Entities.Pharmacien;
import com.example.MyAppli.Repository.pharmacienRepository;

@Service
public class PharmacienService {

	@Autowired
	private pharmacienRepository  pharmacienRepository;	
	
	
	
	@Transactional
	public List<Pharmacien> GetAllPharmaciens(){
		return pharmacienRepository.findAll();
	}
	
	
	public  Pharmacien FindByIdPharmacien(long id) {
		return pharmacienRepository.findById(id).get();
	}
	
	public  Pharmacien FindBymailPharmacien(String email_util) {
		return pharmacienRepository.findByEmail(email_util);
	}
	
	
	public Pharmacien SavePharmacien( Pharmacien pharmacien)
	{
		return pharmacienRepository.save(pharmacien);
	}
	
	public void DeletePharmacienById (Long id) 
	 {Pharmacien pharmacien= pharmacienRepository.getOne(id);
	        pharmacienRepository.delete(pharmacien);}
	
	
	
}
