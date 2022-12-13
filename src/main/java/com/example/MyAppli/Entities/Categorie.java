package com.example.MyAppli.Entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Categorie {

@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)	
private long id_categorie; 
@Column(name="Libelle")
private String lib_categorie;


@OneToMany(mappedBy="categorie")
List<Produit>ls_produits;
 




public Categorie(long id_categorie, String lib_categorie) {
	super();
	this.id_categorie = id_categorie;
	this.lib_categorie = lib_categorie;
	
	
	

}
public Categorie() {
	super();
	// TODO Auto-generated constructor stub
}
public long getId_categorie() {
	return id_categorie;
}
public void setId_categorie(long id_categorie) {
	this.id_categorie = id_categorie;
}
public String getLib_categorie() {
	return lib_categorie;
}
public void setLib_categorie(String lib_categorie) {
	this.lib_categorie = lib_categorie;
}
	
	
}
