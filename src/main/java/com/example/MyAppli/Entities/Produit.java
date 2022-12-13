package com.example.MyAppli.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="Produits")

public class Produit  {


@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)	
private long id_prd; 
@Column(name="Libelle")
private String lib_prd;
@Column(name="Description")
private String description_prd;
@Column(name="Prix")
private Double prix_prd;
@JsonFormat(pattern="dd-MM-YYYY")
@Column(name="Date_ajout")
private Date dateAjout_prd;
@Column(name="Prix_livraison")
private Double prix_livr;
 
// jointure produits et laboratoire

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id_laboratoire")
private Laboratoire laboratoire; 

//jointure produits et categorie

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id_categorie")
private Categorie categorie;



//jointure produits et factures
@ManyToMany
@JoinTable(
name="facture_produit",
joinColumns=@JoinColumn(name="id_facture"),
inverseJoinColumns=@JoinColumn(name="id_produit")
)
List <Facture> ls_factures;

@ManyToMany(mappedBy="ls_produits")
List <Pharmacien> ls_pharmaciens;



@OneToMany(mappedBy="produit")
List<Commande_prd>ls_commandes;



public long getId_prd() {
	return id_prd;
}



public void setId_prd(long id_prd) {
	this.id_prd = id_prd;
}



public String getLib_prd() {
	return lib_prd;
}



public void setLib_prd(String lib_prd) {
	this.lib_prd = lib_prd;
}



public String getDescription_prd() {
	return description_prd;
}



public void setDescription_prd(String description_prd) {
	this.description_prd = description_prd;
}



public Double getPrix_prd() {
	return prix_prd;
}



public void setPrix_prd(Double prix_prd) {
	this.prix_prd = prix_prd;
}



public Date getDateAjout_prd() {
	return dateAjout_prd;
}



public void setDateAjout_prd(Date dateAjout_prd) {
	this.dateAjout_prd = dateAjout_prd;
}



public Double getPrix_livr() {
	return prix_livr;
}



public void setPrix_livr(Double prix_livr) {
	this.prix_livr = prix_livr;
}


public Laboratoire getLaboratoire() {
	return laboratoire;
}



public void setLaboratoire(Laboratoire laboratoire) {
	this.laboratoire = laboratoire;
}



public Categorie getCategorie() {
	return categorie;
}



public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}










public Produit(long id_prd, String lib_prd, String description_prd, Double prix_prd, Date dateAjout_prd,
		Double prix_livr, Laboratoire laboratoire, Categorie categorie) {
	super();
	this.id_prd = id_prd;
	this.lib_prd = lib_prd;
	this.description_prd = description_prd;
	this.prix_prd = prix_prd;
	this.dateAjout_prd = dateAjout_prd;
	this.prix_livr = prix_livr;
	this.laboratoire = laboratoire;
	this.categorie = categorie;
}



public Produit() {
	super();
	// TODO Auto-generated constructor stub
}



}
