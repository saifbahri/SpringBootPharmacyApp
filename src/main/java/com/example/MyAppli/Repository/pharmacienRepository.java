package com.example.MyAppli.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyAppli.Entities.Pharmacien;




	

public interface pharmacienRepository extends JpaRepository <Pharmacien,Long>{

	Pharmacien findByEmail(String email_util);
	
}



