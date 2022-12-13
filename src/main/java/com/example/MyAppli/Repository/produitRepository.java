package com.example.MyAppli.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.MyAppli.Entities.Produit;

public interface produitRepository extends JpaRepository <Produit ,Long> {

	
	@Query(value="select * from produits where id_laboratoire=:idDep",nativeQuery=true)
	public List<Produit> FindprodBymarque(@Param(value="idDep")Long id);
}
