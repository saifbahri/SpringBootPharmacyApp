package com.example.MyAppli.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyAppli.Entities.Facture;


public interface factureRepository extends JpaRepository <Facture,Long> {

}
