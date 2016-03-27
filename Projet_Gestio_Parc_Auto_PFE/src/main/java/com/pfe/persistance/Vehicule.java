package com.pfe.persistance;

public class Vehicule {

	private int immatricule;
	private int nombre_place;
	private Float puissance;
	private int kelometrage;
	private int capacite_bagage;
	private Etat  etat;
	private Categorie categorie;
	private Vignette vignette;
	private Assurance assurance;
	
	
	
	public Assurance getAssurance() {
		return assurance;
	}
	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}
	public int getImmatricule() {
		return immatricule;
	}
	public void setImmatricule(int immatricule) {
		this.immatricule = immatricule;
	}
	public int getNombre_place() {
		return nombre_place;
	}
	public void setNombre_place(int nombre_place) {
		this.nombre_place = nombre_place;
	}
	
	public Float getPuissance() {
		return puissance;
	}
	public void setPuissance(Float puissance) {
		this.puissance = puissance;
	}
	public int getKelometrage() {
		return kelometrage;
	}
	public void setKelometrage(int kelometrage) {
		this.kelometrage = kelometrage;
	}
	public int getCapacite_bagage() {
		return capacite_bagage;
	}
	public void setCapacite_bagage(int capacite_bagage) {
		this.capacite_bagage = capacite_bagage;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public Vignette getVignette() {
		return vignette;
	}
	public void setVignette(Vignette vignette) {
		this.vignette = vignette;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacite_bagage;
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + immatricule;
		result = prime * result + kelometrage;
		result = prime * result + nombre_place;
		result = prime * result
				+ ((puissance == null) ? 0 : puissance.hashCode());
		result = prime * result
				+ ((vignette == null) ? 0 : vignette.hashCode());
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
		Vehicule other = (Vehicule) obj;
		if (capacite_bagage != other.capacite_bagage)
			return false;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (immatricule != other.immatricule)
			return false;
		if (kelometrage != other.kelometrage)
			return false;
		if (nombre_place != other.nombre_place)
			return false;
		if (puissance == null) {
			if (other.puissance != null)
				return false;
		} else if (!puissance.equals(other.puissance))
			return false;
		if (vignette == null) {
			if (other.vignette != null)
				return false;
		} else if (!vignette.equals(other.vignette))
			return false;
		return true;
	}

	
	
}
