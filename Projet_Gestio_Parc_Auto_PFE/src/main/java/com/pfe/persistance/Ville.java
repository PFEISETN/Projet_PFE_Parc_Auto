package com.pfe.persistance;

import java.util.HashSet;
import java.util.Set;

public class Ville {
	private Integer id_ville;
	private String nom_ville;
	
	private Set<Personnel> personnels5= new HashSet<Personnel>(0);
	
	
	public Ville() {
		super();
	}
	public Ville(Integer id_ville, String nom_ville, Set<Personnel> personnels5) {
		super();
		this.id_ville = id_ville;
		this.nom_ville = nom_ville;
		this.personnels5 = personnels5;
	}
	public Integer getId_ville() {
		return id_ville;
	}
	public void setId_ville(Integer id_ville) {
		this.id_ville = id_ville;
	}
	public String getNom_ville() {
		return nom_ville;
	}
	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}
	
	
	public Set<Personnel> getPersonnels5() {
		return personnels5;
	}
	public void setPersonnels5(Set<Personnel> personnels5) {
		this.personnels5 = personnels5;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_ville == null) ? 0 : id_ville.hashCode());
		result = prime * result
				+ ((nom_ville == null) ? 0 : nom_ville.hashCode());
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
		Ville other = (Ville) obj;
		if (id_ville == null) {
			if (other.id_ville != null)
				return false;
		} else if (!id_ville.equals(other.id_ville))
			return false;
		if (nom_ville == null) {
			if (other.nom_ville != null)
				return false;
		} else if (!nom_ville.equals(other.nom_ville))
			return false;
		return true;
	}
	

}
