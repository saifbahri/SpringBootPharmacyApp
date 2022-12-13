package com.example.MyAppli.Entities;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class prod_fourPK implements Serializable{
	
	private static final long serialVersionUID = 1L;


	    private Long id_prd;

	    private Long id_fournisseur;
	    
	    

		public Long getId_prd() {
			return id_prd;
		}

		public void setId_prd(Long id_prd) {
			this.id_prd = id_prd;
		}

		public Long getId_fournisseur() {
			return id_fournisseur;
		}

		public void setId_fournisseur(Long id_fournisseur) {
			this.id_fournisseur = id_fournisseur;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id_fournisseur, id_prd);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			prod_fourPK other = (prod_fourPK) obj;
			return Objects.equals(id_fournisseur, other.id_fournisseur) && Objects.equals(id_prd, other.id_prd);
		}
		
		
	    
}
