package com.example.MyAppli.Entities;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Commande_prd {
	
	@EmbeddedId
	private prod_fourPK proud_fourpk = new prod_fourPK();
	
	
	@ManyToOne
	@MapsId("id_prd")
	@JoinColumn(name="produit_id")
	private Produit produit;
	
	
	@ManyToOne
	@MapsId("id_fournisseur")
	@JoinColumn(name="fournisseur_id")
	private Fournisseur fournisseur;
	
	private int QuantiteFourni;
	private Date DateFourni;
	public prod_fourPK getProud_fourpk() {
		return proud_fourpk;
	}
	public void setProud_fourpk(prod_fourPK proud_fourpk) {
		this.proud_fourpk = proud_fourpk;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public int getQuantiteFourni() {
		return QuantiteFourni;
	}
	public void setQuantiteFourni(int quantiteFourni) {
		QuantiteFourni = quantiteFourni;
	}
	public Date getDateFourni() {
		return DateFourni;
	}
	public void setDateFourni(Date dateFourni) {
		DateFourni = dateFourni;
	}
	
	

}