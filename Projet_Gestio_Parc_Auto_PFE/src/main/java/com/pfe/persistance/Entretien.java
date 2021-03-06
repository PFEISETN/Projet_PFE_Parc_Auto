package com.pfe.persistance;

// Generated 29 f�vr. 2016 10:10:56 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Entretien generated by hbm2java
 */
public class Entretien  {

	private Integer numeroEntretien;
	private Typeentretien typeentretien;
	private Date dateArrive;
	private Date dateDepart;
	private Float coutTotal;
	private Double dureeEntretien;
	private Mecanicien mecanicien;
	
	public Mecanicien getMecanicien() {
		return mecanicien;
	}

	public void setMecanicien(Mecanicien mecanicien) {
		this.mecanicien = mecanicien;
	}

	public Entretien() {
	}

	public Entretien(Typeentretien typeentretien, Date dateArrive,
			Date dateDepart, Float coutTotal, Double dureeEntretien) {
		this.typeentretien = typeentretien;
		this.dateArrive = dateArrive;
		this.dateDepart = dateDepart;
		this.coutTotal = coutTotal;
		this.dureeEntretien = dureeEntretien;
	}

	public Integer getNumeroEntretien() {
		return this.numeroEntretien;
	}

	public void setNumeroEntretien(Integer numeroEntretien) {
		this.numeroEntretien = numeroEntretien;
	}

	public Typeentretien getTypeentretien() {
		return this.typeentretien;
	}

	public void setTypeentretien(Typeentretien typeentretien) {
		this.typeentretien = typeentretien;
	}

	public Date getDateArrive() {
		return this.dateArrive;
	}

	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	public Date getDateDepart() {
		return this.dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Float getCoutTotal() {
		return this.coutTotal;
	}

	public void setCoutTotal(Float coutTotal) {
		this.coutTotal = coutTotal;
	}

	public Double getDureeEntretien() {
		return dureeEntretien;
	}

	public void setDureeEntretien(Double dureeEntretien) {
		this.dureeEntretien = dureeEntretien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coutTotal == null) ? 0 : coutTotal.hashCode());
		result = prime * result
				+ ((dateArrive == null) ? 0 : dateArrive.hashCode());
		result = prime * result
				+ ((dateDepart == null) ? 0 : dateDepart.hashCode());
		result = prime * result
				+ ((dureeEntretien == null) ? 0 : dureeEntretien.hashCode());
		result = prime * result
				+ ((numeroEntretien == null) ? 0 : numeroEntretien.hashCode());
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
		Entretien other = (Entretien) obj;
		if (coutTotal == null) {
			if (other.coutTotal != null)
				return false;
		} else if (!coutTotal.equals(other.coutTotal))
			return false;
		if (dateArrive == null) {
			if (other.dateArrive != null)
				return false;
		} else if (!dateArrive.equals(other.dateArrive))
			return false;
		if (dateDepart == null) {
			if (other.dateDepart != null)
				return false;
		} else if (!dateDepart.equals(other.dateDepart))
			return false;
		if (dureeEntretien == null) {
			if (other.dureeEntretien != null)
				return false;
		} else if (!dureeEntretien.equals(other.dureeEntretien))
			return false;
		if (numeroEntretien == null) {
			if (other.numeroEntretien != null)
				return false;
		} else if (!numeroEntretien.equals(other.numeroEntretien))
			return false;
		return true;
	}

}
