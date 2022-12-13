package com.example.MyAppli.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Factures")
public class Facture {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long id_fact;
	@JsonFormat(pattern="dd-MM-YYYY")
	@Column(name="Date")
	private Date date_facture;
	@Column(name="Total_HT")
	private double tot_HT;
	@Column(name="Total_TVA")
	private double tot_TVA;
	@Column(name="Total_TTC")
	private double tot_TTC;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fournisseur")
	private Fournisseur four; 
	
	@ManyToMany(mappedBy="ls_factures")
	List <Produit> ls_produits;
	
	
	
	public Facture(long id_fact, Date date_facture, double tot_HT, double tot_TVA, double tot_TTC) {
		super();
		this.id_fact = id_fact;
		this.date_facture = date_facture;
		this.tot_HT = tot_HT;
		this.tot_TVA = tot_TVA;
		this.tot_TTC = tot_TTC;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId_fact() {
		return id_fact;
	}
	public void setId_fact(long id_fact) {
		this.id_fact = id_fact;
	}
	public Date getDate_facture() {
		return date_facture;
	}
	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}
	public double getTot_HT() {
		return tot_HT;
	}
	public void setTot_HT(double tot_HT) {
		this.tot_HT = tot_HT;
	}
	public double getTot_TVA() {
		return tot_TVA;
	}
	public void setTot_TVA(double tot_TVA) {
		this.tot_TVA = tot_TVA;
	}
	public double getTot_TTC() {
		return tot_TTC;
	}
	public void setTot_TTC(double tot_TTC) {
		this.tot_TTC = tot_TTC;
	}
		
}
