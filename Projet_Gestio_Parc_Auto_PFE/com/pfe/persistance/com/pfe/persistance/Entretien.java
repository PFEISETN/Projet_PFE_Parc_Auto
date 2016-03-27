package com.pfe.persistance;

// Generated 20 mars 2016 18:33:48 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entretien generated by hbm2java
 */
public class Entretien implements java.io.Serializable {

	private Integer numeroEntretien;
	private Typeentretien typeentretien;
	private Mecanicien mecanicien;
	private Date dateArrive;
	private Date dateDepart;
	private Float coutTotal;
	private Integer dureeEntretien;
	private Set<Mecanicien> mecaniciens = new HashSet<Mecanicien>(0);

	public Entretien() {
	}

	public Entretien(Typeentretien typeentretien, Mecanicien mecanicien,
			Date dateArrive, Date dateDepart, Float coutTotal,
			Integer dureeEntretien, Set<Mecanicien> mecaniciens) {
		this.typeentretien = typeentretien;
		this.mecanicien = mecanicien;
		this.dateArrive = dateArrive;
		this.dateDepart = dateDepart;
		this.coutTotal = coutTotal;
		this.dureeEntretien = dureeEntretien;
		this.mecaniciens = mecaniciens;
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

	public Mecanicien getMecanicien() {
		return this.mecanicien;
	}

	public void setMecanicien(Mecanicien mecanicien) {
		this.mecanicien = mecanicien;
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

	public Integer getDureeEntretien() {
		return this.dureeEntretien;
	}

	public void setDureeEntretien(Integer dureeEntretien) {
		this.dureeEntretien = dureeEntretien;
	}

	public Set<Mecanicien> getMecaniciens() {
		return this.mecaniciens;
	}

	public void setMecaniciens(Set<Mecanicien> mecaniciens) {
		this.mecaniciens = mecaniciens;
	}

}