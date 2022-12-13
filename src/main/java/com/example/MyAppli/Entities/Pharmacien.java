package com.example.MyAppli.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Pharmaciens")
public class Pharmacien {

@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)	
private long id_util; 
@Column(name="Nom")
private String nom_util;
@Column(name="password")

private String password; 


@Column(name="Prenom")
private String prenom_util;


@Column(name="Adresse")
private String adresse_util ;



@Column(name="Email")
private String email;


@Column(name="Code_Postal")
private int codePostal_util;


@JsonFormat(pattern="dd-MM-YYYY")
@Column(name="Date_Naissance")
private Date dateNaissance_util;



@OneToMany(mappedBy="pharmacien")
List<Fournisseur>ls_fournisseurs;


@ManyToMany
@JoinTable(
name="pharmacien_produit",
joinColumns=@JoinColumn(name="id_produit"),
inverseJoinColumns=@JoinColumn(name="id_pharmacien")
)
List <Produit> ls_produits;



public Pharmacien(long id_util, String nom_util, String prenom_util, String adresse_util, String email_util,
		int codePostal_util, Date dateNaissance_util) {
	super();
	this.id_util = id_util;
	this.nom_util = nom_util;
	this.prenom_util = prenom_util;
	this.adresse_util = adresse_util;
	this.email = email_util;
	this.codePostal_util = codePostal_util;
	this.dateNaissance_util = dateNaissance_util;
}

public Pharmacien() {
	super();
	// TODO Auto-generated constructor stub
}

public long getId_util() {
	return id_util;
}

public void setId_util(long id_util) {
	this.id_util = id_util;
}
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
public String getNom_util() {
	return nom_util;
}

public void setNom_util(String nom_util) {
	this.nom_util = nom_util;
}

public String getPrenom_util() {
	return prenom_util;
}

public void setPrenom_util(String prenom_util) {
	this.prenom_util = prenom_util;
}

public String getAdresse_util() {
	return adresse_util;
}

public void setAdresse_util(String adresse_util) {
	this.adresse_util = adresse_util;
}

public String getEmail_util() {
	return email;
}

public void setEmail_util(String email_util) {
	this.email = email_util;
}

public int getCodePostal_util() {
	return codePostal_util;
}

public void setCodePostal_util(int codePostal_util) {
	this.codePostal_util = codePostal_util;
}

public Date getDateNaissance_util() {
	return dateNaissance_util;
}

public void setDateNaissance_util(Date dateNaissance_util) {
	this.dateNaissance_util = dateNaissance_util;
}

public Pharmacien get() {
	// TODO Auto-generated method stub
	return null;
}



	
	
}
