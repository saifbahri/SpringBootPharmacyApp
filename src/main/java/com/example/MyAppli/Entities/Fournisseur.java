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
@Table(name="Fournisseurs")
public class Fournisseur {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long id_fournisseur; 
	@Column(name="Nom")
	private String nom_fournisseur;
	@Column(name="Adresse")
	private String adresse_fournisseur ;
	@Column(name="Email")
	private String email_fournisseur;
	@Column(name="Telephone")
	private int tel_fournisseur;
	
	

	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pharamcien")
	private Pharmacien pharmacien ; 
	
	
	@OneToMany(mappedBy="four")
	List<Facture>ls_factures;

	

@OneToMany(mappedBy="fournisseur")
List<Commande_prd>ls_commandes;
	
	

	public Fournisseur(long id_fournisseur, String nom_fournisseur, String adresse_fournisseur, String email_fournisseur,
		int tel_fournisseur, Pharmacien pharmacien) {
	super();
	this.id_fournisseur = id_fournisseur;
	this.nom_fournisseur = nom_fournisseur;
	this.adresse_fournisseur = adresse_fournisseur;
	this.email_fournisseur = email_fournisseur;
	this.tel_fournisseur = tel_fournisseur;
	this.pharmacien = pharmacien;
}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(long id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	public String getNom_fournisseur() {
		return nom_fournisseur;
	}
	public void setNom_fournisseur(String nom_fournisseur) {
		this.nom_fournisseur = nom_fournisseur;
	}
	public String getAdresse_fournisseur() {
		return adresse_fournisseur;
	}
	public void setAdresse_fournisseur(String adresse_fournisseur) {
		this.adresse_fournisseur = adresse_fournisseur;
	}
	public String getEmail_fournisseur() {
		return email_fournisseur;
	}
	public void setEmail_fournisseur(String email_fournisseur) {
		this.email_fournisseur = email_fournisseur;
	}
	public int getTel_fournisseur() {
		return tel_fournisseur;
	}
	public void setTel_fournisseur(int tel_fournisseur) {
		this.tel_fournisseur = tel_fournisseur;
	}
	public Pharmacien getPharmacien() {
		return pharmacien;
	}
	public void setPharmacien(Pharmacien pharmacien) {
		this.pharmacien = pharmacien;
	}
}
