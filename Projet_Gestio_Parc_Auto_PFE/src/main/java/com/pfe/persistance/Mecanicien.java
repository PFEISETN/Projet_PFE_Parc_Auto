package com.pfe.persistance;

import java.util.HashSet;
import java.util.Set;

public class Mecanicien {

	private Integer numero_mec;
	private String nom_mecanicien;
	private String adresse;
	private String telephone;
	private Set<Entretien> entretienss = new HashSet<Entretien>(0);
	private String numero_tel1;
	private String numero_tel2;
	public Integer getNumero_mec() {
		return numero_mec;
	}
	public void setNumero_mec(Integer numero_mec) {
		this.numero_mec = numero_mec;
	}
	public String getNom_mecanicien() {
		return nom_mecanicien;
	}
	public void setNom_mecanicien(String nom_mecanicien) {
		this.nom_mecanicien = nom_mecanicien;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Set<Entretien> getEntretienss() {
		return entretienss;
	}
	public void setEntretienss(Set<Entretien> entretienss) {
		this.entretienss = entretienss;
	}
	public String getNumero_tel1() {
		return numero_tel1;
	}
	public void setNumero_tel1(String numero_tel1) {
		this.numero_tel1 = numero_tel1;
	}
	public String getNumero_tel2() {
		return numero_tel2;
	}
	public void setNumero_tel2(String numero_tel2) {
		this.numero_tel2 = numero_tel2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result
				+ ((entretienss == null) ? 0 : entretienss.hashCode());
		result = prime * result
				+ ((nom_mecanicien == null) ? 0 : nom_mecanicien.hashCode());
		result = prime * result
				+ ((numero_mec == null) ? 0 : numero_mec.hashCode());
		result = prime * result
				+ ((numero_tel1 == null) ? 0 : numero_tel1.hashCode());
		result = prime * result
				+ ((numero_tel2 == null) ? 0 : numero_tel2.hashCode());
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
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
		Mecanicien other = (Mecanicien) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (entretienss == null) {
			if (other.entretienss != null)
				return false;
		} else if (!entretienss.equals(other.entretienss))
			return false;
		if (nom_mecanicien == null) {
			if (other.nom_mecanicien != null)
				return false;
		} else if (!nom_mecanicien.equals(other.nom_mecanicien))
			return false;
		if (numero_mec == null) {
			if (other.numero_mec != null)
				return false;
		} else if (!numero_mec.equals(other.numero_mec))
			return false;
		if (numero_tel1 == null) {
			if (other.numero_tel1 != null)
				return false;
		} else if (!numero_tel1.equals(other.numero_tel1))
			return false;
		if (numero_tel2 == null) {
			if (other.numero_tel2 != null)
				return false;
		} else if (!numero_tel2.equals(other.numero_tel2))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
	public Mecanicien() {
		super();
	}
	
}
