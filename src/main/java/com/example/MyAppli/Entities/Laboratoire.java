package com.example.MyAppli.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Laboratoires")
public class Laboratoire  {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long id_labo; 
	@Column(name="Libelle")
	private String lib_labo;
	
	@OneToMany(mappedBy="laboratoire")
	List<Produit>ls_produits;
	
	
	
	
	
	
	
	public Laboratoire(long id_labo, String lib_labo) {
		super();
		this.id_labo = id_labo;
		this.lib_labo = lib_labo;
	}
	public Laboratoire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId_labo() {
		return id_labo;
	}
	public void setId_labo(long id_labo) {
		this.id_labo = id_labo;
	}
	public String getLib_labo() {
		return lib_labo;
	}
	public void setLib_labo(String lib_labo) {
		this.lib_labo = lib_labo;
	}

}
