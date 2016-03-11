package com.pfe.persistance;

public class Modele {
	private Integer numero_modele;
	private String nom_modele;
	private String type_modele;
	
	private Marque marque;

	public Integer getNumero_modele() {
		return numero_modele;
	}

	public void setNumero_modele(Integer numero_modele) {
		this.numero_modele = numero_modele;
	}

	public String getNom_modele() {
		return nom_modele;
	}

	public void setNom_modele(String nom_modele) {
		this.nom_modele = nom_modele;
	}

	public String getType_modele() {
		return type_modele;
	}

	public void setType_modele(String type_modele) {
		this.type_modele = type_modele;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nom_modele == null) ? 0 : nom_modele.hashCode());
		result = prime * result
				+ ((numero_modele == null) ? 0 : numero_modele.hashCode());
		result = prime * result
				+ ((type_modele == null) ? 0 : type_modele.hashCode());
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
		Modele other = (Modele) obj;
		if (nom_modele == null) {
			if (other.nom_modele != null)
				return false;
		} else if (!nom_modele.equals(other.nom_modele))
			return false;
		if (numero_modele == null) {
			if (other.numero_modele != null)
				return false;
		} else if (!numero_modele.equals(other.numero_modele))
			return false;
		if (type_modele == null) {
			if (other.type_modele != null)
				return false;
		} else if (!type_modele.equals(other.type_modele))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modele [numero_modele=" + numero_modele + ", nom_modele="
				+ nom_modele + ", type_modele=" + type_modele + "]";
	}

	

}
