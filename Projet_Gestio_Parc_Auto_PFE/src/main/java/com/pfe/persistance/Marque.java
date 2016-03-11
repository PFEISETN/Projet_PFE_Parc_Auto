package com.pfe.persistance;

import java.util.HashSet;
import java.util.Set;

public class Marque {

	private Integer numero_marque;
	private String nom_marque;
	
	private Set<Vehicule> vehicule2 = new HashSet<Vehicule>(0);
	private Set<Modele> modeles = new HashSet<Modele>(0);
	public Integer getNumero_marque() {
		return numero_marque;
	}
	public void setNumero_marque(Integer numero_marque) {
		this.numero_marque = numero_marque;
	}
	public String getNom_marque() {
		return nom_marque;
	}
	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}
	public Set<Vehicule> getVehicule2() {
		return vehicule2;
	}
	public void setVehicule2(Set<Vehicule> vehicule2) {
		this.vehicule2 = vehicule2;
	}
	public Set<Modele> getModeles() {
		return modeles;
	}
	public void setModeles(Set<Modele> modeles) {
		this.modeles = modeles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nom_marque == null) ? 0 : nom_marque.hashCode());
		result = prime * result
				+ ((numero_marque == null) ? 0 : numero_marque.hashCode());
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
		Marque other = (Marque) obj;
		if (nom_marque == null) {
			if (other.nom_marque != null)
				return false;
		} else if (!nom_marque.equals(other.nom_marque))
			return false;
		if (numero_marque == null) {
			if (other.numero_marque != null)
				return false;
		} else if (!numero_marque.equals(other.numero_marque))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Marque [numero_marque=" + numero_marque + ", nom_marque="
				+ nom_marque + "]";
	}
	
	
}

