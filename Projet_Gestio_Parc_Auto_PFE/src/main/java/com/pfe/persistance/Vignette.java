package com.pfe.persistance;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Vignette {

	private Integer numero_vignette;
	private Date date_debut;
	private float montant ;
	private Date date_fin;
	
	private Set<Vehicule> vehicule1 = new HashSet<Vehicule>(0);

	public Integer getNumero_vignette() {
		return numero_vignette;
	}

	public void setNumero_vignette(Integer numero_vignette) {
		this.numero_vignette = numero_vignette;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Set<Vehicule> getVehicule1() {
		return vehicule1;
	}

	public void setVehicule1(Set<Vehicule> vehicule1) {
		this.vehicule1 = vehicule1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((date_debut == null) ? 0 : date_debut.hashCode());
		result = prime * result
				+ ((date_fin == null) ? 0 : date_fin.hashCode());
		result = prime * result + Float.floatToIntBits(montant);
		result = prime * result
				+ ((numero_vignette == null) ? 0 : numero_vignette.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vignette other = (Vignette) obj;
		if (date_debut == null) {
			if (other.date_debut != null)
				return false;
		} else if (!date_debut.equals(other.date_debut))
			return false;
		if (date_fin == null) {
			if (other.date_fin != null)
				return false;
		} else if (!date_fin.equals(other.date_fin))
			return false;
		if (Float.floatToIntBits(montant) != Float
				.floatToIntBits(other.montant))
			return false;
		if (numero_vignette == null) {
			if (other.numero_vignette != null)
				return false;
		} else if (!numero_vignette.equals(other.numero_vignette))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vignette [numero_vignette=" + numero_vignette + ", date_debut="
				+ date_debut + ", montant=" + montant + ", date_fin="
				+ date_fin + "]";
	}
	
	
}
