package com.pfe.persistance;

// Generated 20 mars 2016 18:33:48 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Modele generated by hbm2java
 */
public class Modele implements java.io.Serializable {

	private Integer numeroModele;
	private String nomModele;
	private String typeModele;
	private Set<Marque> marques = new HashSet<Marque>(0);

	public Modele() {
	}

	public Modele(String nomModele, String typeModele, Set<Marque> marques) {
		this.nomModele = nomModele;
		this.typeModele = typeModele;
		this.marques = marques;
	}

	public Integer getNumeroModele() {
		return this.numeroModele;
	}

	public void setNumeroModele(Integer numeroModele) {
		this.numeroModele = numeroModele;
	}

	public String getNomModele() {
		return this.nomModele;
	}

	public void setNomModele(String nomModele) {
		this.nomModele = nomModele;
	}

	public String getTypeModele() {
		return this.typeModele;
	}

	public void setTypeModele(String typeModele) {
		this.typeModele = typeModele;
	}

	public Set<Marque> getMarques() {
		return this.marques;
	}

	public void setMarques(Set<Marque> marques) {
		this.marques = marques;
	}

}